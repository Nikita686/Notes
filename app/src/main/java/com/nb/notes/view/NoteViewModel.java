package com.nb.notes.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.nb.notes.model.Note;
import com.nb.notes.repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;

    private LiveData<List<Note>> notes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        this.noteRepository = new NoteRepository(application);
        this.notes = noteRepository.getNotes();
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }

    public void insert(Note note){
        noteRepository.insert(note);
    }
}
