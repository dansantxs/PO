package Bimestre2.arvorepatrica;

public class NoFila {
    No no;
    NoFila proximo;

    NoFila(No dado, String prefixo) {
        this.no = dado;
        this.proximo = null;
    }
}