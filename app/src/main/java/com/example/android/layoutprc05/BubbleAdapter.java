package com.example.android.layoutprc05;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.LayoutInflater.from;

public class BubbleAdapter extends BaseAdapter {

    private final Context mContext;
    private final Bubble [] bubbles;

    //private int ooo = 0;
    public BubbleAdapter(Context context, Bubble [] bubbles) {
        this.mContext = context;
        this.bubbles = bubbles;
    }
    @Override
    public int getCount() {
        return bubbles.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Bubble bubble = bubbles[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.gridbubbles, null);

            TextView button1 = convertView.findViewById(R.id.but);
            button1.setText("10");
            button1.setBackgroundResource(R.drawable.circle_shape);
            //button1.setLayoutParams(new ViewGroup.LayoutParams(6,6));
           // button1.setPadding(2,6,2,6);
            //convertView.setAdjustViewBounds(true);
        }

//        button1.setHeight(6);
//        button1.setWidth(6);
       // button1.getLayoutParams().height = 30;
//        TextView mTextView = new TextView(mContext);
//        mTextView.setText(String.valueOf(position));
        //mTextView.setText(bubbles[ooo].getIndex() + "");
        //ooo++;
        return convertView;
    }
//    public static int getScreenWidth(Context context) {
//        WindowManager manager = (WindowManager) context
//                .getSystemService(Context.WINDOW_SERVICE);
//        Display display = manager.getDefaultDisplay();
//        return display.getWidth();
//    }
//
//    public static int dipToPx(Context context, int dip) {
//        if(density <= 0.0F) {
//            density = context.getResources().getDisplayMetrics().density;
//        }
//
//        return (int)((float)dip * density + 0.5F);
//    }
}
