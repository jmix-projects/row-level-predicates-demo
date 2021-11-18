package com.company.helpcuba2jmix.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "HELPCUBA2JMIX_PATIENT_NOTE")
@Entity(name = "helpcuba2jmix_PatientNote")
public class PatientNote extends StandardEntity {
    private static final long serialVersionUID = 7060231230684868881L;

    @NotNull
    @Column(name = "PATIENT_NAME", nullable = false)
    private String patientName;

    @Lob
    @Column(name = "NOTE")
    private String note;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NOTE_TYPE_ID")
    private NoteType noteType;

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}