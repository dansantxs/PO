package Bimestre2.arvoreb;

public class AplicacaoB {
    public static void main(String[] args) {
        BTree b = new BTree();
        for(int i=1; i<=10000000; i++)
            b.inserir(i, i);

        System.out.println("-----");
        b.in_ordem();
    }
}
