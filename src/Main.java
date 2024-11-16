import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        do {
            try {
                ExtractData.extractData(1);
            } catch (FileNotFoundException e){
                break;
            }
        }while (true);
    }
}