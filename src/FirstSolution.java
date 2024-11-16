import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FirstSolution {

    public static void firstSolution(Plate[] championship) {
        int generalSum = 0;
        for (Plate plate : championship)
            generalSum += plate.sumAB();

        int solution = Integer.MIN_VALUE;
        String solutionString = null;
        boolean hasDiscartedPlate = generalSum % 2 != 0;
        Plate discartedPlate = null;

        for (int i = 1; i <= 100 * championship.length; i++) {
            int numberRandomPlates = (int) (Math.random() * championship.length - 1) + 1;

            List<Integer> randomPlates = new ArrayList<>();
            for (int j = 1; j <= numberRandomPlates; j++)
                randomPlates.add((int) (Math.random() * championship.length));

            for (int j = 1; j <= championship.length; j++) {
                if (randomPlates.contains(j)) {
                    int a = championship[j].getA();
                    int b = championship[j].getB();
                    championship[j].setA(b);
                    championship[j].setB(a);
                }
            }

            int top = 0;
            int down = 0;

            if (hasDiscartedPlate) {
                int indexDiscardedPlate = (int) (Math.random() * championship.length);

                for (int j = 1; j <= championship.length; j++) {
                    if (j == indexDiscardedPlate)
                        continue;
                    top += championship[j - 1].getA();
                    down += championship[j - 1].getB();
                }
                if (top == down) {
                    if (Objects.isNull(discartedPlate) || discartedPlate.sumAB() < championship[indexDiscardedPlate].sumAB())
                        discartedPlate = championship[indexDiscardedPlate];
                    solution = top;
                }
            } else {

                for (int j = 1; j <= championship.length; j++) {
                    top += championship[j - 1].getA();
                    down += championship[j - 1].getB();
                }
                if (top == down && top > solution)
                    solution = top;
            }

            if (Objects.nonNull(discartedPlate))
                solutionString = solution + " descartada a placa " + discartedPlate.toString();
            if (Objects.isNull(solutionString) || solutionString.equals("impossivel"))
                solutionString = "impossivel";
            else
                solutionString = solution + " nenhuma placa descartada";

        }
        System.out.println(solutionString);
    }
}
