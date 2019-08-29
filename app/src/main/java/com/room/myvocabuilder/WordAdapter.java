package com.room.myvocabuilder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordHolder> {

    private List<WordTable>wordTables=new ArrayList<>();


    @NonNull
    @Override
    public WordHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemview= LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.worditem,viewGroup,false);
        return new WordHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull WordHolder wordHolder, int position) {

    WordTable currentword=wordTables.get(position);

    wordHolder.textWord.setText(currentword.getWordTitle());
    wordHolder.textMeaning.setText(currentword.getWordMeaning());
    wordHolder.textExample.setText(currentword.getWordExample());
    wordHolder.textDate.setText(currentword.getDate());
    wordHolder.textTime.setText(currentword.getTime());


    }

    @Override
    public int getItemCount() {
        return wordTables.size();
    }

    public WordTable setGetAt(int position)
    {
        return wordTables.get(position);
    }

    public void setWordTables(List<WordTable>wordTables)
    {
        this.wordTables=wordTables;
        notifyDataSetChanged();
    }


    class WordHolder extends RecyclerView.ViewHolder{

        private TextView textWord;
        private TextView textMeaning;
        private TextView textExample;
        private TextView textDate;
        private TextView textTime;

        public WordHolder(@NonNull View itemView) {
            super(itemView);

            textWord=itemView.findViewById(R.id.text_view_title);
            textMeaning=itemView.findViewById(R.id.text_view_meaning);
            textExample=itemView.findViewById(R.id.text_view_example);
            textDate=itemView.findViewById(R.id.text_view_date);
            textTime=itemView.findViewById(R.id.text_view_time);


        }
    }
}
