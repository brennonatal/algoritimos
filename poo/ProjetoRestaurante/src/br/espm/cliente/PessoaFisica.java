package br.espm.cliente;

public class PessoaFisica extends Cliente{

	private String cpf;
	
	public PessoaFisica(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		
		return "Nome: " + this.getNome() + "\n\tTipo de cliente: Pessoa Fisica\n\tCPF: " + cpf;
	}

	public String getCpf() {
		return cpf;
	}
}
