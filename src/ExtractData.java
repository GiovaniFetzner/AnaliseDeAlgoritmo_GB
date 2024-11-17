import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractData {

    public static List<Plate[]> extractData(int testCase) throws FileNotFoundException {
        //Funciona como batch de todos os campeonatos do arquivo de texto
        File file = new File("data/in" + (testCase == 0 ? "" : testCase));

        Scanner scanner = new Scanner(file);
        List<Plate[]> championships = new ArrayList<Plate[]>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] fields = input.split(" ");

            if (fields.length == 1 && fields[0].equals("0"))
                break;
            if (fields.length == 1) {
                int n = Integer.parseInt(fields[0]);
                Plate[] championship = new Plate[n];
                for (int i = 1; i <= n; i++) {
                    input = scanner.nextLine();
                    fields = input.split(" ");

                    championship[i - 1] = new Plate(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]));
                }
                championships.add(championship);
            }
        }
        scanner.close();
        return championships;
    }

}
