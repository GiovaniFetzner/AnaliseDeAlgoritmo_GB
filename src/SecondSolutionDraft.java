import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondSolutionDraft {

    /*
    **  Esta solução provoca estouro de memória ao calcular todas as combinações das placas, pois mantém
    *  todas as possibilidades numa estrutura de dados  chama 'results'
     */
    public static String secondSolution(Plate[] championship) {
        boolean evenSum = getGeneralSum(championship) % 2 == 0;

        if (evenSum) {
            List<List<Plate>> results = generateInversions(championship);
            int solution = 0;
            for (List<Plate> objects : results) {

                int top = 0;
                int bottom = 0;

                for (Plate plate : objects) {
                    top += plate.getA();
                    bottom += plate.getB();
                }

                if ((top > solution) && (top == bottom)) {
                    solution = top;
                }
            }
            if (solution != 0) {
                return solution + " nenhuma placa descartada";
            }
        } else {
            List<Plate> discardedPlates = new ArrayList<>();

            while (championship.length != discardedPlates.size()) {

                int minSum = Integer.MAX_VALUE;
                Plate discartedPlate = new Plate(Integer.MAX_VALUE, Integer.MAX_VALUE);
                for (Plate plate : championship) {
                    if ((plate.sumAB() < minSum) && (!discardedPlates.contains(plate))) {
                        minSum = plate.sumAB();
                        discartedPlate = plate;
                    }
                }
                discardedPlates.add(discartedPlate);
                List<Plate> newPlateList = new ArrayList<>(Arrays.asList(championship));
                newPlateList.remove(discartedPlate);

                List<List<Plate>> results = generateInversions(newPlateList.toArray(new Plate[0]));
                int solution = 0;
                for (List<Plate> objects : results) {

                    int top = 0;
                    int bottom = 0;

                    for (Plate plate : objects) {
                        top += plate.getA();
                        bottom += plate.getB();
                    }

                    if ((top > solution) && (top == bottom)) {
                        solution = top;
                    }
                }
                if (solution != 0) {
                    return solution + " descartada a placa " + discartedPlate.getOrderedValues();
                }
                if (discardedPlates.size() == championship.length){
                    return "impossivel";
                }
            }
        }

        return "impossivel";
    }

    public static List<List<Plate>> generateInversions(Plate[] championship) {
        List<List<Plate>> results = new ArrayList<>();
        generateInversionsRecursive(championship, 0, results);
        return results;
    }

    private static void generateInversionsRecursive(Plate[] championship, int index, List<List<Plate>> results) {
        if (index == championship.length) {
            List<Plate> current = new ArrayList<>();
            for (Plate plate : championship) {
                current.add(new Plate(plate.getA(), plate.getB()));
            }
            results.add(current);
            return;
        }

        int increment = index == 0 ? 2 : 1;

        generateInversionsRecursive(championship, index + increment, results);

        int a = championship[index].getA();
        int b = championship[index].getB();
        championship[index].setA(b);
        championship[index].setB(a);

        generateInversionsRecursive(championship, index + increment, results);

        championship[index].setA(a);
        championship[index].setB(b);
    }

    private static int getGeneralSum(Plate[] championship) {
        int generalSum = 0;
        for (Plate plate : championship)
            generalSum += plate.sumAB();
        return generalSum;
    }

    /*
    * * Código abaixo foi utilizado para verificar as combinaçoes das placas
    public static List<List<Plate>> generateInversions(Plate[] championship) {
        List<List<Plate>> results = new ArrayList<>();
        generateInversionsRecursive(championship, 0, results);
        return results;
    }

    private static void generateInversionsRecursive(Plate[] championship, int index, List<List<Plate>> results) {
        if (index == championship.length) {
            List<Plate> current = new ArrayList<>();
            for (Plate plate : championship) {
                current.add(new Plate(plate.getA(), plate.getB()));
            }
            results.add(current);
            return;
        }

        int increment = index == 0 ? 2 : 1;

        generateInversionsRecursive(championship, index + increment, results);

        int a = championship[index].getA();
        int b = championship[index].getB();
        championship[index].setA(b);
        championship[index].setB(a);

        generateInversionsRecursive(championship, index + increment, results);

        championship[index].setA(a);
        championship[index].setB(b);
    }
     */
}