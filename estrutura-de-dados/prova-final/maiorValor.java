
public class maiorValor {
    public static void main(String[] args) {
        int[] array = new int[3];
        array[0] = 18383;
        array[1] = 50530;
        array[2] = 100;
        System.out.println(maiorRecursivo(array, 3));
        System.out.println(maiorIterativo(array));
    }

    private static int maiorIterativo(int[] array) {
        int maiorValor = 0;

        for (int n : array) {
            if (n >= maiorValor) {
                maiorValor = n;
            }
        }

        return maiorValor;
    }

    private static int maiorRecursivo(int array[], int size) {
        int maiorValor;
        if (size == 1) maiorValor = array[0];
        else {
           maiorValor = maiorRecursivo(array, size - 1); 
           if (maiorValor < array[size - 1]) maiorValor = array[size - 1];
        }
        return maiorValor;
    }
}