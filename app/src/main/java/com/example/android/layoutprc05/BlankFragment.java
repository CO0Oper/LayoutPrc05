package com.example.android.layoutprc05;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;


public class BlankFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SHOW_TEXT = "text";

    private String mContentText;

    private TextView mTextView;

    private WordViewModel mWordViewModel;

    CSVreader c = new CSVreader();

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
       // mWordViewModel = ViewModelProvider.of(this).get(WordViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        In fragment_blank.xml
    <android.support.v7.widget.RecyclerView
    xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/recyclerview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@android:color/darker_gray"
        tools:listitem="@layout/recyclerview_item">



    </android.support.v7.widget.RecyclerView>
         */

        //String mContentText = "The size is : " + getSize();
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView contentTv = rootView.findViewById(R.id.testtvv);
       // contentTv.setText(mContentText);

        if(c.getSize() == 0) {
            try {
                c.readFromCSV(getResources().openRawResource(R.raw.words));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String ss = "The size of csvfile: " + c.getSize();

        String test2 = c.getList(1);


        String test3 = "";
        test3 += c. getListA( 1).word;
        test3 += c. getListA( 1).weight;
        test3 += c. getListA( 1).pronunciation;
        test3 += c. getListA( 1).verb;
        test3 += c. getListA( 1).verbt;
        test3 += c. getListA( 1).verbi;
        test3 += c. getListA( 1).noun;
        test3 += c. getListA( 1).adj;
        test3 += c. getListA( 1).adv;
        test3 += c. getListA( 1).prep;
        test3 += c. getListA( 1).conj;
        test3 += c. getListA( 1).sentence;
        test3 += c. getListA( 1).looklike;
        test3 += c. getListA( 1).homoionym;
        test3 += c. getListA( 1).antonym;



        contentTv.setText(test3);
//
//        recyclerView = rootView.findViewById(R.id.recyclerview);
//        final WordListAdapter adapter = new WordListAdapter(this.getContext());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        //contenttv = rootView.findViewById(R.id.testtvv);

//        mWordViewModel.getmAllWords().observe(this, new Observer<List<WordData>>() {
//            @Override
//            public void onChanged(@Nullable final List<WordData> words) {
//                // Update the cached copy of the words in the adapter.
//                adapter.setWords(words);
//            }
//        });

        return rootView;
    }
}
