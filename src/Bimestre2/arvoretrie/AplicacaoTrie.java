package Bimestre2.arvoretrie;

public class AplicacaoTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.Inserir("bear");
        trie.Inserir("bell");
        trie.Inserir("bid");
        trie.Inserir("bull");
        trie.Inserir("buy");

        trie.PercursoPorNivel();
    }
}