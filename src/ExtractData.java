import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractData {

    public static List<Plate[]> extractData(int testCase) throws FileNotFoundException {
        File directory = new File("../data");
        if (!directory.exists() || !directory.isDirectory())
            throw new FileNotFoundException("O diretorio 'data' nao existe ou nao e um diretorio valido.");

        File[] matchingFiles = directory.listFiles((dir, name) -> name.startsWith("in"));
        if (matchingFiles == null || matchingFiles.length == 0)
            throw new FileNotFoundException("Nenhum arquivo 'in' encontrado na pasta 'data'.");

        File file = new File("../data/in" + (testCase == 0 ? "" : testCase));
        if (!file.exists()) {
            if (testCase == 0)
                throw new FileNotFoundException("bateria de testes finalizada");
        }

        Scanner scanner = new Scanner(file);
        List<Plate[]> championships = new ArrayList<>();

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
