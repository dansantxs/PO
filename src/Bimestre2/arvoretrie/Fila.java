package Bimestre2.arvoretrie;

public class Fila {
    private static class NoFila {
        No dado;
        NoFila proximo;

        NoFila(No dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

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
        NoFila novoNo = new NoFila(no);
        if (fim == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
    }

    public No dequeue() {
        if (isEmpty()) {
            return null;
        }
        No dado = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        return dado;
    }
}