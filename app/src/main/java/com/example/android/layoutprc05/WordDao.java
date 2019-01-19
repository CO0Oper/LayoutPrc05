package com.example.android.layoutprc05;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(WordData worddata);

    @Delete
    void deleteAll(WordData wordData);

    @Query("SELECT weight FROM WORD_TABLE ORDER BY weight ASC")
    Cursor getWeight();

    @Query("SELECT * FROM WORD_TABLE ORDER BY weight ASC")
    LiveData<List<WordData>> getAllbyweight();
    //List<WordData> getAllbyweight();

    @Query("SELECT * FROM WORD_TABLE ORDER BY id ASC")
    LiveData<List<WordData>> getAllbyID();

}
