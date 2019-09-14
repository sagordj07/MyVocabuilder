package com.room.myvocabuilder;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.telecom.Call;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Database(entities={WordTable.class},version=1 )
public abstract class WordDatabase extends RoomDatabase {

    public static WordDatabase instance;
    public abstract WordTableDao wordTableDao();


    public static synchronized WordDatabase getInstance(Context context){

        if(instance==null){

            instance= Room.databaseBuilder(context.getApplicationContext(),
                    WordDatabase.class,"word_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallBack=new RoomDatabase.Callback()
    {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateDbAsynTask(instance).execute();
        }


    };

    private static class populateDbAsynTask extends AsyncTask<Void,Void,Void>
    {
        private WordTableDao wordTableDao;

        private String date;
        private String time;


        public  populateDbAsynTask(WordDatabase db) { wordTableDao=db.wordTableDao();}

        @Override
        protected Void doInBackground(Void... voids) {

            Calendar calforDate= Calendar.getInstance();
            SimpleDateFormat currentDateFoemat= new SimpleDateFormat("MMM dd,yyyy");
            date=currentDateFoemat.format(calforDate.getTime());

            Calendar calForTime= Calendar.getInstance();
            SimpleDateFormat currentTimeformat= new SimpleDateFormat("hh:mm a");
            time=currentTimeformat.format(calForTime.getTime());

            wordTableDao.insert(new WordTable("example","demo","Sentence",date,time));
            wordTableDao.insert(new WordTable("example2","demo2","Sentence2",date,time));
            wordTableDao.insert(new WordTable("example3","demo3","Sentence4",date,time));

            return null;
        }
    }

}
