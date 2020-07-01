
public class binario {
    public static void main(String[] args) {

        binarioRecursivo(253);
        System.out.println("");
        binarioIterativo(253);

    }

    private static void binarioIterativo(int n) {
        String bin = "";
        String reverseBin = "";

        while (n > 0) {
            if (n % 2 != 0) {
                bin += "1";
            } else {
                bin += "0";
            }
            n /= 2;
        }

        for (int i = bin.length() - 1; i >= 0; i--) {
            reverseBin += bin.charAt(i);
        }

        System.out.println(reverseBin);
    }

    private static void binarioRecursivo(int n) {
        if (n / 2 != 0)
            binarioRecursivo(n / 2);
        System.out.print(n % 2);
    }
}