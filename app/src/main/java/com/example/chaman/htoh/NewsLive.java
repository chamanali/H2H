package com.example.chaman.htoh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class NewsLive extends AppCompatActivity {


    ListView lvnews;
    ArrayList<NewsItem> newslist;
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_news_live );

        lvnews = (ListView) findViewById ( R.id.listview_news );
        newslist = new ArrayList<>();


        RequestQueue queue = Volley.newRequestQueue ( this );

        StringRequest request = new StringRequest ( "https://www.imt.ie/news/feed/", new Response.Listener <String> ( ) {
            @Override
            public void onResponse(String response) {

               // lvnews.setText(response);

                Toast.makeText ( NewsLive.this, "Data Recieved Successfully: ", Toast.LENGTH_SHORT ).show ( );
                Document doc = Jsoup.parse(response);

               Elements itemElements = doc.getElementsByTag ( "item" );

                for (int i = 0; i < itemElements.size (); i++){
                    Element item = itemElements.get ( i );
                    String link = item.child ( 1 ).text ();
                    String title = item.child ( 0 ).text ();
                    String comments = item.child ( 2 ).text ();
                    String pubDate = item.child ( 3 ).text ();
                    String category = item.child ( 4 ).text ();
                    String guid = item.child ( 5 ).text ();
                    String description = item.child ( 8 ).text ();
                    Document doc2 = Jsoup.parse ( description );
                    String txt = doc2.getElementsByTag ("p").text ();


                    NewsItem news = new NewsItem ();
                    news.title = title;
                    news.description = txt;

                    news.guid = guid;
                    news.comments = comments;
                    news.category = category;
                    news.date = pubDate;


                    newslist.add ( news );




                    Log.i ( "mytag","Title "+ title );
                    Log.i ( "mytag", "comments "+comments);
                    Log.i ( "mytag","Category "+ category );
                    Log.i ( "mytag","GUID "+ guid);
                    Log.i ( "mytag","description "+ description );
                    Log.i ( "mytag","text "+ txt );



                    Log.i ( "mytag", "publishedDate " +pubDate );

                    Log.i ( "mytag", "link " + link );
                }
                Log.i ( "mytag", "item found "+itemElements.size ());
                Log.i ( "mytag", "items in news list "+newslist.size ());

                adapter = new NewsAdapter (NewsLive.this, newslist );
                lvnews.setAdapter ( adapter );


            }
        }, new Response.ErrorListener ( ) {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText ( NewsLive.this, "request failed", Toast.LENGTH_SHORT ).show ( );

            }
        } );

        Toast.makeText ( this, "request sent: Please wait ", Toast.LENGTH_SHORT ).show ( );
        queue.add ( request );




    }

    String removeCdata (String data){
        data = data.replace ( "<![CDATA", "" );
        data = data.replace ( "]]>", "" );
        return data;
    }






}
