package com.company.helpcuba2jmix.web.screens.patientnote;

import com.haulmont.cuba.gui.screen.*;
import com.company.helpcuba2jmix.entity.PatientNote;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("helpcuba2jmix_PatientNote.browse")
@UiDescriptor("patient-note-browse.xml")
@LookupComponent("patientNotesTable")
@LoadDataBeforeShow
public class PatientNoteBrowse extends StandardLookup<PatientNote> {
}