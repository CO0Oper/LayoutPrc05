package com.example.android.layoutprc05;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {WordData.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    private static volatile WordRoomDatabase INSTANCE;

    //Define the DAOs that work with the database.
    //Provide an abstract "getter" method for each @Dao.
    public abstract WordDao wordDao();

    static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database").build();

                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new
            RoomDatabase.Callback(){
        @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new PopulateDbAsync(INSTANCE).execute();
        }
            };




}
