
public class Cliente {
    String nome;
    String cpf;

    // metodo construtor nao tem tipo de retorno
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Método para retornar os dados de um cliente
    public String retonarDados() {
        return "Nome: " + nome + "\nCPF: " + cpf;
    }
}