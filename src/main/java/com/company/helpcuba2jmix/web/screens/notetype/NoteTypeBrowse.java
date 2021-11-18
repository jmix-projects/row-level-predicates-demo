package com.company.helpcuba2jmix.web.screens.notetype;

import com.haulmont.cuba.gui.screen.*;
import com.company.helpcuba2jmix.entity.NoteType;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("helpcuba2jmix_NoteType.browse")
@UiDescriptor("note-type-browse.xml")
@LookupComponent("noteTypesTable")
@LoadDataBeforeShow
public class NoteTypeBrowse extends StandardLookup<NoteType> {
}