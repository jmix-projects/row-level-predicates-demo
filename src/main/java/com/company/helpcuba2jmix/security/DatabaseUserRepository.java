package com.company.helpcuba2jmix.security;

import com.company.helpcuba2jmix.entity.NoteType;
import com.company.helpcuba2jmix.entity.PatientNote;
import com.company.helpcuba2jmix.entity.User;
import io.jmix.security.authentication.RoleGrantedAuthority;
import io.jmix.security.model.RowLevelPolicy;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.model.RowLevelPredicate;
import io.jmix.security.model.RowLevelRole;
import io.jmix.securitydata.entity.ResourceRoleEntity;
import io.jmix.securitydata.user.AbstractDatabaseUserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Primary
@Component("helpcuba2jmix_UserRepository")
public class DatabaseUserRepository extends AbstractDatabaseUserRepository<User> {

    @Override
    protected Class<User> getUserClass() {
        return User.class;
    }

    @Override
    protected void initSystemUser(User systemUser) {
        Collection<GrantedAuthority> authorities = getGrantedAuthoritiesBuilder()
                .addResourceRole(FullAccessRole.CODE)
                .build();
        systemUser.setAuthorities(authorities);
    }

    @Override
    protected void initAnonymousUser(User anonymousUser) {
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = super.loadUserByUsername(username);
        // keep admin as is
        if (user.getUsername().equals("admin")) {
            return user;
        }

        // create a role
        RowLevelRole role = new RowLevelRole();
        role.setName("notes-access");
        role.setCode("notes-access");

        // create predicates
        RowLevelPredicate<Object> noteTypePredicate = entity -> {
            NoteType noteType = (NoteType) entity;
            if (noteType.getAllowedUsers().contains(user)) {
                return true;
            }
            for (GrantedAuthority authority : user.getAuthorities()) {
                boolean match = noteType.getAllowedRoles().stream()
                        .map(ResourceRoleEntity::getName)
                        .anyMatch(s -> s.equals(authority.getAuthority()));
                if (match) {
                    return true;
                }
            }
            return false;
        };
        RowLevelPredicate<Object> notePredicate = entity -> {
            PatientNote note = (PatientNote) entity;
            return noteTypePredicate.test(note.getNoteType());
        };

        // create policies using predicates
        RowLevelPolicy noteTypePolicy = new RowLevelPolicy("helpcuba2jmix_NoteType",
                RowLevelPolicyAction.READ,
                noteTypePredicate,
                Collections.emptyMap()
        );
        RowLevelPolicy notePolicy = new RowLevelPolicy("helpcuba2jmix_PatientNote",
                RowLevelPolicyAction.READ,
                notePredicate,
                Collections.emptyMap()
        );

        // add policies to the role
        role.setRowLevelPolicies(Arrays.asList(noteTypePolicy, notePolicy));

        // put the role to the list of user's authorities
        List<GrantedAuthority> authorities = new ArrayList<>(user.getAuthorities());
        authorities.add(RoleGrantedAuthority.ofRowLevelRole(role));
        user.setAuthorities(authorities);

        return user;
    }
}