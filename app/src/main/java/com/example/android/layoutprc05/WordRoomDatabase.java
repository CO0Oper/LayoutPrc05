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

            String word, pronunciation, verb, verbt, verbi, noun,
                    adj, adv, prep, conj, sentence, looklike, homoionym, antonym;
            int weight;

             //c = new CSVreader();

            mDao.deleteAll(wordData);

            //WordCons wo = new WordCons();

//            for(int i = 0; i < c.getSize(); i++ ){
//                wo = c.getData(i);
//                word = wo.word;
//                weight = wo.weight;
//                pronunciation = wo.pronunciation;
//                verb = wo.verb;
//                verbt = wo.verbt;
//                verbi = wo.verbi;
//                noun = wo.noun;
//                adj = wo.adj;
//                adv = wo.adv;
//                prep = wo.prep;
//                conj = wo.conj;
//                sentence = wo.sentence;
//                looklike = wo.looklike;
//                homoionym = wo.homoionym;
//                antonym = wo.antonym;
//
//                WordData worddb = new WordData(word, weight, pronunciation, verb, verbt, verbi,
//                        noun, adj, adv, prep, conj, sentence, looklike, homoionym,antonym);
//
//                mDao.insert(worddb);
//
//            }

//            WordData word2 = new WordData("Test", 1, "pro", "Testv",  "Testt", "Testi", "Testn",
//                    "Testa", "TestAdv", "Prep", "Conj", "sentence", "Looklike", "homoinym", "ho");
//
////            mDao.insertBycsv("Test", 1, "pro", "Testv",  "Testt", "Testi", "Testn",
////                    "Testa", "TestAdv", "Prep", "Conj", "sentence", "Looklike", "homoinym", "ho");
//            mDao.insert(word2);

//        WordData word = new WordData("Hello");
//        mDao.insert(word);
//        wordDA = new Word("World");
//        mDao.insert(word);

//
            c.getList();

            for(int i = 0; i < c.getSize(); i++) {
                WordData word3 = new WordData(i,
                     c. getListA( 1).word, c. getListA( 1).weight,
                        c. getListA( 1).pronunciation, c. getListA( 1).verb,
                        c. getListA( 1).verbt, c. getListA( 1).verbi,
                        c. getListA( 1).noun, c. getListA( 1).adj,
                        c. getListA( 1).adv, c. getListA( 1).prep,
                        c. getListA( 1).conj, c. getListA( 1).sentence,
                        c. getListA( 1).looklike, c. getListA( 1).homoionym,
                        c. getListA( 1).antonym
                );
                mDao.insert(word3);
            }

            return null;
        }


    }





}
