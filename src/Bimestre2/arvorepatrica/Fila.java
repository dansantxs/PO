package Bimestre2.arvorepatrica;

public class Fila {
    private NoFila inicio;
    private NoFila fim;

    public Fila() {
        inicio = null;
        fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(No no) {
        NoFila folha = new NoFila(no, "");
        if (fim == null) {
            inicio = fim = folha;
        } else {
            fim.proximo = folha;
            fim = folha;
        }
    }

    public No dequeue() {
        if (!isEmpty()) {
            No folha = inicio.no;
            inicio = inicio.proximo;
            if (inicio == null) {
                fim = null;
            }
            return folha;
        }
        return null;
    }
}