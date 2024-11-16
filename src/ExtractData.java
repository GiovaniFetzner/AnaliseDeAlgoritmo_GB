import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExtractData {

    public static void extractData(int testCase) throws FileNotFoundException {

        File file = new File("../data/in" + (testCase == 0? "" : testCase));

        Scanner scanner = new Scanner(file);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Número de placas no campeonato: " + n);
        
        System.out.println(n);

        scanner.close();
    }
}
