package Bimestre2.arvorepatrica;

public class Patricia {
    private No raiz;

    public Patricia() {
        raiz = new No();
    }

    public void Inserir(String palavra) {
        No atual = raiz;
        int i = 0;

        while (i < palavra.length()) {
            int pos = palavra.charAt(i) - 'a';
            No proximoNo = atual.getvLig(pos);

            if (proximoNo == null) {
                atual.setFlag(false);
                atual.setvLig(new No(palavra.substring(i)), pos);
                atual.getvLig(pos).setFlag(true);
                i = palavra.length();
            } else {
                String palavraNo = proximoNo.getPalavra();
                int j = 0;
                int k = i;

                while (j < palavraNo.length() && k < palavra.length() && palavraNo.charAt(j) == palavra.charAt(k)) {
                    j++;
                    k++;
                }

                if (j == palavraNo.length()) {
                    atual = proximoNo;
                    i = k;
                } else {
                    No novoNoInterno = new No(palavraNo.substring(0, j));
                    novoNoInterno.setvLig(proximoNo, palavraNo.charAt(j) - 'a');
                    proximoNo.setPalavra(palavraNo.substring(j));

                    atual.setvLig(novoNoInterno, pos);

                    if (k < palavra.length()) {
                        novoNoInterno.setvLig(new No(palavra.substring(k)), palavra.charAt(k) - 'a');
                        novoNoInterno.getvLig(palavra.charAt(k) - 'a').setFlag(true);
                    }

                    i = palavra.length();
                }
            }
        }
    }

    public void MostrarNosPorNivel() {
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
                    System.out.print("'" + atual.getPalavra() + "' ");

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

    public void MostrarPalavras() {
        if (raiz == null) {
            return;
        }

        Pilha pilha = new Pilha();
        pilha.push(raiz, "");

        while (!pilha.isEmpty()) {
            NoPilha noPilha = pilha.pop();
            No atual = noPilha.no;
            String prefixoAtual = noPilha.prefixo;

            if (atual.isFlag()) {
                System.out.println(prefixoAtual);
            }

            for (int i = No.m - 1; i >= 0; i--) { // Percorre de trás para frente para manter a ordem lexicográfica
                if (atual.getvLig(i) != null) {
                    pilha.push(atual.getvLig(i), prefixoAtual + atual.getvLig(i).getPalavra());
                }
            }
        }
    }
}