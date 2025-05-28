package Bimestre2.arvoretrie;

public class Trie {
    private No raiz;

    public Trie() {
        raiz = new No();
    }

    public void Inserir(String palavra) {
        No folha = raiz;
        int pos;

        for (int i = 0; i < palavra.length(); i++) {
            pos = palavra.charAt(i) - 'a';

            if (folha.getvLig(pos) == null)
                folha.setvLig(new No(palavra.charAt(i)), pos);

            folha = folha.getvLig(pos);
        }

        folha.setFlag(true);
    }

    public void PreOrdem() {
        PreOrdem(raiz);
    }

    private void PreOrdem(No raiz) {
        if (raiz != null)
            for (int i = 0; i < No.m; i++) {
                if (raiz.getvLig(i) != null) {
                    System.out.println(raiz.getvLig(i).getLetra());
                    PreOrdem(raiz.getvLig(i));
                }
            }
    }
}