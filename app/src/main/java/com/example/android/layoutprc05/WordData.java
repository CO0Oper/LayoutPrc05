package com.example.android.layoutprc05;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "WORD_TABLE")
public class WordData {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo( name = "id")
    //@NonNull
    public int mWordId;

    //@NonNull
    @ColumnInfo( name = "word")
    public String mWord;

    //@NonNull
    @ColumnInfo( name = "mWeight")
    public int mWeight;

    //@NonNull
    @ColumnInfo( name = "mPronunciation")
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

    @NonNull
    public int getWeight() { return this.mWeight; }

    @NonNull
    public int getId() { return this.mWordId;}

    @ColumnInfo( name = "sentence")
    public String mSentence;

    @ColumnInfo( name = "looklike")
    public String mLooklike;

    @ColumnInfo( name = "homoionym")
    public String mHomoionym;

    @ColumnInfo( name = "antonym")
    public String mAntonym;

    public WordData() {}

    public WordData(int ID , String WORD, int WEIGHT, String PRONUNCIATION, String VERB, String VERBT,
                    String VERBI, String NOUN, String ADJ, String ADV, String PREP, String CONJ, String SENTENCE,
                    String LOOKLIKE, String HOMOIONYM, String ANTONYM ) {
        this.mWordId = ID;
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


    //@NonNull
    public String getSentence() {return this.mSentence; }

    //@NonNull
    public String getLooklike() { return this.mLooklike; }

   // @NonNull
    public String getHomoionym() { return this.mHomoionym; }

    //@NonNull
    public String getAntonym() { return this.mAntonym; }

   // @NonNull
    public String getConj() { return this.mConj; }

    //@NonNull
    public String getPrep() { return this.mPrep; }

    //@NonNull
    public String getAdv() { return this.mAdv; }


   // @NonNull
    public String getAdj() { return this.mAdj; }


   // @NonNull
    public String getNoun() { return this.mNoun; }


    //@NonNull
    public String getVerbi() { return this.mVerbi; }


    //@NonNull
    public String getVerbt() { return this.mVerbt; }


   // @NonNull
    public String getVerb() { return this.mVerb; }

   // @NonNull
    public String getPronunciation() { return this.mPronunciation; }

   // @NonNull
    public String getWord() { return this.mWord; }

}
