
public class CartaoDeCredito {
    int numero;
    double totalFatura;

    public CartaoDeCredito(int numero, double totalFatura) {
        this.numero = numero;
        this.totalFatura = totalFatura;
    }

    public double consultarFatura() {
        return totalFatura;
    }

    public String retornarDados() {
        return "Número: " + numero + "Valor da fatura: " + totalFatura;
    }
}