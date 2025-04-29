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

            if (folha.getTl() > 2 * No.N) {
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
