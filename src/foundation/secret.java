package foundation;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class secret {
    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }

    public static List<Pair> split(int secret, int W, int T, int p) {
        List<Pair> result = new ArrayList<>();
        int coefficient[] = new int[T];
        Random random = new Random();
        for (int i = 0; i < T; i++) {
            coefficient[i] = random.nextInt(p - 1) + 1;
        }
        coefficient[0] = secret;
        System.out.println(printEq(coefficient, p));
        ;
        for (int i = 1; i < W; i++) {
            result.add(cal(i, coefficient, p));
        }
        return result;
    }

    public static int restore(int T, int p, List<Pair> list) {
        return 0;
    }

    public static String printEq(int coefficient[], int p) {
        String result = "f(x) = ";
        for (int i = 0; i < coefficient.length; i++) {
            if (i == 0)
                result += coefficient[i] + " + ";
            else if (i == 1)
                result += coefficient[i] + "x + ";
            else
                result += coefficient[i] + "x^" + i + " + ";
        }
        result = result.substring(0, result.length() - 2);
        result += "\tmod " + p;
        return result;
    }

    public static Pair cal(int x, int[] coefficient, int p) {
        int y = 0;
        for (int i = 0; i < coefficient.length; i++) {
            y += coefficient[i] * Math.pow(x, i);
            y %= p;
        }
        return new Pair(x, y);
    }

    public static void main(String[] args) {
        System.out.println(split(8, 4, 3, 19));
    }
}
