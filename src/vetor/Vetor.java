package vetor;

public class Vetor {
    private int tl;
    private int[] vet;

    public Vetor(int tl, int[] vet) {
        this.tl = tl;
        this.vet = vet;
    }
    public int getInfo(int i) {
        return vet[i];
    }

    public void exibe() {
        for (int i = 0; i < tl; i++)
            System.out.printf(" " + vet[i]);
        System.out.println();
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

    public void selecaoDireta() {
        int posMenor, aux;

        for (int i = 0; i < tl - 1; i++) {
            posMenor = i;

            for (int j = i + 1; j < tl; j++)
                if(vet[j] < vet[posMenor])
                    posMenor = j;

            aux = vet[i];
            vet[i] = vet[posMenor];
            vet[posMenor] = aux;
        }
    }

    public void bolha() {
        int tl2 = tl, aux;
        boolean flag = true;

        while (tl2 > 1 && flag) {
            flag = false;

            for (int i = 0; i < tl2 - 1; i++) {
                if(vet[i] > vet[i + 1]) {
                    aux = vet[i];
                    vet[i] = vet[i + 1];
                    vet[i + 1] = aux;
                    flag = true;
                }
            }

            tl2--;
        }
    }

    public void shake() {
        int inicio = 0, fim = tl - 1, aux;
        boolean flag = true;

        while (inicio < fim && flag) {
            flag = false;
            for (int i = inicio; i < fim; i++) {
                if(vet[i] > vet[i + 1]) {
                    aux = vet[i];
                    vet[i] = vet[i + 1];
                    vet[i + 1] = aux;
                    flag = true;
                }
            }
            fim--;
            if (flag) {
                flag = false;
                for (int i = fim; i > inicio; i--) {
                    if(vet[i] < vet[i - 1]) {
                        aux = vet[i];
                        vet[i] = vet[i - 1];
                        vet[i - 1] = aux;
                        flag = true;
                    }
                }
                inicio++;
            }
        }
    }

    public void heap() {
        int tl2 = tl, fe, fd, motorF, aux;

        while (tl2 > 1) {
            for (int i = tl2 / 2 - 1; i >= 0; i--) {
                fe = 2 * i + 1;
                fd = fe + 1;
                motorF = fe;

                if (fd < tl2 && vet[fd] > vet[fe])
                    motorF = fd;

                if (vet[motorF] > vet[i]) {
                    aux = vet[motorF];
                    vet[motorF] = vet[i];
                    vet[i] = aux;
                }
            }

            aux = vet[0];
            vet[0] = vet[tl2 - 1];
            vet[tl2 - 1] = aux;
            tl2--;
        }
    }

    public void shell() {
        int dist = 1, aux, pos;

        while (dist < tl)
            dist *= 3 + 1;

        dist /= 3;

        while (dist > 0) {
            for (int i = dist; i < tl; i++) {
                aux = vet[i];
                pos = i;

                while (pos >= dist && aux < vet[pos-dist]) {
                    vet[pos] = vet[pos-dist];
                    pos -= dist;
                }

                vet[pos] = aux;
            }

            dist /= 3;
        }
    }

    public void quickSemPivo() {
        quickSP(0, tl - 1);
    }

    public void quickSP(int ini, int fim) {
        int i = ini, j = fim, aux;
        boolean flag = true;

        while (i < j) {
            if (flag)
                while (i < j && vet[i] <= vet[j])
                    i++;
            else
                while (i < j && vet[j] >= vet[i])
                    j--;

            aux = vet[i];
            vet[i] = vet[j];
            vet[j] = aux;
            flag = !flag;
        }

        if (ini < i - 1)
            quickSP(ini, i - 1);

        if (j + 1 < fim)
            quickSP(j + 1, fim);
    }

    public void quickComPivo() {
        quickCP(0, tl - 1);
    }

    public void quickCP(int ini, int fim) {
        int i = ini, j = fim, pivo = vet[(ini + fim) / 2], aux;

        while (i < j) {
            while (vet[i] < pivo)
                i++;

            while (vet[j] > pivo)
                j--;

            if (i <= j) {
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
                i++;
                j--;
            }
        }

        if (ini < j)
            quickCP(ini, i - 1);

        if (i < fim)
            quickCP(j + 1, fim);
    }

    public void merge1() {
        int[] vet1 = new int[tl / 2], vet2 = new int[tl / 2];
        int seq = 1;

        while (seq < tl) {
            particao(vet1, vet2);
            fusao(vet1, vet2, seq);
            seq *= 2;
        }
    }

    private void particao(int[] vet1, int[] vet2) {
        int meio = tl / 2;
        for (int i = 0; i < meio; i++) {
            vet1[i] = vet[i];
            vet2[i] = vet[i + meio];
        }
    }

    private void fusao(int[] vet1, int[] vet2, int seq) {
        int i = 0, j = 0, k = 0, auxSeq = seq;

        while (k < tl) {
            while (i < seq && j < seq)
                if (vet1[i] < vet2[j])
                    vet[k++] = vet1[i++];
                else
                    vet[k++] = vet2[j++];

            while (i < seq)
                vet[k++] = vet1[i++];

            while (j < seq)
                vet[k++] = vet2[j++];

            seq += auxSeq;
        }
    }

    public void merge2() {
        int[] aux = new int[tl];
        mergeSort(0, tl - 1, aux);
    }

    public void mergeSort(int esq, int dir, int[] aux) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSort(esq, meio, aux);
            mergeSort(meio + 1, dir, aux);
            fusao2(esq, meio, meio + 1, dir, aux);
        }
    }

    public void fusao2(int ini1, int fim1, int ini2, int fim2, int[] aux) {
        int i = ini1, j = ini2, k = 0;

        while (i <= fim1 && j <= fim2)
            if (vet[i] < vet[j])
                aux[k++] = vet[i++];
            else
                aux[k++] = vet[j++];

        while (i <= fim1)
            aux[k++] = vet[i++];

        while (j <= fim2)
            aux[k++] = vet[j++];

        for (i = 0; i < k; i++)
            vet[i + ini1]  = aux[i];
    }
}