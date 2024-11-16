import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FirstSolution {

    public static void firstSolution(Plate[] championship){
        int solution = Integer.MIN_VALUE;
        String solutionString = null;
        for(int i = 1; i <= 5 * championship.length; i++){
            int numberRandomPlates = (int)(Math.random() * championship.length);

            List<Integer> randomPlates = new ArrayList<>();
            for(int j = 1; j <= numberRandomPlates; j++){
                randomPlates.add((int)(Math.random() * championship.length));
            }

            for(int j = 1; j <= championship.length; j++){
                if(randomPlates.contains(j)){
                    int a = championship[j].getA();
                    int b = championship[j].getB();
                    championship[j].setA(b);
                    championship[j].setB(a);
                }
            }

            int top = 0;
            int down = 0;
            for(int j = 1; j <= championship.length; j++){
                top += championship[j - 1].getA();
                down += championship[j - 1].getB();
            }

            if(top == down && top > solution){
                solution = top;
                solutionString = solution + " nenhuma placa descartada";
            }

            if(Objects.isNull(solutionString))
                solutionString = "impossivel";
        }

        System.out.println(solutionString);
    }
}
