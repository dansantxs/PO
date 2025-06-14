package Bimestre2.arvorepatrica;

public class AplicacaoPatricia {
    public static void main(String[] args) {
        Patricia patricia = new Patricia();

        patricia.Inserir("bear");
        patricia.Inserir("bell");
        patricia.Inserir("bid");
        patricia.Inserir("bull");
        patricia.Inserir("buy");

        patricia.MostrarNosPorNivel();
        patricia.MostrarPalavras();
    }
}