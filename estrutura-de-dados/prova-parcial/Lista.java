public class Lista<E> {
    No<E> inicio, fim;

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    // insere um elemento no início da lista
    public void inserirInicio(E elemento) {
    }

    // insere um elemento no final da lista
    public void inserirFinal(E elemento) {
    }

    // pesquisa um elemento na lista
    // se o elemento estiver, retorna sua referência (endereço)
    // se não estiver, retorna null
    public E pesquisar(E elemento) {
        return elemento;
    }

    public int contador() {
        No<E> aux = inicio;
        int contador = 0;
        while (aux != null) {
            contador++;
            aux = aux.dir;
        }
        return contador;
    }

    public E[] copiarLista() {
        No<E> aux = inicio;
        E[] lista = new E[contador()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = aux.elemento;
            aux = aux.dir;
        }
        return lista;
    }
}