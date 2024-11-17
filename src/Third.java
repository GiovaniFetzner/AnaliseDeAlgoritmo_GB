import java.util.ArrayList;
import java.util.List;

public class Third {

    public static List<List<Plate>> generateInversions(Plate[] championship) {
        List<List<Plate>> results = new ArrayList<>();
        generateInversionsRecursive(championship, 0, results);
        return results;
    }

    private static void generateInversionsRecursive(Plate[] championship, int index, List<List<Plate>> results) {
        if (index == championship.length) {
            List<Plate> current = new ArrayList<>();
            for (Plate plate : championship) {
                current.add(new Plate(plate.getA(), plate.getB()));
            }
            results.add(current);
            return;
        }

        int increment = index == 0 ? 2 : 1;

        generateInversionsRecursive(championship, index + increment, results);

        int a = championship[index].getA();
        int b = championship[index].getB();
        championship[index].setA(b);
        championship[index].setB(a);

        generateInversionsRecursive(championship, index + increment, results);

        championship[index].setA(a);
        championship[index].setB(b);
    }
}
