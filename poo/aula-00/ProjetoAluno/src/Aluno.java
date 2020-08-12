
public class Aluno {
    // atributo, propriedade ou variavel de instancia --> variaveis
    int ra;
    String nome;
    String curso;
    double nota1;
    double nota2;

    public Aluno(int ra, String nome, String curso, double nota1, double nota2) {
		this.ra = ra;
        this.nome = nome;
        this.curso = curso;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
   
    @Override
	public String toString() {
		return "RA: " + ra + " | Nome: " + nome + " | Curso: " + curso + " | Nota: " + (nota1 + nota2) / 2;
	}
}