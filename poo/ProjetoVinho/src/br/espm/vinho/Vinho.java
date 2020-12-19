package br.espm.vinho;

public class Vinho {
	private int id;
	private String cpf_cnpj;
	private String produto;
	private String casta;
	private int safra;
	private double pontuacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getCasta() {
		return casta;
	}

	public void setCasta(String casta) {
		this.casta = casta;
	}

	public int getSafra() {
		return safra;
	}

	public void setSafra(int safra) {
		this.safra = safra;
	}

	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public Vinho(int id, String cpf_cnpj, String produto, String casta, int safra, double pontuacao) {
		this.id = id;
		this.cpf_cnpj = cpf_cnpj;
		this.produto = produto;
		this.casta = casta;
		this.safra = safra;
		this.pontuacao = pontuacao;
	}
	
}
