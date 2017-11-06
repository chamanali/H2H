package com.example.chaman.htoh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Chaman on 31/10/2017.
 */

public class NewsAdapter extends BaseAdapter {

    Context context;

    ArrayList<NewsItem> newslist;

    @Override
    public int getCount() {
        return newslist.size ();
    }

    @Override
    public NewsItem getItem(int position) {
        return newslist.get ( position );
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return convertView;
    }
}
