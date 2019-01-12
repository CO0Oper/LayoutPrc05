package com.example.android.layoutprc05;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class WordData {

//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo( name = "wordid")
//    @NonNull
//    public int mWordId;

    @NonNull
    @PrimaryKey
    @ColumnInfo( name = "word")
    public String mWord;

    @NonNull
    @ColumnInfo( name = "weight")
    public int mWeight;

    @NonNull
    @ColumnInfo( name = "pronunciation")
    public String mPronunciation;

    @ColumnInfo( name = "verb")
    public String mVerb;

    @ColumnInfo( name = "verbt")
    public String mVerbt;

    @ColumnInfo( name = "verbi")
    public String mVerbi;

    @ColumnInfo( name = "noun")
    public String mNoun;

    @ColumnInfo( name = "adj")
    public String mAdj;

    @ColumnInfo( name = "adv")
    public String mAdv;

    @ColumnInfo( name = "prep")
    public String mPrep;

    @ColumnInfo( name = "conj")
    public String mConj;

    @ColumnInfo( name = "sentence")
    public String mSentence;

    @ColumnInfo( name = "looklike")
    public String mLooklike;

    @ColumnInfo( name = "homoionym")
    public String mHomoionym;

    @ColumnInfo( name = "antonym")
    public String mAntonym;

    public WordData(String WORD, int WEIGHT, String PRONUNCIATION, String VERB, String VERBT,
                    String VERBI, String NOUN, String ADJ, String ADV, String PREP, String CONJ, String SENTENCE,
                    String LOOKLIKE, String HOMOIONYM, String ANTONYM ) {
        this.mWord = WORD;
        this.mWeight = WEIGHT;
        this.mPronunciation = PRONUNCIATION;
        this.mVerb = VERB;
        this.mVerbt = VERBT;
        this.mVerbi = VERBI;
        this.mNoun = NOUN;
        this.mAdj = ADJ;
        this.mAdv = ADV;
        this.mPrep = PREP;
        this.mConj = CONJ;
        this.mSentence = SENTENCE;
        this.mLooklike = LOOKLIKE;
        this.mHomoionym = HOMOIONYM;
        this.mAntonym = ANTONYM;

    }

    public WordData() {}
}
