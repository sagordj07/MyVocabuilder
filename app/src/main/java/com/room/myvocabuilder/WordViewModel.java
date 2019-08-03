package com.room.myvocabuilder;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    private LiveData<List<WordTable>> Allwords;



    public WordViewModel(@NonNull Application application) {
        super(application);
         wordRepository=new WordRepository(application);
        Allwords=wordRepository.getGetAllwords();


    }

    public void insert(WordTable wordTable)
    {
        wordRepository.insert(wordTable);

    }
    public void update(WordTable wordTable)
    {

        wordRepository.update(wordTable);
    }
    public void delete(WordTable wordTable)
    {
        wordRepository.delete(wordTable);

    }
    public void deleteAll()
    {
       wordRepository.deleteAllWord();

    }
    public LiveData<List<WordTable>>getAllwords()
    {
        return Allwords;
    }
}
