
public class Main {
    public static void main(String[] args) {
        // gerando um  objeto --> variavel --> tipo (obrigatoriamente uma classe)
        Aluno aluno1 = new Aluno();

        aluno1.nome = "Brenno";
        aluno1.curso = "TECH";
        aluno1.ra = 114476;
        aluno1.nota1 = 9.5;
        aluno1.nota2 = 9.8;

        System.out.println(aluno1);
    }
}