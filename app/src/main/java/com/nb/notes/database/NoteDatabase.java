package com.nb.notes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nb.notes.dao.NoteDao;
import com.nb.notes.model.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();
    private static volatile NoteDatabase INSTANCE;

    public static NoteDatabase getInstance(final Context context){

        if (INSTANCE == null){
            synchronized (NoteDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), NoteDatabase.class, "notes")
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
