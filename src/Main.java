import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        do {
            try {
                System.out.println("\n-------------------------\n");
                List<Plate[]> championships = ExtractData.extractData(count);
                for(int i = 0; i < championships.size(); i++){
                    FirstSolution.firstSolution(championships.get(i));
                    //System.out.println(SecondSolution.secondSolution(championships.get(i)));
                    //System.out.println(SecondSolution.fourthSolution(championships.get(i)));
                }
                count++;
            } catch (FileNotFoundException e){
                System.out.println("Erro no arquivo: " + e.getMessage());
                break;
            }
        }while (true);
    }
}