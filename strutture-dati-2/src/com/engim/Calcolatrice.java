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
                switch (elem){
                    case "+":
                        somma(stack);
                }
            }

        }
        stack.stampa();

    }

    public static void somma(Stack<Double> stack){
        if(stack.size() > 1){
            Double a = stack.pop();
            Double b = stack.pop();
            stack.push(a+b);
        }else{
            System.out.println("Errore nella sintassi");
        }


    }


}
