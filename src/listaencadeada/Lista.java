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

    public void inserirNoFinal(int info) {
        No caixa = new No(fim, null, info);
        if (inicio == null)
            inicio = fim = caixa;
        else {
            fim.setProx(caixa);
            fim = caixa;
        }
    }

    public void exibe() {
        No aux = inicio;
        while (aux != null) {
            System.out.printf(" " + aux.getInfo());
            aux = aux.getProx();
        }
        System.out.println();
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

            ppos.setInfo(aux);
            pi = pi.getProx();
        }
    }

    public void selecaoDireta() {
        No pposMenor, pi = inicio, pj;
        int aux;

        while (pi != fim) {
            pposMenor = pi;
            pj = pi.getProx();

            while (pj != null) {
                if (pj.getInfo() < pposMenor.getInfo())
                    pposMenor = pj;

                pj = pj.getProx();
            }

            aux = pi.getInfo();
            pi.setInfo(pposMenor.getInfo());
            pposMenor.setInfo(aux);
            pi = pi.getProx();
        }
    }

    public void bolha() {
        No ppos = fim, pi;
        int aux;
        boolean flag = true;

        while (ppos != inicio.getProx() && flag) {
            flag = false;

            pi = inicio;
            while (pi != ppos) {
                if(pi.getInfo() > pi.getProx().getInfo()) {
                    aux = pi.getInfo();
                    pi.setInfo(pi.getProx().getInfo());
                    pi.getProx().setInfo(aux);
                    flag = true;
                }

                pi = pi.getProx();
            }

            ppos = ppos.getAnt();
        }
    }

    public void shake() {
        No pinicio = inicio, pfim = fim, pi;
        int aux;
        boolean flag = true;

        while (pinicio != pfim && flag) {
            flag = false;
            pi = pinicio;

            while (pi != pfim) {
                if(pi.getInfo() > pi.getProx().getInfo()) {
                    aux = pi.getInfo();
                    pi.setInfo(pi.getProx().getInfo());
                    pi.getProx().setInfo(aux);
                    flag = true;
                }

                pi = pi.getProx();
            }

            pfim = pfim.getAnt();

            if (flag) {
                flag = false;
                pi = pfim;

                while (pi != pinicio) {
                    if(pi.getInfo() < pi.getAnt().getInfo()) {
                        aux = pi.getInfo();
                        pi.setInfo(pi.getAnt().getInfo());
                        pi.getAnt().setInfo(aux);
                        flag = true;
                    }

                    pi = pi.getAnt();
                }

                pinicio = pinicio.getProx();
            }
        }
    }
}