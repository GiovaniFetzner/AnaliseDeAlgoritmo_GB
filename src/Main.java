import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        secondSolution();
    }

    private static void firstSolution() {
        int count = 0;
        do {
            try {
                System.out.println("\n-------------------------\n");
                List<Plate[]> championships = ExtractData.extractData(count);
                for(int i = 0; i < championships.size(); i++){
                    FirstSolution.firstSolution(championships.get(i));
                }
                count++;
            } catch (FileNotFoundException e){
                System.out.println("Erro no arquivo");
                break;
            }
        }while (true);
    }

    private static void secondSolution() {
        int count = 0;
        do {
            try {
                System.out.println("\n-------------------------\n");
                List<Plate[]> championships = ExtractData.extractData(count);
                for(int i = 0; i < championships.size(); i++){
                    SecondSolution.secondSolution(championships.get(i));
                }
                count++;
            } catch (FileNotFoundException e){
                System.out.println("Erro no arquivo");
                break;
            }
        }while (true);
    }
}