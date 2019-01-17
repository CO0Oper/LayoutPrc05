package com.example.android.layoutprc05;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WordData worddata);

//    @Insert
//    void insertBycsv(String WORD, int WEIGHT, String PRONUNCIATION, String VERB, String VERBT,
//                     String VERBI, String NOUN, String ADJ, String ADV, String PREP, String CONJ, String SENTENCE,
//                     String LOOKLIKE, String HOMOIONYM, String ANTONYM );

    @Query("SELECT mWeight FROM WORD_TABLE ORDER BY mWeight ")
    Cursor getWeight();

    @Delete
    void deleteAll(WordData wordData);

    @Query("SELECT * FROM WORD_TABLE ORDER BY mWeight desc")
    LiveData<List<WordData>> getWordbyweight();
    //List<WordData> getAllbyweight();

    @Query("select * from WORD_TABLE")
    LiveData<List<WordData>> getAllwords();

}
