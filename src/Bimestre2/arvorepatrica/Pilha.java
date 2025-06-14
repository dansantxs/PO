package Bimestre2.arvorepatrica;

public class Pilha {
    private NoPilha topo;

    public Pilha() {
        topo = null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(No no, String prefixo) {
        NoPilha novoNo = new NoPilha(no, prefixo);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public NoPilha pop() {
        if (isEmpty()) {
            return null;
        }
        NoPilha temp = topo;
        topo = topo.proximo;
        return temp;
    }
}
