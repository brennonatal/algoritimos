
public class Lista {
	private No inicio = null; // as variaveis sao automaticamente inicializadas com null
	private No fim; // fim = null

	public void inserirInicio(Musica dado) { // Classe escrita com letra maiuscula, variavel minuscula
		No aux = new No();
		aux.dado = dado;

		if (inicio == null) {
			inicio = fim = aux; // acontece apenas quando a lista tiver vazia

		} else {
			inicio.esq = aux;
			aux.dir = inicio;
			inicio = aux;
		}
	}

	public void inserirMusica(Musica dado) {
		No nova = new No();
		nova.dado = dado;
		No atual = inicio;
		No aux = new No();

		if (inicio == null) { // acontece apenas quando a lista tiver vazia
			inicio = fim = nova;

		} else {
			if (nova.dado.title.compareTo(atual.dado.title) < 0) {// nova vem antes de atual(inicio)
				inserirInicio(dado);

			} else if (nova.dado.title.compareTo(fim.dado.title) > 0) {// fim vem antes de nova
				inserirFinal(dado);
			} else {
				while (atual != null) {
					atual = atual.dir;
					if (nova.dado.title.compareTo(atual.dado.title) < 0) { // se nova vir antes de atual
						aux = atual.esq;
						aux.dir = nova;
						atual.esq = nova;
						nova.esq = aux;
						nova.dir = atual;
						break;
					}
				}
			}
		}
	}

	public void inserirFinal(Musica dado) {
		No aux = new No();
		aux.dado = dado;

		if (inicio == null) { // verifica quando a lista tiver vazia
			inicio = fim = aux;

		} else {
			fim.dir = aux;
			aux.esq = fim;
			fim = aux;

		}
	}

	public void imprimir() {
		No aux = inicio;

		while (aux != null) {
			System.out.println(aux.dado);
			aux = aux.dir;
		}
	}

	public void maisTocadas() {
		No aux = inicio;
		int m1 = 0, m2 = 0, m3 = 0, m4 = 0, m5 = 0;
		Musica top1 = new Musica("_", "_", "_", 0);
		Musica top2 = new Musica("_", "_", "_", 0);
		Musica top3 = new Musica("_", "_", "_", 0);
		Musica top4 = new Musica("_", "_", "_", 0);
		Musica top5 = new Musica("_", "_", "_", 0);

		while (aux != null) {
			if (aux.dado.played > m1) {
				top1 = aux.dado;
				m1 = aux.dado.played;
				aux = aux.dir;
				continue;
			} else if (aux.dado.played > m2) {
				top2 = aux.dado;
				m2 = aux.dado.played;
				aux = aux.dir;
				continue;
			} else if (aux.dado.played > m3) {
				top3 = aux.dado;
				m3 = aux.dado.played;
				aux = aux.dir;
				continue;
			} else if (aux.dado.played > m4) {
				top4 = aux.dado;
				m4 = aux.dado.played;
				aux = aux.dir;
				continue;
			} else if (aux.dado.played > m5) {
				top5 = aux.dado;
				m5 = aux.dado.played;
				aux = aux.dir;
				continue;
			}
			aux = aux.dir;
		}

		if (top1.genre == "_") {
			System.out.println("Você ainda não escutou nenhuma música.");
		}
		
		if (top1.genre != "_") {
			if (top1.played == 1) {
				System.out.println("Primeira mais tocada --> \"" + top1.title + "\" tocada " + m1 + " vez.");
			} else {
				System.out.println("Primeira mais tocada --> \"" + top1.title + "\" tocada " + m1 + " vezes.");
			}
		}
		if (top2.genre != "_") {
			if (top2.played == 1) {
				System.out.println("Segunda mais tocada --> \"" + top2.title + "\" tocada " + m2 + " vez.");

			} else {
				System.out.println("Segunda mais tocada --> \"" + top2.title + "\" tocada " + m2 + " vezes.");
			}

		}
		if (top3.genre != "_") {
			if (top3.played == 1) {
				System.out.println("Terceira mais tocada --> \"" + top3.title + "\" tocada " + m3 + " vez.");
			} else {
				System.out.println("Terceira mais tocada --> \"" + top3.title + "\" tocada " + m3 + " vezes.");

			}

		}
		if (top4.genre != "_") {
			if (top4.played == 1) {
				System.out.println("Quarta mais tocada --> \"" + top4.title + "\" tocada " + m4 + " vez.");
			} else {
				System.out.println("Quarta mais tocada --> \"" + top4.title + "\" tocada " + m4 + " vezes.");
			}

		}
		if (top5.genre != "_") {
			if (top5.played == 1) {
				System.out.println("Quinta mais tocada --> \"" + top5.title + "\" tocada " + m5 + " vez.");

			} else {
				System.out.println("Quinta mais tocada --> \"" + top5.title + "\" tocada " + m5 + " vezes.");
			}

		}
		System.out.println("");
	}

	public void imprimirMaisTocadas() {
		No aux = inicio;
		int m1 = 0, m2 = 0, m3 = 0, m4 = 0, m5 = 0;
		Musica top1 = new Musica("_", "_", "_", 0);
		Musica top2 = new Musica("_", "_", "_", 0);
		Musica top3 = new Musica("_", "_", "_", 0);
		Musica top4 = new Musica("_", "_", "_", 0);
		Musica top5 = new Musica("_", "_", "_", 0);

		while (aux != null) {
			if (aux.dado.played >= m1) {
				if (aux.dado.title.compareTo(top1.title) != 0) {// Se os titulos nao forem identicos
					if (aux.dado.title.compareTo(top1.title) < 0) {// Se o titulo de aux vier antes de top
						top1 = aux.dado;
						m1 = aux.dado.played;
					} else {
						m2 = aux.dado.played;
						top2 = aux.dado;
					}
				}
				aux = aux.dir;
				continue;
			}

			else if (aux.dado.played >= m2 && aux.dado.played <= m1) {
				if (aux.dado.title.compareTo(top2.title) != 0) {// Se os titulos nao forem identicos
					if (aux.dado.title.compareTo(top2.title) < 0) {// Se o titulo de aux vier antes de top
						top2 = aux.dado;
						m2 = aux.dado.played;
					} else {
						m3 = aux.dado.played;
						top3 = aux.dado;
					}
				}
				aux = aux.dir;
				continue;
			} else if (aux.dado.played >= m3 && aux.dado.played <= m2) {
				if (aux.dado.title.compareTo(top3.title) != 0) {// Se os titulos nao forem identicos
					if (aux.dado.title.compareTo(top3.title) < 0) {// Se o titulo de aux vier antes de top
						top3 = aux.dado;
						m3 = aux.dado.played;
					} else {
						m4 = aux.dado.played;
						top4 = aux.dado;
					}
				}
				aux = aux.dir;
				continue;
			} else if (aux.dado.played >= m4 && aux.dado.played <= m3) {
				if (aux.dado.title.compareTo(top4.title) != 0) {// Se os titulos nao forem identicos
					if (aux.dado.title.compareTo(top4.title) < 0) {// Se o titulo de aux vier antes de top
						top4 = aux.dado;
						m4 = aux.dado.played;
					} else {
						m5 = aux.dado.played;
						top5 = aux.dado;
					}
				}
				aux = aux.dir;
				continue;
			} else if (aux.dado.played >= m5 && aux.dado.played <= m4) {
				if (aux.dado.title.compareTo(top5.title) != 0) {// Se os titulos nao forem identicos
					if (aux.dado.title.compareTo(top5.title) < 0) {// Se o titulo de aux vier antes de top
						top5 = aux.dado;
						m5 = aux.dado.played;
					}
				}
				aux = aux.dir;
				continue;
			}
			aux = aux.dir;
		}

		if (top1.genre != "_") {
			System.out.println("Primeira mais tocada --> " + top1.title + " tocada " + m1 + " vezes.");

		}
		if (top2.genre != "_") {
			System.out.println("Segunda mais tocada --> " + top2.title + " tocada " + m2 + " vezes.");
		}
		if (top3.genre != "_") {
			System.out.println("Terceira mais tocada --> " + top3.title + " tocada " + m3 + " vezes.");
		}
		if (top4.genre != "_") {
			System.out.println("Quarta mais tocada --> " + top4.title + " tocada " + m4 + " vezes.");
		}
		if (top5.genre != "_") {
			System.out.println("Quinta mais tocada --> " + top5.title + " tocada " + m5 + " vezes.");
		}

	}

	public No pesquisar(String title) { // recebe um RA e retorna o endereco de memoria do aluno
		No aux = inicio;

		while (aux != null) {
			if (aux.dado.title.equals(title)) {
				break;
			} else {
				aux = aux.dir;
			}
		}
		return aux; // Tem null caso nao tenha encontrado o RA 
					// ou tem o endereco do no onde o RA foi encontrado
	}

	public void remover(String title) {
		No no = pesquisar(title); // recebe null ou endereco do no

		if (no != null) { // significa que encontrou a musica
			
			if (no == inicio && no == fim) {
				inicio = null;
				fim = null;
				no = null;
				System.out.println("");
				System.out.println("Música removida com sucesso!");
				System.out.println("");
			}
			
			else if (no == inicio) { // remover o primeiro no
				no.dir.esq = null;
				inicio = no.dir;
				no = null;

				System.out.println("");
				System.out.println("Música removida com sucesso!");
				System.out.println("");

			} else if (no == fim) { // remover o ultimo no
				no.esq.dir = null;
				fim = no.esq;
				no = null;
				System.out.println("");
				System.out.println("Música removida com sucesso!");
				System.out.println("");

			} else { // senao vai remover um no que esta no meio a lista
				no.esq.dir = no.dir;
				no.dir.esq = no.esq;
				no = null;
				System.out.println("");
				System.out.println("Música removida com sucesso!");
				System.out.println("");

			}
		} else {
			System.out.println("");
			System.out.println("A música não foi encontrada!");
			System.out.println("");
		}
	}

}
