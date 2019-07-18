package com.nb.notes.model;



import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

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
    private LocalDateTime dateUpdated;
    private String text;
}
