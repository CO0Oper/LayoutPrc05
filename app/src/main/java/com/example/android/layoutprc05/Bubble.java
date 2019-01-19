package com.example.android.layoutprc05;

import java.util.ArrayList;

public class Bubble {

    private int [] indiv;

    private int [] groups = new int[100];

    int length = 10;
    //h is for temporary rows
    //c is for column
    //r is for rows
    private int c, r, g, h;

    private int indexOfIndiv;

    private int index;

    ArrayList <Integer> listone;//list store word groups
    int dArray[][];//2D array for store coordinates
    ArrayList<Integer> listtwo;

    /**
     * Default constructor.
     */
    public Bubble() {
        this.index = 0;
        this.indiv = new int[38];
     }

     public Bubble( int index, int[] master) {
        this.index = index;
        this.indiv = master;
     }

     public int getIndex(){
        return index;
     }
    public int[] getsortedIndex() {

        listone = new ArrayList<>();

        for (int i = 1; i < 101; i++) {
            listone.add(new Integer(i));
        }
        this.c = 9;
        this.r = 9;
        this.g = 1;
        this.h = 0;
        dArray = new int[10][10];
        dArray[0][0] = 1;
        //Invoke toArray method to get index.
        toArray();

        int groupsIndex = 0;
        //set groups index.
        for(int c = 0; c<10; c++)
        {
            for(int d = 0; d<10; d++)
            {
                groups[groupsIndex] = dArray[c][d];
                groupsIndex++;
            }
        }
        //return the sorted index.
        return groups;
    }

    /**
     * In order to save index with coordinates to a 2D array.
     * And set groups index;
     */
    public void toArray() {
        int i = 99;//index of the array
        int bb = 0;//count variable 1
        int bbb = 0;//count variable 2
        int countt = 2;//count variable 3
        do {
            for(; g <= c+bbb ; g++ ) {
                dArray[g][h] = listone.get(i);//insert values from top to bottom on left side
                i--;//subtract index number after every insert.
            }
            g--;//
            h++;
            for(; h <= r+bbb ; h++) {
                dArray[g][h] = listone.get(i);//from left to right on bottom side.
                i--;
            }
            h--;
            g--;
            for(int ii = c-c+bb; ii <= g+bbb ; g--) {//from bottom to above on right side.
                dArray[g][h] = listone.get(i);
                i--;
            }
            g++;
            h--;
            for(int ii = r-r+bb; ii <= h+bbb; h--) {//from right side to left
                dArray[g][h] = listone.get(i);
                i--;
            }
            g = countt;
            h = countt-1;
            c-=2;
            r-=2;

            bb+=2;
            bbb++;
            countt++;

        }while(c > 0 && r > 0);

    }//end of method
}
