package Bimestre2.arvoreb;

public class BTree {
    private No raiz;

    public BTree() {
        raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    private No navegarAteFolha(int info) {
        No folha = raiz;
        int pos;

        while (folha.getLig(0) != null) {
            pos = folha.buscarPos(info);
            folha = folha.getLig(pos);
        }

        return folha;
    }

    private No localizarPai(No folha, int info) {
        No no = raiz, pai = raiz;
        int pos;

        while (no != folha) {
            pai = no;
            pos = no.buscarPos(info);
            no = no.getLig(pos);
        }

        return pai;
    }

    private void split(No folha, No pai) {
        No cx1 = new No();
        No cx2 = new No();
        int pos;

        for (int i = 0; i < No.M; i++) {
            cx1.setInfo(i, folha.getInfo(i));
            cx1.setPos(i, folha.getPos(i));
            cx1.setLig(i, folha.getLig(i));
        }
        cx1.setLig(No.M, folha.getLig(No.M));
        cx1.setTl(No.M);

        for (int i = No.M + 1; i < 2 * No.M + 1; i++) {
            cx2.setInfo(i - (No.M + 1), folha.getInfo(i));
            cx2.setPos(i - (No.M + 1), folha.getPos(i));
            cx2.setLig(i - (No.M + 1), folha.getLig(i));
        }
        cx2.setLig(No.M, folha.getLig(2 * No.M + 1));
        cx2.setTl(No.M);

        if (folha == pai) {
            folha.setInfo(0, folha.getInfo(No.M));
            folha.setPos(0, folha.getPos(No.M));
            folha.setTl(1);
            folha.setLig(0, cx1);
            folha.setLig(0, cx2);
        }
        else {
            pos = pai.buscarPos(folha.getInfo(No.M));
            pai.remanejar(pos);
            pai.setInfo(pos, folha.getInfo(No.M));
            pai.setPos(pos, folha.getPos(No.M));
            pai.setTl(pai.getTl() + 1);
            pai.setLig(pos, cx1);
            pai.setLig(pos + 1, cx2);

            if (pai.getTl() > 2 * No.M) {
                folha = pai;
                pai = localizarPai(folha, folha.getInfo(pos));
                split(folha, pai);
            }
        }
    }

    public void inserir(int info, int posArq) {
        No folha, pai;
        int pos;

        if (raiz == null) 
            raiz = new No(info, posArq);
        else {
            folha = navegarAteFolha(info);
            pos = folha.buscarPos(info);
            folha.remanejar(pos);
            folha.setInfo(pos, info);
            folha.setPos(pos, posArq);
            folha.setTl(folha.getTl() + 1);

            if (folha.getTl() > 2 * No.M) {
                pai = localizarPai(folha, info);
                split(folha, pai);
            }
        }          
    }

    public void in_ordem() {
        in_ordem(raiz);
    }

    private void in_ordem(No raiz) {
        if (raiz != null) {
            for (int i = 0; i < raiz.getTl(); i++) {
                in_ordem(raiz.getLig(i));
                System.out.println(raiz.getInfo(i));
            }
            in_ordem(raiz.getLig(raiz.getTl()));
        }
    }
}
