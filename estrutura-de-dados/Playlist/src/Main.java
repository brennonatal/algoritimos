import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Lista lista = new Lista();

		int option;

		System.out.println("Menu: ");
		System.out.println("1.Inserir m�sica na playlist. ");
		System.out.println("2.Tocar m�sica. ");
		System.out.println("3.Remover m�sica. ");
		System.out.println("4.Exibir as mais tocadas. ");
		System.out.println("5.Exibir playlist completa. ");
		System.out.println("6.Finalizar. ");

		System.out.println("");
		System.out.print("Selecione uma op��o: ");
		option = input.nextInt();
		System.out.println("");

		while (option != 6) {
			if (option == 1) {
				input.nextLine();
				String title = null, artist = null, genre = null;
				while (genre == null) {
					System.out.print("Digite o titulo da m�sica que deseja adicionar: ");
					title = input.nextLine();
					System.out.print("Digite o artista da m�sica: ");
					artist = input.nextLine();
					System.out.print("Digite o g�nero da m�sica: ");
					genre = input.nextLine();
				}

				Musica song = new Musica(title, artist, genre, 0);

				lista.inserirMusica(song);

				System.out.println("");
				System.out.println("M�sica adicionada com sucesso!");
				System.out.println("");

			} else if (option == 2) {
				input.nextLine();
				String title = null;
				while (title == null) {
					System.out.print("Digite o t�tulo da m�sica que deseja escutar: ");
					title = input.nextLine();
				}
				No song = lista.pesquisar(title);
				if (song == null) {
					System.out.println("");
					System.out.println("A m�sica n�o existe nessa playlist, digite 1 para adicion�-la.");
					System.out.println("");
				} else {
					song.dado.played++;
					System.out.println("");
					System.out.println("Tocando \"" + song.dado.title + "\" - " + song.dado.artist);
					System.out.println("M�sica do g�nero: " + song.dado.genre);
					if (song.dado.played == 1) {
						System.out.println("Essa m�sica foi tocada apenas " + song.dado.played + " vez.");
					} else {
						System.out.println("Essa m�sica j� foi tocada " + song.dado.played + " vezes.");
					}
					System.out.println("");
				}

			} else if (option == 3) {
				input.nextLine();
				String titulo = null;
				while (titulo == null) {
					System.out.print("Digite o nome da m�sica que deseja remover: ");
					titulo = input.nextLine();
				}
				lista.remover(titulo);

			} else if (option == 4) {
				lista.maisTocadas();

			} else if (option == 5) {
				lista.imprimir();

			} else {
				System.out.println("A op��o escolhida � inv�lida, tente novamente.");
				System.out.println("");

			}

			System.out.print("Selecione outra op��o: ");
			System.out.println(
					"1-Adicionar m�sica/2-Tocar m�sica/3-Remover m�sica/4-Exibir mais tocadas/5-Ver playlist/6-Finalizar");
			option = input.nextInt();
			System.out.println("");
		}

		System.out.println("Encerrando aplicativo de m�sicas...");
		input.close();
		System.out.println("Aplicativo encerrado com sucesso!");

	}

}
