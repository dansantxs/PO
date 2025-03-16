package arquivo;

import listaencadeada.No;

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
        catch (IOException e) {

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
        } catch (IOException e) {
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

    public void insercaoDireta() {
        int n = filesize();
        Registro[] registros = new Registro[n];

        for (int i = 0; i < n; i++) {
            seekArq(i);
            registros[i] = new Registro();
            registros[i].leDoArq(arquivo);
        }

        for (int i = 1; i < n; i++) {
            Registro aux = registros[i];
            int pos = i;

            while (pos > 0 && aux.getCodigo() < registros[pos - 1].getCodigo()) {
                registros[pos] = registros[pos - 1];
                pos--;
            }

            registros[pos] = aux;
        }

        for (int i = 0; i < n; i++) {
            seekArq(i);
            registros[i].gravaNoArq(arquivo);
        }
    }

    public void selecaoDireta() {
        int n = filesize();
        Registro[] registros = new Registro[n];

        for (int i = 0; i < n; i++) {
            seekArq(i);
            registros[i] = new Registro();
            registros[i].leDoArq(arquivo);
        }

        for (int i = 0; i < n - 1; i++) {
            int posMenor = i;

            for (int j = i + 1; j < n; j++) {
                if (registros[j].getCodigo() < registros[posMenor].getCodigo()) {
                    posMenor = j;
                }
            }

            if (posMenor != i) {
                Registro temp = registros[i];
                registros[i] = registros[posMenor];
                registros[posMenor] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            seekArq(i);
            registros[i].gravaNoArq(arquivo);
        }
    }

    public void bolha() {
        int n = filesize();
        Registro[] registros = new Registro[n];
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            seekArq(i);
            registros[i] = new Registro();
            registros[i].leDoArq(arquivo);
        }

        while (n > 1 && flag) {
            flag = false;

            for (int i = 0; i < n - 1; i++) {
                if (registros[i].getCodigo() > registros[i + 1].getCodigo()) {
                    Registro temp = registros[i];
                    registros[i] = registros[i + 1];
                    registros[i + 1] = temp;
                    flag = true;
                }
            }

            n--;
        }

        for (int i = 0; i < registros.length; i++) {
            seekArq(i);
            registros[i].gravaNoArq(arquivo);
        }
    }
}