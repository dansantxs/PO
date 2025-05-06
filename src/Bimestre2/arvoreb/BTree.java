package Bimestre2.arvoreb;

public class BTree {
    private No raiz;

    public BTree() {
        raiz = null;
    }

    private No navegarAteFolha(int info) {
        No folha = raiz;
        int pos;

        while(folha.getvLig(0) != null) {
            pos = folha.procurarPosicao(info);
            folha = folha.getvLig(pos);
        }

        return folha;
    }

    private No localizarPai(No folha, int info) {
        No no = raiz, pai = raiz;
        int pos;

        while(no != folha) {
            pai = no;
            pos = no.procurarPosicao(info);
            no = no.getvLig(pos);
        }

        return pai;
    }

    private void split(No folha, No pai)
    {
        No cx1 = new No();
        No cx2 = new No();
        int pos;

        for(int i=0; i<No.m; i++)
        {
            cx1.setvInfo(i, folha.getvInfo(i));
            cx1.setvPos(i, folha.getvPos(i));
            cx1.setvLig(i, folha.getvLig(i));
        }

        cx1.setvLig(No.m, folha.getvLig(No.m));
        cx1.setTl(No.m);

        for(int i=No.m+1; i<2*No.m+1; i++)
        {
            cx2.setvInfo(i-(No.m+1), folha.getvInfo(i));
            cx2.setvPos(i-(No.m+1), folha.getvPos(i));
            cx2.setvLig(i-(No.m+1), folha.getvLig(i));
        }
        
        cx2.setvLig(No.m, folha.getvLig(2*No.m+1));
        cx2.setTl(No.m);

        if(folha == pai)
        {
            folha.setvInfo(0, folha.getvInfo(No.m));
            folha.setvPos(0, folha.getvPos(No.m));
            folha.setTl(1);
            folha.setvLig(0, cx1);
            folha.setvLig(1, cx2);
        }
        else
        {
            pos = pai.procurarPosicao(folha.getvInfo(No.m));
            pai.remanejar(pos);
            pai.setvInfo(pos, folha.getvInfo(No.m));
            pai.setvPos(pos, folha.getvPos(No.m));
            pai.setTl(pai.getTl()+1);
            pai.setvLig(pos, cx1);
            pai.setvLig(pos+1, cx2);
            if(pai.getTl() > 2*No.m)
            {
                folha = pai;
                pai = localizarPai(folha, folha.getvInfo(0));
                split(folha, pai);
            }
        }
    }

    public void inserir(int info, int posArq)
    {
        No folha, pai;
        int pos;
        if (raiz==null)
            raiz = new No(info, posArq);
        else
        {
            folha = navegarAteFolha(info);
            pos = folha.procurarPosicao(info);
            folha.remanejar(pos);
            folha.setvInfo(pos, info);
            folha.setvPos(pos, posArq);
            folha.setTl(folha.getTl()+1);
            if(folha.getTl()>2*No.m)
            {
                pai = localizarPai(folha, info);
                split(folha, pai);
            }
        }
    }

    public void in_ordem()
    {
        in_ordem(raiz);
    }

    private void in_ordem(No raiz)
    {
        if (raiz != null)
        {
            for(int i=0; i<raiz.getTl(); i++)
            {
                in_ordem(raiz.getvLig(i));
                System.out.println(raiz.getvInfo(i));
            }
            in_ordem(raiz.getvLig(raiz.getTl()));
        }
    }
}
