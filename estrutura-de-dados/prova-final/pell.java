
public class pell {
    public static void main(String[] args) {

        System.out.println(p(10));
        System.out.println(somatorial(10));
    }

    private static long p(long n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n >= 2)
            return 2 * p(n - 1) + p(n - 2);
        return n;
    }

    private static int somatorial(int n) {
        int resultado = 0;
        for (int i = n; i > 0; i--) {
            resultado += i;
        }
        return resultado;
    }
}