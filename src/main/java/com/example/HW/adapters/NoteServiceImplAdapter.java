package com.example.HW.adapters;

import com.example.HW.aspect.TrackUserAction;
import com.example.HW.domain.Note;
import com.example.HW.service.NoteServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Service
@AllArgsConstructor
public class NoteServiceImplAdapter implements NoteServiceImplAdapterInterface {

    private NoteServiceImpl noteServiceImpl;

    @Override
    @TrackUserAction
    public Optional<Note> deleteNote(Long id) {
        Optional<Note> noteById = noteServiceImpl.getNoteById(id);
        if (noteById.isPresent()) {
            noteById.ifPresent(noteServiceImpl.getNoteRepository()::delete);
        }
        return noteById;
    }
}