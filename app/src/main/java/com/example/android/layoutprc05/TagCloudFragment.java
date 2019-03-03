package com.example.android.layoutprc05;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moxun.tagcloudlib.view.TagCloudView;

import java.util.ArrayList;

public class TagCloudFragment extends Fragment {
    private TagCloudView fragmenttagcloud;

    public TagCloudFragment() {
    }

    public static TagCloudFragment newInstance() {
        TagCloudFragment fragment = new TagCloudFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tagcloud_wordpage, container, false);

        fragmenttagcloud = rootView.findViewById(R.id.fragment_tagcloud);
        ArrayList<String> data = new ArrayList<String>();
        for(int i = 0 ; i < 40 ; i++) {
            data.add("aaa" + i);

        }
        TextTagsAdapter adapter = new TextTagsAdapter(data);

        fragmenttagcloud.setAdapter(adapter);

        return rootView;
    }
}
