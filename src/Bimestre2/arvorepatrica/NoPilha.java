package Bimestre2.arvorepatrica;

public class NoPilha {
    No no;
    String prefixo;
    NoPilha proximo;

    NoPilha(No dado, String prefixo) {
        this.no = dado;
        this.prefixo = prefixo;
        this.proximo = null;
    }
}