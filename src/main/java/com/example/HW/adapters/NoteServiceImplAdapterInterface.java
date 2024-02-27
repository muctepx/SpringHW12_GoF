package com.example.HW.adapters;

import com.example.HW.domain.Note;

import java.util.Optional;

public interface NoteServiceImplAdapterInterface {
    Optional<Note> deleteNote(Long id);
}
