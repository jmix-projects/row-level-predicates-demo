package com.company.helpcuba2jmix.web.screens.notetype;

import com.haulmont.cuba.gui.screen.*;
import com.company.helpcuba2jmix.entity.NoteType;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("helpcuba2jmix_NoteType.edit")
@UiDescriptor("note-type-edit.xml")
@EditedEntityContainer("noteTypeDc")
@LoadDataBeforeShow
public class NoteTypeEdit extends StandardEditor<NoteType> {
}