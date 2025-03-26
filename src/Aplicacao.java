import listaencadeada.Lista;
import vetor.Vetor;

public class Aplicacao {
    public static void main(String[] args) {
        Vetor vetor = new Vetor(100, new int[]{13,28,57,96,32,31,87,98,41,93,37,20,72,59,38,94,42,25,35,90,7,61,15,49,71,27,18,39,86,73,99,44,77,52,23,51,95,88,67,66,17,4,81,34,2,84,45,47,68,29,53,33,12,5,70,89,92,62,78,8,43,55,50,36,22,9,100,54,97,69,64,1,24,79,10,91,14,26,46,60,63,30,80,3,21,74,11,65,56,83,85,16,76,19,6,48,58,75,40,82});
        Lista lista = new Lista(null, null);

        for (int i = 0; i < 100; i++)
            lista.inserirNoFinal(vetor.getInfo(i));
        
        lista.exibe();
    }
}
