package Bimestre2.arvorepatrica;

public class No {
    public static final int m = 26;
    private String palavra;
    private boolean flag;
    private No vLig[];
    
    public No() {
        palavra = "";
        flag = false;
        vLig = new No[m];
    }

    public No(String palavra) {
        this();
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
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