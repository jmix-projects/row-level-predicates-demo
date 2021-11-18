package com.company.helpcuba2jmix.web.screens.patientnote;

import com.haulmont.cuba.gui.screen.*;
import com.company.helpcuba2jmix.entity.PatientNote;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("helpcuba2jmix_PatientNote.edit")
@UiDescriptor("patient-note-edit.xml")
@EditedEntityContainer("patientNoteDc")
@LoadDataBeforeShow
public class PatientNoteEdit extends StandardEditor<PatientNote> {
}