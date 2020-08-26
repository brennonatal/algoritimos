
public class TesteProfessor {
    public static void main(String[] args) {
        // instanciar professor
        // Professor p1 = new Professor();
        // p1.nome = "Humberto";
        // p1.titulacao = "Doutor";
        // p1.totalDeAulas = 32;
        // p1.valorHoraAula = 175.00;

        // System.out.println(p1.retornarDados());

        // p1.ajustarValorHoraAula(30);
        // System.out.println(p1.retornarDados());

        // instanciar Professor usando o metodo construtor
        Professor p2 = new Professor("Flavio", "Doutor", 350.55, 40);
        System.out.println(p2.calcularSalario());

        Professor p3 = new Professor(null, null, 0, 0);
        

    }
}