//package com.company.helpcuba2jmix.listeners;
//
//import com.company.helpcuba2jmix.constraintpredicates.IsUserAllowedNoteType;
//import com.company.helpcuba2jmix.constraintpredicates.IsUserAllowedPatientNote;
//import com.company.helpcuba2jmix.entity.NoteType;
//import com.company.helpcuba2jmix.entity.PatientNote;
//import com.haulmont.cuba.security.app.group.AccessConstraintsBuilder;
//import com.haulmont.cuba.security.auth.events.UserLoggedInEvent;
//import com.haulmont.cuba.security.global.UserSession;
//import com.haulmont.cuba.security.group.ConstraintsContainer;
//import io.jmix.security.model.EntityPolicyAction;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import java.util.EnumSet;
//
//@Component("helpcuba2jmix_AuthenticationEventListener")
//public class AuthenticationEventListener {
//    @EventListener
//    public void userLoggedIn(UserLoggedInEvent event) {
//        EnumSet<EntityPolicyAction> operationsRUD = EnumSet.of(EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.DELETE);
//
//        Logger log = LoggerFactory.getLogger(this.getClass());
//
//        IsUserAllowedNoteType isUserAllowedNoteType = new IsUserAllowedNoteType();
//        IsUserAllowedPatientNote isUserAllowedPatientNote = new IsUserAllowedPatientNote();
//
//        UserSession session = event.getAuthenticationDetails().getSession();
//
//        log.info("userLoggedIn > user: {} / {} ({})", session.getCurrentOrSubstitutedUser(), session.getCurrentOrSubstitutedUser().getLogin(), session.getCurrentOrSubstitutedUser().getName());
//
//        ConstraintsContainer newConstraints = AccessConstraintsBuilder.create()
//                .join(session.getConstraints())
//                .withInMemory(NoteType.class, operationsRUD, isUserAllowedNoteType)
//                .withInMemory(PatientNote.class, operationsRUD, isUserAllowedPatientNote)
//                .build();
//
//        session.setConstraints(newConstraints);
//    }
//}
