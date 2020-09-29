package br.espm.usuario;
import br.espm.tipo.*;

public class Usuario {
	private String nome;
	private String cpf;
	private TipoDeUsuario tipo;
	
	
	public Usuario(String nome, String cpf, TipoDeUsuario tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
	}


	public String getDados() {
		
		String aux = "";
		aux += "\tNome: " + nome + "\n\tCPF: " + cpf + "\n\tTipo de usuario: " + tipo + "\n";
		return aux;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public TipoDeUsuario getTipo() {
		return tipo;
	}


	public void setTipo(TipoDeUsuario tipo) {
		this.tipo = tipo;
	}
	
	
}
