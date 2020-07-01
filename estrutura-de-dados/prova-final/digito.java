
public class digito {
    public static void main(String[] args) {
        System.out.println(redundancias(347290135, 3));
    }

    private static int redundancias(int n, int k) {
        if(n <= 0) return 0;
  
        if (n % 10 == k) return redundancias(n / 10, k) + 1;

        return redundancias(n / 10, k);

    }
}