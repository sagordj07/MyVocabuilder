package com.room.myvocabuilder;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface WordTableDao {


    @Insert
    void insert(WordTable wordTable);
    @Delete
    void delete(WordTable wordTable);
    @Update
    void update(WordTable wordTable);


    @Query("DELETE FROM WORD_TABLE")
    void deleteAllword();

    @Query("SELECT * FROM WORD_TABLE ORDER BY id DESC")
    LiveData<List<WordTable>> getAllword();




}
