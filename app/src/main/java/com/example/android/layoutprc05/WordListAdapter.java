package com.example.android.layoutprc05;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LayoutInflater mInflater;
    private List<WordData> mWords;

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private final TextView weightItemView;
        private final TextView prounciationView;



        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView1);
            weightItemView = itemView.findViewById(R.id.textView2);
            prounciationView = itemView.findViewById(R.id.textView3);

        }
    }

    public WordListAdapter(Context context) {

        mInflater = LayoutInflater.from(context);
    }

    /**
     * Create new views
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }


    /**
     * Replace the contents of a view.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords != null) {
            WordData current = mWords.get(position);
            holder.wordItemView.setText("Weight: " + current.getWeight());
            //WordData getWeight =
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }

    void setWords(List<WordData> words){
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }
}
