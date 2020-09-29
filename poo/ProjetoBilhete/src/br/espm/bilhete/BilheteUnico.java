package br.espm.bilhete;
import javax.swing.JOptionPane;

import br.espm.usuario.*;

public class BilheteUnico {
	private int numero;
	private Usuario usuario;
	private double saldo;
	private static double valorDaPassagem = 4.40;
	
	public BilheteUnico(int numero, Usuario usuario, double saldo) {
		this.numero = numero;
		this.usuario = usuario;
		this.saldo = saldo;
	}
	
	public String getDados() {
		
		String aux = "";
		aux += "Numero: " + numero + "\nUsuário: \n" + usuario.getDados() + "Saldo: " + saldo + "\n\n";
		return aux;
	}
	

	public void passarNaCatraca() {
		
		if(saldo >= valorDaPassagem) {
			saldo -= valorDaPassagem;
			JOptionPane.showMessageDialog(null, "Saldo restante: R$ " + saldo + "\nBoa viagem!");
		} else {
			JOptionPane.showMessageDialog(null, "Sem saldo suficiente!\n");
		}
	}
	
	public void carregarBilhete(double valor) {
		saldo += valor;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
