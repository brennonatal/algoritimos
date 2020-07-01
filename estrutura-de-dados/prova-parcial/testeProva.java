/**
 * testeProva
 */
public class testeProva {
    public static void main(String[] args) {
        int[][] matriz = new int[][] { { 1, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

        int x = maisEstradas(matriz, 4);

        System.out.println(x);

        Lista<User> lista = new Lista<User>();

        User brenno = new User("meu nome");

    


    }

    private static int maisEstradas(int[][] matriz, int n) {

        int maior = 0;
        int numEstradas = 0;

        for (int i = 0; i < n; i++) {

            int contador = 0;

            for (int j = 0; j < n; j++) {

                if (matriz[j][i] == 1) {
                    contador++;
                }
            }
            if (contador > numEstradas) {
                numEstradas = contador;
                maior = i;
            }
        }

        // sem somar 1, o index funcionaria como um array (0 - (n-1))
        return maior + 1;

    }



}
