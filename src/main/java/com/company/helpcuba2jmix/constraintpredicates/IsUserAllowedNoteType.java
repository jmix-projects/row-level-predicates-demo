//package com.company.helpcuba2jmix.constraintpredicates;
//
//import com.company.helpcuba2jmix.entity.User;
//import com.haulmont.cuba.core.global.AppBeans;
//import com.haulmont.cuba.core.global.UserSessionSource;
//import com.haulmont.cuba.security.entity.Role;
//import com.haulmont.cuba.security.entity.RoleType;
//import com.haulmont.cuba.security.entity.UserRole;
//import com.haulmont.cuba.security.global.UserSession;
//import com.haulmont.cuba.security.group.ConstraintPredicate;
//import com.company.helpcuba2jmix.entity.NoteType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
//public class IsUserAllowedNoteType implements ConstraintPredicate<NoteType> {
//
//    private static final long serialVersionUID = 3432561532167254772L;
//
//    @Override
//    public boolean test(NoteType noteType) {
//        UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);
//        UserSession session = userSessionSource.getUserSession();
//        User user = session.getCurrentOrSubstitutedUser();
//
//        Logger log = LoggerFactory.getLogger(this.getClass());
//
//        log.info("Testing note type '{}'", noteType.getDescription());
//
//        for (UserRole ur : user.getUserRoles()) {
//            if (ur.getRole() != null && ur.getRole().getType().equals(RoleType.SUPER)) {
//                log.info("User has superuser privileges; allowing");
//                return true;
//            }
//        }
//
//        List<User> usersAllowed = noteType.getAllowedUsers();
//
//        List<Role> rolesAllowed = noteType.getAllowedRoles();
//
//        if ((usersAllowed == null || usersAllowed.isEmpty()) && (rolesAllowed == null || rolesAllowed.isEmpty())) {
//            log.info("No specific users and no roles in allowed lists, therefore all users allowed");
//            return true;
//        } else {
//            if (usersAllowed != null && !usersAllowed.isEmpty()) {
//                log.info("Checking for specific users allowed");
//                log.info("Users allowed:");
//                for (User u : usersAllowed) {
//                    log.info("  {}", u.getLogin());
//                    if (user.getLogin().equals(u.getLogin())) {
//                        log.info("  above user is the current user; allowing");
//                        return true;
//                    }
//                }
//            }
//            log.info("Didn't find user in list (or user list is empty); checking roles");
//
//            if (rolesAllowed != null && !rolesAllowed.isEmpty()) {
//                log.info("Roles allowed");
//                for (Role r : rolesAllowed) {
//                    log.info("  {}", r.getName());
//                    for (UserRole role : user.getUserRoles()) {
//                        if (role.getRole() != null) {
//                            log.info("Role: [{}]", role.getRole());
//                            log.info("Role name: [{}]", role.getRole().getName());
//                            if (role.getRole().getName().equals(r.getName())) {
//                                log.info("  current user has above role; allowing");
//                                return true;
//                            }
//                        }
//                    }
//                }
//            }
//
//            log.info("Current user not found in user or role list; not allowing");
//            return false;
//        }
//    }
//}
