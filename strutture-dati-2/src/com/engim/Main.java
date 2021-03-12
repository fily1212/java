package com.engim;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Ciao");
        lista.add("Ciao2");

        for(String s: lista){
            System.out.println(s);
        }
        lista.remove("Ciao");

        for(String s: lista){
            System.out.println(s);
        }
    }
}
