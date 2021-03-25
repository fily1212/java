import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EsempioFileBinario {

    public static int RECORD_SIZE = 10;

    public static void inserisciRilevamento(RandomAccessFile raf, Scanner tastiera){
        System.out.println("Inserisci il codice della città");
        String citta = tastiera.nextLine();
        System.out.println("Inserisci i metri senza la virgola");
        int metri = Integer.parseInt(tastiera.nextLine());
        Rilevamenti rilevamenti = new Rilevamenti(metri,citta);
        try {
            rilevamenti.write(raf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leggiRilevamenti(RandomAccessFile raf){
        try {
            raf.seek(0);
            while(raf.getFilePointer() <= raf.length() - RECORD_SIZE){
                System.out.println(Rilevamenti.read(raf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        RandomAccessFile raf = null;

        try{
            File f = new File("prova.dat");
            raf = new RandomAccessFile(f, "rw");
            raf.seek(raf.length());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        Scanner tastiera = new Scanner(System.in);
        boolean uscita = false;
        while(!uscita){
            System.out.println("Cosa vuoi fare?\n1. Inserisci un rilevamento\n2. Leggi i rilevamenti \n3. ....\n4. Esci dal programma");
            int scelta = Integer.parseInt(tastiera.nextLine());
            switch (scelta){
                case 1:
                    inserisciRilevamento(raf, tastiera);
                    break;
                case 2:
                    leggiRilevamenti(raf);
                    break;
                case 3:
                    break;
                case 4:
                    uscita = true;
                    System.out.println("Chiusura del programma");
                    break;
                default:
                    System.out.println("Non ho capito la tua scelta");
            }
        }


    }
}
