import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SecondSolution {

    public static String secondSolution(Plate[] championship) {
        // Verificar se a soma geral é par ou ímpar
        boolean evenSum = getGeneralSum(championship) % 2 != 0;

        if (evenSum){
            permutations(championship, 0, new ArrayList<Plate>());
        }

        return evenSum ? "Soma ímpar, necessário remover uma placa!" : "Soma par, combinações geradas!";
    }

    private static boolean permutations(Plate[] championship, int indexInitial, List<Plate> chainPlate) {
        chainPlate.add(championship[indexInitial]);

        indexInitial++;
        if (indexInitial == championship.length){
            if(chainPlate.stream().mapToInt(Plate::getA).sum() ==
                    chainPlate.stream().mapToInt(Plate::getB).sum()){
                return true;
            }else {
                permutations(championship, 0, new ArrayList<Plate>());
            }
        }
        permutations(championship, indexInitial, chainPlate);

        return false;
    }


    private static void swap(Plate[] array, int i, int j) {
        Plate temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int getGeneralSum(Plate[] championship) {
        int generalSum = 0;
        for (Plate plate : championship)
            generalSum += plate.sumAB();
        return generalSum;
    }
}