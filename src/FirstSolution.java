import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FirstSolution {

    private static final int MULTIPLIER = 200;

    public static void firstSolution(Plate[] championship) {
        boolean hasDiscartedPlate = getGeneralSum(championship) % 2 != 0;
        int solution = Integer.MIN_VALUE;
        String solutionString = null;
        Plate discartedPlate = null;
        List<Integer> discardedPlatesTested = new ArrayList<>();

        for (int i = 1; i <= MULTIPLIER * championship.length; i++) {
            int numberRandomPlates = (int) (Math.random() * championship.length -1) +1;
            List<Integer> randomPlates = getRandomPlates(championship, numberRandomPlates);
            invertPlates(championship, randomPlates);

            int top = 0;
            int bottom = 0;
            if (hasDiscartedPlate) {

                int indexDiscardedPlate = (int) (Math.random() * championship.length);
                while (discardedPlatesTested.contains(indexDiscardedPlate) && indexDiscardedPlate != championship.length)
                    indexDiscardedPlate++;

                for (int j = 0; j < championship.length; j++) {
                    if (j == indexDiscardedPlate)
                        continue;
                    top += championship[j].getA();
                    bottom += championship[j].getB();
                }
                if (top == bottom && top >= solution) {
                    if (Objects.isNull(discartedPlate)
                            || (championship[indexDiscardedPlate].getA() <= championship[indexDiscardedPlate].getB()
                                    && championship[indexDiscardedPlate].getA() < discartedPlate.getA())) {
                        discartedPlate = championship[indexDiscardedPlate];
                        discardedPlatesTested.add(indexDiscardedPlate);
                        solution = top;
                        solutionString = solution + " descartada a placa " + discartedPlate.getOrderedValues();
                    }
                }
            } else {
                for (int j = 1; j <= championship.length; j++) {
                    top += championship[j - 1].getA();
                    bottom += championship[j - 1].getB();
                }
                if (top == bottom && top > solution) {
                    solution = top;
                    solutionString = solution + " nenhuma placa descartada";
                }
            }
        }
        if (Objects.isNull(solutionString))
            solutionString = "impossivel";
        System.out.println(solutionString);
    }

    private static int getGeneralSum(Plate[] championship){
        int generalSum = 0;
        for (Plate plate : championship)
            generalSum += plate.sumAB();
        return generalSum;
    }

    private static List<Integer> getRandomPlates(Plate[] championship, int numberRandomPlates){
        List<Integer> randomPlates = new ArrayList<>();
        for (int j = 1; j <= numberRandomPlates; j++)
            randomPlates.add((int) (Math.random() * championship.length));
        return randomPlates;
    }

    private static void invertPlates(Plate[] championship, List<Integer> randomPlates){
        for (int j = 0; j < championship.length; j++) {
            if (randomPlates.contains(j)) {
                int a = championship[j].getA();
                int b = championship[j].getB();
                championship[j].setA(b);
                championship[j].setB(a);
            }
        }
    }
}
