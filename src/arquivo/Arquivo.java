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

    public void quickSemPivo() {
        quickSP(0, filesize() - 1);
    }

    public void quickSP(int ini, int fim) {
        int i = ini, j = fim, aux;
        boolean flag = true;
        Registro regi = new Registro();
        Registro regj = new Registro();

        while (i < j) {
            seekArq(j);
            regj.leDoArq(arquivo);
            seekArq(i);
            regi.leDoArq(arquivo);

            if (flag)
                while (i < j && regi.getCodigo() <= regj.getCodigo()) {
                    regi.leDoArq(arquivo);
                    i++;
                }
            else
                while (i < j && regj.getCodigo() >= regi.getCodigo()) {
                    seekArq(j);
                    regj.leDoArq(arquivo);
                    j--;
                }

            if (i < j) {
                seekArq(i);
                regj.gravaNoArq(arquivo);
                seekArq(j);
                regi.gravaNoArq(arquivo);
                flag = !flag;
            }
        }

        if (ini < i - 1)
            quickSP(ini, i - 1);

        if (j + 1 < fim)
            quickSP(j + 1, fim);
    }

    public void merge1() {
        Arquivo arq1 = new Arquivo("D:/arq1.dat");
        Arquivo arq2 = new Arquivo("D:/arq1.dat");
        int seq = 1;

        while (seq < filesize()) {
            particao(arq1, arq2);
            fusao(arq1, arq2, seq);
            seq *= 2;
        }
    }

    public void particao (Arquivo arq1, Arquivo arq2) {
        int meio = filesize() / 2;
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();

        for (int i = 0; i < meio; i++) {
            seekArq(i);
            reg1.leDoArq(arquivo);
            reg1.gravaNoArq(arq1.arquivo);
            seekArq(i + meio);
            reg2.leDoArq(arquivo);
            reg2.gravaNoArq(arq2.arquivo);
        }
    }
}