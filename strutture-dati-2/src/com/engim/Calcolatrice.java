package com.engim;

import java.util.Scanner;

public class Calcolatrice {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        Stack<Double> stack = new Stack<>();
        String s = tastiera.nextLine();

        String[] buffer = s.split(" ");
        for (String elem: buffer) {
            try{
               double d = Double.parseDouble(elem);
               stack.push(d);
            } catch (Exception e){

            }

        }
        stack.stampa();

    }

    public static void somma(Stack<Double> stack){


    }


}
