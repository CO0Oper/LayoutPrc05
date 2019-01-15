package com.example.android.layoutprc05;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csvreader.CsvReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SHOW_TEXT = "text";

    private String mContentText;

    private TextView mTextView;

    private WordViewModel mWordViewModel;

    static List<WordData> words;

    TextView contenttv;


    //CSVreader c = new CSVreader();

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
        //CSVreader c = new CSVreader();

        try {
            readFromCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // mWordViewModel = ViewModelProvider.of(this).get(WordViewModel.class);

        //readCsvFile();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        In fragment_blank.xml
            <TextView
        android:id="@+id/testtvv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        style="@style/word_title"
        android:background="#b2ebf2"/>
         */



        //String mContentText = "The size is : " + getSize();
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView contentTv = rootView.findViewById(R.id.testtvv);
       // contentTv.setText(mContentText);
        String ss = "Read size: \n Read size: \n Read size: \n Read size:";
        contentTv.setText(ss);
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

//    public int getSize(){
//        return words.size();
//    }

    public void readFromCSV() throws IOException {

        ArrayList<String[]> csvList = new ArrayList<>();

        String word, pronunciation, verb, verbt, verbi, noun,
                adj, adv, prep, conj, sentence, looklike, homoionym, antonym;
        int weight;

        /* Invoke using String path*/
        //CsvReader reader = new CsvReader("words.csv", ',', Charset.forName("utf-8"));

        /* Invoke using InputSteam*/
        CsvReader reader = new CsvReader(new InputStreamReader(getResources().openRawResource(R.raw.words),"UTF-8"));

        reader.readHeaders();

        while(reader.readRecord()) {

            csvList.add(reader.getValues());
        }
        reader.close();

        for(int row = 0; row < csvList.size(); row++) {
            //int row = ;
            if(csvList.get(row)[0]!=null && csvList.get(row)[0] != "") {
                word = csvList.get(row)[0];
            }else {
                word = "";
            }
            if(csvList.get(row)[1]!=null) {
                //weight = Integer.parseInt(csvList.get(row)[1]);

                weight = Integer.parseInt(csvList.get(row)[1]);
            }else {
                weight = 0;
                //return;
            }
            if(csvList.get(row)[2]!=null) {
                pronunciation = csvList.get(row)[2];
            }else {
                pronunciation = "";
                //return;
            }
            if(csvList.get(row)[3]!=null) {
                verb = csvList.get(row)[3];
            }else {
                verb = "";
            }
            if(csvList.get(row)[4]!=null) {
                verbt = csvList.get(row)[4];
            }else {
                verbt = "";
            }
            if(csvList.get(row)[5]!=null) {
                verbi = csvList.get(row)[5];
            }else {
                verbi = "";
            }
            if(csvList.get(row)[6]!=null) {
                noun = csvList.get(row)[6];
            }else {
                noun = "";
            }
            if(csvList.get(row)[7]!=null) {
                adj = csvList.get(row)[7];
            }else {
                adj = "";
            }
            if(csvList.get(row)[8]!=null) {
                adv = csvList.get(row)[8];
            }else {
                adv = "";
            }
            if(csvList.get(row)[9]!=null) {
                prep = csvList.get(row)[9];
            }else {
                prep = "";
            }
            if(csvList.get(row)[10]!=null) {
                conj = csvList.get(row)[10];
            }else {
                conj = "";
            }
            if(csvList.get(row)[11]!=null) {
                sentence = csvList.get(row)[11];
            }else {
                sentence = "";
            }
            if(csvList.get(row)[12]!=null) {
                looklike = csvList.get(row)[12];
            }else {
                looklike = "";
            }
            if(csvList.get(row)[13]!=null) {
                homoionym = csvList.get(row)[13];
            }else {
                homoionym = "";
            }
            if(csvList.get(row)[14]!=null) {
                antonym = csvList.get(row)[14];
            }else {
                antonym = "";
            }

            WordData worddata = new WordData(word, weight, pronunciation, verb, verbt, verbi, noun,
                    adj, adv, prep, conj, sentence, looklike, homoionym, antonym);
            //System.out.println(wordcons.output());

            //words.add(worddata);
            //System.out.println(words.get(0).output());


        }
    }

}
