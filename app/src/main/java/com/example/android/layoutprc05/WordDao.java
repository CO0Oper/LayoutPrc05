package com.example.android.layoutprc05;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(WordData worddata);

    @Query("SELECT wordId, weight FROM WORD_TABLE ORDER BY weight ASC")
    void getWeight();

    @Delete
    void deleteAll(WordData wordData);

    @Query("SELECT * FROM WORD_TABLE ORDER BY weight ASC")
    LiveData<List<WordData>> getAllbyweight();



}
