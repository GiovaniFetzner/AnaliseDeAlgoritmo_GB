import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Escolha qual solucao quer testar:\n1- Primeira solucao: algoritmo aleatorizada com k = 750 (recomendo)\n2- Segunda solucao: algoritmo forca bruta (talvez demore um pouco)\n\n");
        int option = input.nextInt();

        int count = 0;
        do {
            try {
                System.out.println("\n-------------------------\n");
                List<Plate[]> championships = ExtractData.extractData(count);
                for(int i = 0; i < championships.size(); i++){
                    if (option == 1)
                        System.out.println(FirstSolution.firstSolution(championships.get(i)));
                    else
                        System.out.println(SecondSolution.secondSolution(championships.get(i)));
                }
                count++;
            } catch (FileNotFoundException e){
                System.out.println("Erro no arquivo: " + e.getMessage());
                break;
            }
        }while (true);
    }
}