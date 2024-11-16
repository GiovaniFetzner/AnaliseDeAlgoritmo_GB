import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        System.out.print("Digite o numero do caso de teste: ");
        int numberFile = in.nextInt();

        File file = new File("../data/in" + numberFile);

        Scanner scanner = new Scanner(file);

        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (scanner.hasNextInt())
                    matrix[i][j] = scanner.nextInt();
            }
        }

        in.close();
        scanner.close();

        //System.out.println(PrimeiraSolucao.primeiraSolucao(matrix));
        System.out.println(SegundaSolucao.segundaSolucao(matrix));
    }
}