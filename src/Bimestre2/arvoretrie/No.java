package Bimestre2.arvoretrie;

public class No {
    public static final int m = 26;
    private char letra;
    private boolean flag;
    private No vLig[];
    
    public No() {
        letra = ' ';
        flag = false;
        vLig = new No[m];
    }

    public No(char letra) {
        this();
        this.letra = letra;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public No getvLig(int pos) {
        return vLig[pos];
    }

    public void setvLig(No vLig, int pos) {
        this.vLig[pos] = vLig;
    }
}