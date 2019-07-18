package com.nb.notes.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.nb.notes.dao.NoteDao;
import com.nb.notes.database.NoteDatabase;
import com.nb.notes.model.Note;

import java.util.List;

import lombok.Getter;

public class NoteRepository {

    private NoteDao noteDao;
    @Getter
    private LiveData<List<Note>> notes;

    public NoteRepository(Application application) {
        NoteDatabase db = NoteDatabase.getInstance(application);
        noteDao = db.noteDao();
        notes = noteDao.getAllNotes();
    }

    public void insert(Note note){
        new insertAsyncTask(noteDao).execute(note);
    }

    private static class insertAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao mAsyncTaskDao;

        insertAsyncTask(NoteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Note... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
