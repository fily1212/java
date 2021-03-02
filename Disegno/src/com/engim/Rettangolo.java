package com.engim;

import java.awt.*;

public class Rettangolo extends Poligono{

    private int larghezza;
    private int altezza;

    public Rettangolo(int l, int a){
        this.larghezza = l;
        this.altezza = a;
    }


    @Override
    public void disegna(Graphics g, int x, int y) {
        // completa qui
        int xOffset = larghezza/2, yOffset = altezza/2;

        g.drawLine(x-xOffset,y-yOffset,x+xOffset,y-yOffset);
        g.drawLine(x-xOffset,y-yOffset,x-xOffset,y+yOffset);
        g.drawLine(x+xOffset,y-yOffset,x+xOffset,y+yOffset);
        g.drawLine(x-xOffset,y+yOffset,x+xOffset,y+yOffset);
    }
}
