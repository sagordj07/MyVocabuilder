package com.room.myvocabuilder;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WordFragment extends Fragment {

    private WordViewModel wordViewModel;
    private View wordview;
    private RecyclerView recyclerView;



    public WordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        wordview= inflater.inflate(R.layout.fragment_word, container, false);

        recyclerView = (RecyclerView) wordview.findViewById(R.id.Recycler_view_word);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        final WordAdapter wordAdapter=new WordAdapter();
        recyclerView.setAdapter(wordAdapter);

        wordViewModel= ViewModelProviders.of(this).get(WordViewModel.class);
        wordViewModel.getAllwords().observe(this, new Observer<List<WordTable>>() {
            @Override
            public void onChanged(@Nullable List<WordTable> wordTables) {

                wordAdapter.setWordTables(wordTables);

                Toast.makeText(getContext(),"OnChange",Toast.LENGTH_LONG).show();

            }
        });


        return wordview;
    }




}
