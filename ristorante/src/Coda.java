public class Coda {
    private Ordine[] ordini;
    private int nextDaOrdinare;
    private int nextDaCucinare;

    public Coda() {
        this.ordini = new Ordine[100];
        this.nextDaOrdinare = 0;
        this.nextDaCucinare = 0;
    }

}
