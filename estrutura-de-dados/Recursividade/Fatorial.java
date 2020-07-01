/**
 * Fatorial
 */
public class Fatorial {

    public static void main(String[] args) {
        System.out.println(fatorial(5));
    }

    private static int fatorial(int n) {
        int fat = 1;
        for (int i = 1; i <= n; i++) {
            fat *= i;
        }

        return fat;
    }
}