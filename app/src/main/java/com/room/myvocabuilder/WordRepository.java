package com.room.myvocabuilder;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {


    private WordTableDao wordTableDao;
    private LiveData<List<WordTable>> getAllwords;

    public WordRepository(Application application){

        WordDatabase wordDatabase= WordDatabase.getInstance(application);

        wordTableDao=wordDatabase.wordTableDao();
        getAllwords=wordTableDao.getAllword();

    }

    public void insert(WordTable wordTable)
    {
        new insertAyncTask(wordTableDao).execute(wordTable);
    }

    public void update(WordTable wordTable)
    {
        new updateAyncTask(wordTableDao).execute(wordTable);
    }

    public void delete(WordTable wordTable)
    {
        new deleteAyncTask(wordTableDao).execute(wordTable);

    }

    public void deleteAllWord()
    {
            new deleteAllAyncTask(wordTableDao).execute();
    }

    public LiveData<List<WordTable>> getGetAllwords() {

        return getAllwords;
    }



    public  static  class insertAyncTask extends AsyncTask<WordTable,Void,Void>{

        private WordTableDao wordTableDao;
        private insertAyncTask(WordTableDao wordTableDao)
        {
            this.wordTableDao=wordTableDao;
        }


        @Override
        protected Void doInBackground(WordTable... wordTables) {
                wordTableDao.insert(wordTables[0]);

            return null;
        }
    }
    public  static  class updateAyncTask extends AsyncTask<WordTable,Void,Void>{

        private WordTableDao wordTableDao;
        private updateAyncTask(WordTableDao wordTableDao)
        {
            this.wordTableDao=wordTableDao;
        }


        @Override
        protected Void doInBackground(WordTable... wordTables) {
            wordTableDao.update(wordTables[0]);

            return null;
        }
    }
    public  static  class deleteAyncTask extends AsyncTask<WordTable,Void,Void>{

        private WordTableDao wordTableDao;
        private deleteAyncTask(WordTableDao wordTableDao)
        {
            this.wordTableDao=wordTableDao;
        }


        @Override
        protected Void doInBackground(WordTable... wordTables) {
            wordTableDao.delete(wordTables[0]);

            return null;
        }
    }

    public  static  class deleteAllAyncTask extends AsyncTask<Void,Void,Void>{

        private WordTableDao wordTableDao;
        private deleteAllAyncTask(WordTableDao wordTableDao)
        {
            this.wordTableDao=wordTableDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            wordTableDao.deleteAllword();

            return null;
        }
    }


}
