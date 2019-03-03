package com.example.android.layoutprc05;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.moxun.tagcloudlib.view.TagsAdapter;

import java.io.IOException;
import java.util.ArrayList;

//1
public class BlankFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SHOW_TEXT = "text";

    private String mContentText;

    private TextView mTextView;

    private WordViewModel mWordViewModel;

    private EditText editText;

    private SignActivity mActivity;

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
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        if (context instanceof SignActivity){
//            mActivity =(SignActivity) context;
//        }
//    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_blank, container, false);



//       // final Button mButton = rootView.findViewById(R.id.button1);
//
        if(c.getSize() == 0) {
            try {
                c.readFromCSV(getResources().openRawResource(R.raw.words));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//
//
//
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int index = 0 ;
//                editText = (EditText) rootView.findViewById(R.id.edit_query);
//                mTextView = rootView.findViewById(R.id.testtvv);
//                String getIndex = editText.getText().toString();
//
//                index = Integer.parseInt(getIndex);
//                String test3 = "nothing";
//
//                test3 += c. getListA( index).word;
//                test3 += c. getListA( index).weight;
//                test3 += c. getListA( index).pronunciation;
//
//                mTextView.setText(test3);
//            }
//        });



//        test3 += c. getListA( index).verb;
//        test3 += c. getListA( index).verbt;
//        test3 += c. getListA( index).verbi;
//        test3 += c. getListA( index).noun;
//        test3 += c. getListA( index).adj;
//        test3 += c. getListA( index).adv;
//        test3 += c. getListA( index).prep;
//        test3 += c. getListA( index).conj;
//        test3 += c. getListA( index).sentence;
//        test3 += c. getListA( index).looklike;
//        test3 += c. getListA( index).homoionym;
//        test3 += c. getListA( index).antonym;




//
//        recyclerView = rootView.findViewById(R.id.recyclerview);
//        final WordListAdapter adapter = new WordListAdapter(this.getContext());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        Bubble b = new Bubble();
        final Bubble [] bubbles = new Bubble[100];

        int [] index = b.getsortedIndex();

        int [] tempArray = new int [38];

        for (int i = 0; i < index.length; i++ ){
            b = new Bubble(index[i],tempArray);
            bubbles [i] = b;
        }
//
//        for (int j = 0; j < index.length; j++ ){
//            b = new Bubble(tempArray);
//            bubbles [index[j]] = null;
//            bubbles [index[j]] = b;
//        }

        final GridView gridView = rootView.findViewById(R.id.gridview);
        BubbleAdapter bubbleAdapter = new BubbleAdapter(this.getContext(), bubbles);
        //rootView = inflater.inflate(R.layout.gridview, container, false);


        //TextTagsAdapter adapter = new TextTagsAdapter(data);
        gridView.setAdapter(bubbleAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TagCloudFragment nextFrag= new TagCloudFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.blankfg_container, nextFrag, "fragment")
                        .addToBackStack(null)
                        .commit();
            }

        });




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

    private void changeFragment(){
        TagCloudFragment nextFrag= new TagCloudFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.blankfg_container, nextFrag, "fragment")
                .addToBackStack(null)
                .commit();
        //.replace(R.id.blankfg_container, nextFrag, "fragment")
    }


}
