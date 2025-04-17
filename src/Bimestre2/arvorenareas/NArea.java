package Bimestre2.arvorenareas;

public class NArea {
    private No raiz;

    public NArea() {
        raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void inserir (int info) {
        No aux;
        int pos;
        boolean flag = false;

        if (raiz == null)
            raiz = new No(info);
        else {
            aux = raiz;

            while (!flag) {
                pos = aux.buscarPos(info);

                if (aux.getTl() < No.N-1) {
                    aux.remanejar(pos);
                    aux.setInfo(pos, info);
                    aux.setTl(aux.getTl() + 1);
                    flag = true;
                }
                else {
                    if (aux.getLig(pos) == null) {
                        aux.setLig(pos, new No(info));
                        flag = true;
                    }
                    else
                        aux = aux.getLig(pos);
                }
            }
        }
    }

    public void in_ordem () {
        in_ordem(raiz);
    }

    private void in_ordem (No raiz) {
        if (raiz != null) {
            for (int i = 0; i < raiz.getTl(); i++) {
                in_ordem(raiz.getLig(i));
                System.out.println(raiz.getInfo(i));
            }

            in_ordem(raiz.getLig(raiz.getTl()));
        }
    }

    public No buscaNo (int info) {
        No aux = raiz;
        int pos;
        boolean flag = false;

        while (!flag) {
            pos = aux.buscarPos(info);

            if (pos < aux.getTl() && info == aux.getInfo(pos))
                flag = true;
            else
                aux = aux.getLig(pos);
        }

        return aux;
    }
}