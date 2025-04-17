package Bimestre2.arvorenareas;

public class No {
    public static final int N = 3;
    private int[] vInfo;
    private No[] vLig;
    private int tl;

    public No () {
        vInfo = new int[N - 1];
        vLig = new No[N];
        tl = 0;
    }

    public No (int info) {
        this();
        vInfo[0] = info;
        tl = 1;
    }

    public int getInfo(int i) {
        return vInfo[i];
    }

    public void setInfo(int i, int info) {
        this.vInfo[i] = info;
    }

    public No getLig(int i) {
        return vLig[i];
    }

    public void setLig(int i, No lig) {
        this.vLig[i] = lig;
    }

    public int getTl() {
        return tl;
    }

    public void setTl(int tl) {
        this.tl = tl;
    }

    public int buscarPos(int info) {
        int pos = 0;
        while (pos < tl && info > vInfo[pos])
            pos++;
        return pos;
    }

    public void remanejar(int pos) {
        for (int i = tl; i > pos ; i--)
            vInfo[i] = vInfo[i - 1];
    }
}