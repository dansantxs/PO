package Bimestre2.arvoretrie;

public class Trie {
    private No raiz;

    public Trie() {
        raiz = new No();
    }

    public void Inserir(String palavra) {
        No folha = raiz;

        for (int i = 0; i < palavra.length(); i++) {
            int pos = palavra.charAt(i) - 'a';

            if (folha.getvLig(pos) == null)
                folha.setvLig(new No(palavra.charAt(i)), pos);

            folha = folha.getvLig(pos);
        }

        folha.setFlag(true);
    }

    public void PercursoPorNivel() {
        if (raiz != null)  {
            Fila fila = new Fila();

            for (int i = 0; i < No.m; i++) {
                if (raiz.getvLig(i) != null) {
                    fila.enqueue(raiz.getvLig(i));
                }
            }

            while (!fila.isEmpty()) {
                Fila proximoNivel = new Fila();

                while (!fila.isEmpty()) {
                    No atual = fila.dequeue();
                    System.out.print("'" + atual.getLetra() + "' ");

                    for (int i = 0; i < No.m; i++) {
                        if (atual.getvLig(i) != null) {
                            proximoNivel.enqueue(atual.getvLig(i));
                        }
                    }
                }

                System.out.println();
                fila = proximoNivel;
            }
        }
    }
}