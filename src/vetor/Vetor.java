package vetor;

public class Vetor {
    private int tl;
    private int[] vet;

    public Vetor(int tl, int[] vet) {
        this.tl = tl;
        this.vet = vet;
    }

    public int getTl() {
        return tl;
    }

    public void setTl(int tl) {
        this.tl = tl;
    }

    public int[] getVet() {
        return vet;
    }

    public void setVet(int[] vet) {
        this.vet = vet;
    }

    public int buscaBinaria(int chave, int tl) {
        int ini = 0, fim = tl / 2, meio = fim / 2;

        while (ini < fim && chave != vet[meio]) {
            if (chave > vet[meio])
                ini = meio + 1;
            else
                fim = meio - 1;

            meio = (ini + fim) / 2;
        }

        if (chave > vet[meio])
            return meio + 1;

        return -1;
    }

    public void insercaoDireta() {
        int pos, aux;
        for (int i = 1; i < tl; i++) {
            aux = vet[i];
            pos = i;

            while (pos > 0 && aux < vet[pos-1]) {
                vet[pos] = vet[pos - 1];
                pos--;
            }

            vet[pos] = aux;
        }
    }

    public void insercaoBinaria() {
        int pos, aux;

        for (int i = 1; i < tl; i++) {
            aux = vet[i];
            pos = buscaBinaria(aux, i);

            for (int j = i; j > pos; j--)
                vet[j] = vet[j - 1];

            vet[pos] = aux;
        }
    }
}