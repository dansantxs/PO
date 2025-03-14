package arquivo;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Registro {
    public final int tf = 20;
    private int codigo, tl = tf, idade;
    private char nome[] = new char[tf];

    public Registro() {
    }

    public Registro(int codigo, int tl, int idade, char[] nome) {
        this.codigo = codigo;
        this.tl = tl;
        this.idade = idade;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTl() {
        return tl;
    }

    public void setTl(int tl) {
        this.tl = tl;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char[] getNome() {
        return nome;
    }

    public void setNome(char nome) {
        this.nome = new char[]{nome};
    }

    public void gravaNoArq(RandomAccessFile arquivo) {
        try {
            arquivo.writeInt(codigo);
            arquivo.writeInt(idade);
            arquivo.writeInt(tl);
            for (int i = 0; i < tf; i++)
            {
                arquivo.writeChar(nome[i]);
            }
        }
        catch (IOException e) {

        }
    }

    public void leDoArq(RandomAccessFile arquivo) {
        try {
            this.codigo = arquivo.readInt();
            this.idade = arquivo.readInt();
            this.tl = arquivo.readInt();
            for (int i = 0; i < this.tf; i++)
                this.nome[i] = arquivo.readChar();
            for (int i = tl; i < tf; i++)
                this.nome[i] = ' ';
        }
        catch (IOException e) {

        }
    }

    static int length() {
        return (52);
    }
}