package com.example.hangman.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hangman.R;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordViewHolder> {

    private List<String> words;

    public WordsAdapter(List<String> words) {
        this.words = words;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {

        holder.custom_Item.setText(words.get(position));
    }

    @Override
    public int getItemCount() {
        return words.size();
    }


    public static class WordViewHolder extends RecyclerView.ViewHolder {

        public TextView custom_Item;

        public WordViewHolder(View itemView) {
            super(itemView);
            custom_Item = itemView.findViewById(R.id.Custom_Item);
        }
    }
}
