package com.example.android.layoutprc05;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;


public class BlankFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SHOW_TEXT = "text";

    private String mContentText;

    private TextView mTextView;

    private WordViewModel mWordViewModel;

    CSVreader c;

    RecyclerView recyclerView;

    public BlankFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @return A new instance of fragment BlankFragment.
//     */
//    public static BlankFragment newInstance(String param1) {
//        BlankFragment fragment = new BlankFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_SHOW_TEXT, param1);
//        fragment.setArguments(args);
//        return fragment;
//    }


    /**
     *  Create a new fragment.
     * @return
     */
    public static BlankFragment newFragment() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mContentText = getArguments().getString(ARG_SHOW_TEXT);
        }
        //String filePath = new InputStreamReader(getResources().openRawResource(R.raw.words));
        c = new CSVreader();
        try {
            c.readFromCSV(getResources().openRawResource(R.raw.words));
        } catch (IOException e) {
            e.printStackTrace();
        }

       // mWordViewModel = ViewModelProvider.of(this).get(WordViewModel.class);

        //readCsvFile();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String mContentText = "The size is : " + c.getSize();
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        //TextView contentTv = rootView.findViewById(R.id.fragment_words);
       // contentTv.setText(mContentText);

        recyclerView = rootView.findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        mWordViewModel.getmAllWords().observe(this, new Observer<List<WordData>>() {
            @Override
            public void onChanged(@Nullable final List<WordData> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(words);
            }
        });

        return rootView;
    }

}
