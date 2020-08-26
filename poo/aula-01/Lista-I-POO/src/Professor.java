
public class Professor {
    // atributos
    String nome;
    String titulacao;
    Double valorHoraAula;
    int totalDeAulas;

    // método construtor para inicializar os atributos do objeto
    public Professor(String nome, String titulacao, double valorHoraAula, int totalDeAulas) {
        this.nome = nome;
        this.titulacao = titulacao;
        this.valorHoraAula = valorHoraAula;
        this.totalDeAulas = totalDeAulas;
    }

    // método para calcular e retornar o valor do salario
    public double calcularSalario() {
        double sb, ha, dsr;

        // salario base
        sb = totalDeAulas * 4.5 * valorHoraAula;
        if (titulacao.equalsIgnoreCase("mestre")) {
            sb *= 1.03;
        } else {
            sb *= 1.085;
        }
        // hora atividade
        ha = sb * 0.05;

        // descanso semanal remunerado
        dsr = (sb + ha) / 6;
        return (sb + ha + dsr);
    }

    // Método para aplicar um aumento de salario
    public void ajustarValorHoraAula(double porcentagem) {
        valorHoraAula = valorHoraAula + valorHoraAula * porcentagem / 100;

    }

    // Método para retornar os dados de um professor
    public String retonarDados() {
        String aux = ""; // Iniciar uma variavel do tipo stinrg
        aux += "Nome --> " + nome + "\n";
        aux += "Titulação ---> " + titulacao + "\n";
        aux += "Salário --> R$ " + String.format("%.2f", calcularSalario());
        return aux;
    }
}