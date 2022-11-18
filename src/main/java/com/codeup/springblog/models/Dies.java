package com.codeup.springblog.models;
// Di exercise down below.
public class Dies {

    final int sides = 6;

    public int randomNum(){
        return (int) Math.floor((Math.random() * sides) +1);
    }

    public Dies(){};



}
