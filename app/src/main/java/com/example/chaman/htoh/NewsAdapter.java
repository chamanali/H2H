package com.example.chaman.htoh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Chaman on 31/10/2017.
 */

public class NewsAdapter extends BaseAdapter {

    Context context;

    ArrayList<NewsItem> newslist;

    public NewsAdapter(Context context, ArrayList<NewsItem>newslist) {
        this.context = context;
        this.newslist = newslist;
    }

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
        //return convertView;

        if (convertView == null) {
            convertView = View.inflate ( context, R.layout.news_list_item_layout, null );
        }
        NewsItem currentNews = newslist.get ( position );

        TextView tvTitle = (TextView) convertView.findViewById ( R.id.textView_1 );
        TextView tvDate = (TextView) convertView.findViewById ( R.id.textView_2 );
        TextView tvDescription = (TextView) convertView.findViewById ( R.id.textView_3 );

        //Picasso.with ( context ).load ( currentNews.title );
        tvTitle.setText ( currentNews.title );
        tvDate.setText (currentNews.date);
        tvDescription.setText ( currentNews.description );


        return convertView;

    }
}
