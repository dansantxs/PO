package Bimestre2.arvorenareas;

public class AplicacaoNArea {
    public static void main(String[] args) {
        NArea arv = new NArea();

        arv.inserir(100);
        arv.inserir(50);
        arv.inserir(90);
        arv.inserir(10);
        arv.inserir(15);
        arv.inserir(125);
        arv.inserir(120);

        arv.in_ordem();
    }
}