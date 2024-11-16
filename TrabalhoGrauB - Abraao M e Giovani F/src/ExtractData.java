import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExtractData {

    public static List<Map<Integer, Integer>> extractData(int testCase) throws FileNotFoundException {

        File file = new File("../data/in" + (testCase == 0? "" : testCase));

        Scanner scanner = new Scanner(file);

        int n = scanner.nextInt();

        
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (scanner.hasNextInt())
                    matrix[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
    }
}
