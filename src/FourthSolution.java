import java.util.*;

public class FourthSolution {

    public static String fourthSolution(Plate[] championship) {
        boolean evenSum = getGeneralSum(championship) % 2 == 0;

        if (evenSum) {
            List<List<Plate>> results = generateInversionsIterative(championship);

            int solution = 0;
            for (List<Plate> objects : results) {
                int top = 0;
                int bottom = 0;
                for (Plate plate : objects) {
                    top += plate.getA();
                    bottom += plate.getB();
                }

                if ((top > solution) && (top == bottom)) {
                    solution = top;
                }
            }

            if (solution != 0) {
                return solution + " nenhuma placa descartada";
            }
        }

        return "impossivel";
    }

    public static List<List<Plate>> generateInversionsIterative(Plate[] championship) {
        List<List<Plate>> results = new ArrayList<>();
        Stack<State> stack = new Stack<>();
        stack.push(new State(championship.clone(), 0));

        while (!stack.isEmpty()) {
            State currentState = stack.pop();
            Plate[] currentChampionship = currentState.championship;
            int index = currentState.index;

            if (index == championship.length) {
                // Cria uma lista de placas no estado atual e adiciona ao resultado
                List<Plate> current = new ArrayList<>();
                for (Plate plate : currentChampionship) {
                    current.add(new Plate(plate.getA(), plate.getB()));
                }
                results.add(current);
                continue;
            }

            // Simula a chamada para o próximo índice sem troca
            stack.push(new State(currentChampionship.clone(), index + 1));

            // Simula a chamada para o próximo índice com troca
            int a = currentChampionship[index].getA();
            int b = currentChampionship[index].getB();
            currentChampionship[index].setA(b);
            currentChampionship[index].setB(a);

            stack.push(new State(currentChampionship.clone(), index + 1));

            // Restaura o estado original
            currentChampionship[index].setA(a);
            currentChampionship[index].setB(b);
        }

        return results;
    }

    private static int getGeneralSum(Plate[] championship) {
        int generalSum = 0;
        for (Plate plate : championship)
            generalSum += plate.sumAB();
        return generalSum;
    }

    // Classe auxiliar para armazenar o estado atual
    private static class State {
        Plate[] championship;
        int index;

        public State(Plate[] championship, int index) {
            this.championship = championship;
            this.index = index;
        }
    }
}
