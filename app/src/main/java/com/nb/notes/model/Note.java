package com.nb.notes.model;



import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Builder;
import lombok.Data;

@Entity(tableName = "notes")
@Data
@Builder
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    @ColumnInfo(name = "date_updated")
    private String dateUpdated;
    private String text;

    public Note(int id, String name, String dateUpdated, String text) {
        this.id = id;
        this.name = name;
        this.dateUpdated = dateUpdated;
        this.text = text;
    }
}
