package com.company;

public class Main {

    public static void main(String[] args) {
        Padre p = new Padre();
        p.metodo1();
        p.metodo2();
        Figlio1 f1 = new Figlio1();
        f1.metodo1();
        f1.metodo2();
        Padre f2 = new Figlio2();
        f2.metodo1();
        if(f2 instanceof Figlio2)
            ((Figlio2)f2).metodo3();

    }
}
