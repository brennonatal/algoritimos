package br.espm.reservas;

import br.espm.cliente.*;

public class Reserva implements Pagamento{

	private Cliente cliente;
	private boolean pagamentoAVista;
	
	public Reserva(Cliente cliente, boolean pagamentoAVista) {
		this.cliente = cliente;
		this.pagamentoAVista = pagamentoAVista;
	}

	@Override
	public String toString() {
		String pagamento;
		if (pagamentoAVista) {
			pagamento = "à vista";
		} else {
			pagamento = "parcelado";
		}
		return "Reserva:\n\t" + cliente + "\n\tTipo de pagamento: " + pagamento + "\n\tValor: R$" + calcularPagamento() + "\n\n";
	}

	@Override
	public double calcularPagamento() {
		if (pagamentoAVista) {
			return 3200 * 0.90;
		}
		return 3200;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public boolean isPagamentoAVista() {
		return pagamentoAVista;
	}

	
}
