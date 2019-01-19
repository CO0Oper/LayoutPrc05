package com.example.android.layoutprc05;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {WordData.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    private static volatile WordRoomDatabase INSTANCE;

    private WordCons wordcons;

    //Define the DAOs that work with the database.
    //Provide an abstract "getter" method for each @Dao.
    public abstract WordDao wordDao();

    static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database").
                            fallbackToDestructiveMigration()
                            .addCallback(mRoomDatabaseCallback).
                                    build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback mRoomDatabaseCallback = new
            RoomDatabase.Callback(){
        @Override
            public void onOpen (@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
            };

    public static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;

        WordData wordData;

        CSVreader c = new CSVreader();

        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.wordDao();

        }

        @Override
        protected Void doInBackground(final Void... params) {

            int id, weight, master;

            mDao.deleteAll(wordData);

//        WordData word = new WordData("Hello");
//        mDao.insert(word);
//        wordDA = new Word("World");
//        mDao.insert(word);

            c.getList();
            for(int i = 0; i < c.getSize(); i++) {
                WordData word3 = new WordData(i,
                     c. getListA( i).weight,
                        0
                );
                mDao.insert(word3);
            }
            return null;
        }
    }

    public String getDBpath(){
        return getDBpath();
    }
}
