package br.espm.cliente;

public class Cliente {
	private String nome;
	private String cpf_cnpj;
	private String email;
	private String senha;
	private String tipoDeCliente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoDeCliente() {
		return tipoDeCliente;
	}

	public void setTipoDeCliente(String tipoDeCliente) {
		this.tipoDeCliente = tipoDeCliente;
	}

	public Cliente(String nome, String cpf_cnpj, String email, String senha, String tipoDeCliente) {
		this.nome = nome;
		this.cpf_cnpj = cpf_cnpj;
		this.email = email;
		this.senha = senha;
		this.tipoDeCliente = tipoDeCliente;
	}

}
