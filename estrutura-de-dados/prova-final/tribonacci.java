
public class tribonacci {

    public static void main(String[] args) {

        System.out.println(f(9));

        int n = 10;
        int resultado = 0;
        for (int i = n; i > 0; i--) {
            resultado += i;
        }
        System.out.println(resultado);

    }


    private static int f(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        if (n > 2)
            return f(n - 1) + f(-2) + f(n - 2);
        return n;
    }

}
