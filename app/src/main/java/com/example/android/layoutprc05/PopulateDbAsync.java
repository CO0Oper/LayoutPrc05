package com.example.android.layoutprc05;

import android.os.AsyncTask;

public class PopulateDbAsync extends AsyncTask <Void, Void, Void> {

    private final WordDao mDao;

    WordData wordData;

    populateDbAsync(WordRoomDatabase db) {
        mDao = db.wordDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteAll(wordData);
//        WordData word = new WordData("Hello");
//        mDao.insert(word);
//        wordDA = new Word("World");
//        mDao.insert(word);
        return null;
    }

}
