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

    public void selecaoDireta () {
        No pposMenor, pi = inicio, pj;
        int aux;

        while (pi != fim) {
            pposMenor = pi;
            pj = pi.getProx();

            while (pj != null) {
                if(pj.getInfo() < pposMenor.getInfo())
                    pposMenor = pj;
            }

            aux = pi.getInfo();
            pi.setInfo(pposMenor.getInfo());
            pposMenor.setInfo(aux);
        }
    }
}