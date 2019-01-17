package com.example.android.layoutprc05;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;

    private LiveData<List<WordData>> mAllwords;
    //private List<WordData> mAllwords;

    /**
     * Constructor that gets a handle to the database and initializes the
     * member variables.
     * @param application
     */
    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllwords = mWordDao.getAllwords();
    }

    LiveData<List<WordData>> getAllWords() {
        return mAllwords;
    }
//    List<WordData> getAllWords() {
//    return mAllwords;
//}

    /**
     * insert method, must call on non-ui thread.
     * @param word
     */
    public void insert (WordData word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    /**
     * Extra thread running database.
     */
    private static class insertAsyncTask extends AsyncTask<WordData, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WordData... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}