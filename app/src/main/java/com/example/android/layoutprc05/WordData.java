package com.example.android.layoutprc05;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "WORD_TABLE")
public class WordData {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo( name = "id")
    //@NonNull
    public int mId;

    //@NonNull
    @ColumnInfo( name = "weight")
    public int mWeight;

    //@NonNull
    @ColumnInfo( name = "master")
    public int mMaster;


    public WordData() {}

    public WordData(int id , int weight, int master) {
        this.mId = id;
        this.mWeight = weight;
        this.mMaster = master;
    }


    //@NonNull
    public int getID() {return this.mId; }

    //@NonNull
    public int getWeight() { return this.mWeight; }

   // @NonNull
    public int getMaster() { return this.mMaster; }




}
