public class Ordine {

    public enum Stato{
        RICEVUTO, IN_ELABORAZIONE, EVASO
    }

    private Piatto piatto;
    private Tavolo tavolo;
    private Cameriere cameriere;
    private Stato stato;


}
