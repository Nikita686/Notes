package com.nb.notes.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.nb.notes.model.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Note note);
    @Query("SELECT * FROM notes order by date_updated")
    LiveData<List<Note>> getAllNotes();
}
