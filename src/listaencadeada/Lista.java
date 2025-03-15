package listaencadeada;

public class Lista {
    private No inicio;
    private No fim;

    public Lista(No inicio, No fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    private No buscaMeio(No pini, No pfim) {
        int cont = 0;
        No aux = pini;

        while(aux != pfim.getProx()) {
            cont++;
            aux = aux.getProx();
        }

        for (int i = cont / 2; i > 0; i--) {
            pini = pini.getProx();
        }

        return pini;
    }

    public No buscaBinaria(int chave, No inicio, No fim) {
        No pini = inicio, pfim = fim, pmeio = buscaMeio(inicio, fim);

        while (pini.getInfo() < pfim.getInfo() && chave != pmeio.getInfo()) {
            if (chave > pmeio.getInfo())
                pini = pmeio.getProx();
            else
                pfim = pmeio.getAnt();

            pmeio = buscaMeio(pini, pfim);
        }

        if (chave == pmeio.getInfo())
            return pmeio;

        return null;
    }

    public void insercaoDireta() {
        No pi = inicio.getProx(), ppos;
        int aux;

        while (pi != null) {
            aux = pi.getInfo();
            ppos = pi;

            while (ppos != inicio && aux < ppos.getAnt().getInfo()) {
                ppos.setInfo(ppos.getAnt().getInfo());
                ppos = ppos.getAnt();
            }

            pi = pi.getProx();
        }
    }
}