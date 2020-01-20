package annodemo;

@ExtractInterface("IMultiplier")
public class Multiplier {
    public int muliplier(int x, int y) {
        int total = 0;
        return x * y;
    }

    private int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        System.out.println(m.muliplier(22,11));
    }
}
