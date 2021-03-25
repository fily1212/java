import java.io.IOException;
import java.io.RandomAccessFile;

public class Rilevamenti {

    private int metri;
    private String nome;

    public Rilevamenti(int metri, String nome) {
        this.metri = metri;
        this.nome = nome;
    }

    public void write(RandomAccessFile raf) throws IOException {

        raf.writeChars(nome.substring(0,3));
        raf.writeInt(metri);
    }

    public static Rilevamenti read(RandomAccessFile raf) throws IOException {
        String nome = String.valueOf(raf.readChar()) +
                String.valueOf(raf.readChar()) +
                String.valueOf(raf.readChar());

        int metri = raf.readInt();
        return new Rilevamenti(metri, nome);
    }

    @Override
    public String toString() {
        return "Aeroporto " + nome + ": "
                + metri +
                "m";
    }
}
