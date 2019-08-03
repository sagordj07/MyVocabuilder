package com.room.myvocabuilder;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity(tableName = "word_table")
public class WordTable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String wordTitle;
    private String wordMeaning;
    private  String wordExample;
    private String date;
    private String time;

    public WordTable(String wordTitle, String wordMeaning, String wordExample, String date, String time) {
        this.wordTitle = wordTitle;
        this.wordMeaning = wordMeaning;
        this.wordExample = wordExample;
        this.date = date;
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getWordTitle() {
        return wordTitle;
    }

    public String getWordMeaning() {
        return wordMeaning;
    }

    public String getWordExample() {
        return wordExample;
    }

    public String getDate() {

        Calendar calforDate= Calendar.getInstance();
        SimpleDateFormat currentDateFoemat= new SimpleDateFormat("MMM dd,yyyy");
        date=currentDateFoemat.format(calforDate.getTime());
        return date;
    }

    public String getTime() {

        Calendar calForTime= Calendar.getInstance();
        SimpleDateFormat currentTimeformat= new SimpleDateFormat("hh:mm a");
        time=currentTimeformat.format(calForTime.getTime());
        return time;
    }
}
