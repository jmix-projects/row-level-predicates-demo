package com.company.helpcuba2jmix.security;

import com.company.helpcuba2jmix.entity.NoteType;
import com.company.helpcuba2jmix.entity.PatientNote;
import com.company.helpcuba2jmix.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.model.RowLevelPredicate;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import io.jmix.securitydata.entity.ResourceRoleEntity;
import org.springframework.security.core.GrantedAuthority;

@RowLevelRole(
        name = "Restricted access to Notes",
        code = "restricted-notes")
public interface NotesRowLevelRole {

    @PredicateRowLevelPolicy(entityClass = NoteType.class, actions = RowLevelPolicyAction.READ)
    default RowLevelPredicate<NoteType> isNoteTypeAvailable(CurrentAuthentication currentAuthentication) {
        return noteType -> {
            User user = (User) currentAuthentication.getUser();
            if (noteType.getAllowedUsers().contains(user)) {
                return true;
            }
            for (GrantedAuthority authority : currentAuthentication.getAuthentication().getAuthorities()) {
                boolean match = noteType.getAllowedRoles().stream()
                        .map(ResourceRoleEntity::getName)
                        .anyMatch(s -> s.equals(authority.getAuthority()));
                if (match) {
                    return true;
                }
            }
            return false;
        };
    }

    @PredicateRowLevelPolicy(entityClass = PatientNote.class, actions = RowLevelPolicyAction.READ)
    default RowLevelPredicate<PatientNote> isNoteAvailable(CurrentAuthentication currentAuthentication) {
        return note -> {
            RowLevelPredicate<NoteType> noteTypeAvailable = isNoteTypeAvailable(currentAuthentication);
            return noteTypeAvailable.test(note.getNoteType());
        };
    }
}
