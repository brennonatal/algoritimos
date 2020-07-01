
public class Potencia {
    public static void main(String[] args) {
        System.out.print(potencia(4, 2));
    }

    private static int potencia(int x, int n) {
        if (n == 0)
            return 1;
        else
            return x * potencia(x, n - 1);
        
    }
}