package com.room.myvocabuilder;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.card.MaterialCardView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import static android.app.Activity.RESULT_OK;
import static com.room.myvocabuilder.MainActivity.ADD_REQUEST_CODE;


/**
 * A simple {@link Fragment} subclass.
 */
public class WordFragment extends Fragment {

    private WordViewModel wordViewModel;
    private View wordview;
    //private RecyclerView recyclerView;




    public WordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        wordview= inflater.inflate(R.layout.fragment_word, container, false);

        RecyclerView recyclerView =  wordview.findViewById(R.id.Recycler_view_word);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        final WordAdapter wordAdapter=new WordAdapter();
        recyclerView.setAdapter(wordAdapter);

        wordViewModel= ViewModelProviders.of(getActivity()).get(WordViewModel.class);
        wordViewModel.getAllwords().observe(this, new Observer<List<WordTable>>() {
            @Override
            public void onChanged(@Nullable List<WordTable> wordTables) {

                wordAdapter.setWordTables(wordTables);

                Toast.makeText(getContext(),"OnChange",Toast.LENGTH_LONG).show();

            }
        });
        return wordview;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==ADD_REQUEST_CODE && resultCode==RESULT_OK)
        {
            String Word_title=data.getStringExtra(AddwordActivity.EXTRA_TITLE);
            String Word_meaning=data.getStringExtra(AddwordActivity.EXTRA_MEANING);
            String Word_example=data.getStringExtra(AddwordActivity.EXTRA_EXAMPLE);
            String Word_date=data.getStringExtra(AddwordActivity.EXTRA_DATE);
            String Word_time=data.getStringExtra(AddwordActivity.EXTRA_TIME);

            WordTable wordTable=new WordTable(Word_title,Word_meaning,Word_example,Word_date,Word_time);

            wordViewModel.insert(wordTable);
            Toast.makeText(getContext(),"saved",Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(getContext()," not saved",Toast.LENGTH_SHORT).show();

        }

    }
}
