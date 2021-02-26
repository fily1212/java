import java.util.Arrays;

public class Coda {
    private Ordine[] ordini;
    private int nextDaOrdinare;
    private int nextDaCucinare;

    public Coda() {
        this.ordini = new Ordine[100];
        this.nextDaOrdinare = 0;
        this.nextDaCucinare = 0;
    }

    public void aggiungiOrdine(Ordine ordine){
        this.ordini[this.nextDaOrdinare] = ordine;
        this.nextDaOrdinare++;
    }

    public void evadiOrdine(){
        if(nextDaCucinare < nextDaOrdinare)
            this.ordini[this.nextDaCucinare++].setEvaso();
    }

    @Override
    public String toString() {

        String s = "";
        for(int i = nextDaCucinare; i < this.nextDaOrdinare; i++)
            s += this.ordini[i] + "\n";

        return s;
    }
}
