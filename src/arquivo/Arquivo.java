package arquivo;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Arquivo {
    private String nomearquivo;
    private RandomAccessFile arquivo;

    public Arquivo(String nomearquivo) {
        try {
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        }
        catch (IOException e) {

        }
    }

    public void truncate(long pos) {
        try {
            arquivo.setLength(pos * Registro.length());
        }
        catch (IOException exc) {

        }
    }

    public boolean eof() {
        boolean retorno = false;

        try {
            if (arquivo.getFilePointer() == arquivo.length())
                retorno = true;
        }
        catch (IOException e) {

        }
        return (retorno);
    }

    public int filesize() {
        try {
            return (int) arquivo.length() / Registro.length();
        } catch (IOException exc) {
        }
        return 0;
    }

    public void seekArq(int pos) {
        try {
            arquivo.seek(pos * Registro.length());
        }
        catch (IOException e) {

        }
    }
}