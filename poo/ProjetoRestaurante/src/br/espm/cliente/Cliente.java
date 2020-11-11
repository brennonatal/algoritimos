package br.espm.cliente;

public abstract class Cliente {

	private String nome;

	public Cliente(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + "]";
	}

	public String getNome() {
		return nome;
	}

}