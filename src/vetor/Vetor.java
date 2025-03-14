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
}