package Bimestre2.arvoreb;

public class No {
    public static final int M = 2;
    private int[] vInfo;
    private int[] vPos;
    private No[] vLig;
    private int tl;

    public No () {
        vInfo = new int[M * 2 + 1];
        vPos = new int[M * 2 + 1];
        vLig = new No[M * 2 + 2];
        tl = 0;
    }

    public No (int info, int posArq) {
        this();
        vInfo[0] = info;
        vPos[0] = posArq;
        tl = 1;
    }

    public int getInfo(int i) {
        return vInfo[i];
    }

    public void setInfo(int i, int info) {
        this.vInfo[i] = info;
    }

    public int getPos(int i) {
        return vPos[i];
    }

    public void setPos(int i, int posArq) {
        this.vPos[i] = posArq;
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
        vLig[tl + 1] = vLig[tl];

        for (int i = tl; i > pos; i--) {
            vInfo[i] = vInfo[i + 1];
            vPos[i] = vPos[i + 1];
            vLig[i] = vLig[i + 1];
        }
    }
}