public class Plate {

    private int a;
    private int b;

    public Plate(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int sumAB(){
        return a + b;
    }

    @Override
    public String toString() {
        return a + " " + b;
    }

    public String getOrderedValues() {
        if (getA() <= getB()){
            return getA() + " " + getB();
        }else {
            return getB() + " " + getA();
        }
    }
}
