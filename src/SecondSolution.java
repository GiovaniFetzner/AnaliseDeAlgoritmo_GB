import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondSolution {

    public static String secondSolution(Plate[] championship) {
        boolean hasDiscartedPlate = getGeneralSum(championship) % 2 != 0;

        if (!hasDiscartedPlate) {
            int solution = findBestCombination(championship, 0, 0, 0);
            if (solution != 0) {
                return solution + " nenhuma placa descartada";
            }
        }
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

            Plate[] plates = newPlateList.toArray(new Plate[0]);

            int solution = findBestCombination(plates, 0, 0, 0);
            if (solution != 0)
                return solution + " descartada a placa " + discartedPlate.getOrderedValues();
        }
        return "impossivel";
    }

    private static int findBestCombination(Plate[] championship, int index, int top, int bottom) {
        if (index == championship.length) {
            if (top == bottom)
                return top;
            return 0;
        }

        int solution1 = findBestCombination(championship, index + 1,
                top + championship[index].getA(), bottom + championship[index].getB());

        int a = championship[index].getA();
        int b = championship[index].getB();
        championship[index].setA(b);
        championship[index].setB(a);
        int solution2 = findBestCombination(championship, index + 1,
                top + championship[index].getA(), bottom + championship[index].getB());
        championship[index].setA(a);
        championship[index].setB(b);

        return Math.max(solution1, solution2);
    }

    private static int getGeneralSum(Plate[] championship) {
        int generalSum = 0;
        for (Plate plate : championship) {
            generalSum += plate.sumAB();
        }
        return generalSum;
    }
}
