package br.espm.cliente;

public class PessoaJuridica extends Cliente {
	
	private String cnpj;

	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		
		return "Nome: " + this.getNome() + "\n\tTipo de cliente: Pessoa Juridica\n\tCNPJ: " + cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}
}
