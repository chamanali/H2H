package com.example.chaman.htoh;

import java.io.Serializable;

/**
 * Created by Chaman on 31/10/2017.
 */

public class NewsItem implements Serializable {

    String title;
    String comments;
    String category;
    String guid;
    String description;
    String date;


 public String toString(){
     return title;
 }


}
