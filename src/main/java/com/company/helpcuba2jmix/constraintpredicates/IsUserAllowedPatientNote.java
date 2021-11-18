//package com.company.helpcuba2jmix.constraintpredicates;
//
//import com.haulmont.cuba.security.group.ConstraintPredicate;
//import com.company.helpcuba2jmix.entity.PatientNote;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class IsUserAllowedPatientNote implements ConstraintPredicate<PatientNote> {
//
//    private static final long serialVersionUID = -5783620738782747433L;
//
//    public boolean test(PatientNote note) {
//        IsUserAllowedNoteType isUserAllowedNoteType = new IsUserAllowedNoteType();
//
//        Logger log = LoggerFactory.getLogger(this.getClass());
//
//        log.info("Testing patient note {} (delegates to if note type is allowed)", note);
//        boolean result = isUserAllowedNoteType.test(note.getNoteType());
//
//        if (result) {
//            log.info("Note type allowed, so allowed");
//            return true;
//        } else {
//            log.info("Note type NOT allowed, so NOT allowed");
//            return false;
//        }
//    }
//}
