package br.espm.main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.espm.cliente.*;
import br.espm.reservas.*;

public class Main {

	private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();

	public static void main(String[] args) {

		// INSERCAO PARA TESTES
//		reservas.add(new Reserva(new PessoaFisica("1", "1"), true));
//		reservas.add(new Reserva(new PessoaJuridica("2", "2"), false));
//		reservas.add(new Reserva(new PessoaFisica("3", "3"), true));
//		reservas.add(new Reserva(new PessoaJuridica("4", "4"), true));
//		reservas.add(new Reserva(new PessoaFisica("5", "5"), false));
//		reservas.add(new Reserva(new PessoaJuridica("6", "6"), true));
//		reservas.add(new Reserva(new PessoaFisica("7", "7"), false));
//		reservas.add(new Reserva(new PessoaJuridica("8", "8"), true));

		int opcao = 0;
		while (opcao != 6) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(
						"Restaurente SABOR SOFISTICADO\n1. Reservar mesa\n2. Pesquisar reserva\n3. Imprimir reservas\n4. Imprimir lista de espera\n5. Cancelar reserva\n6. Finalizar"));
				if (opcao > 6 || opcao < 1) {
					JOptionPane.showMessageDialog(null, "Voce deve digitar um numero entre 1 e 6");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Voce deve digitar um numero inteiro");
			} catch (ArithmeticException e) {
				JOptionPane.showMessageDialog(null, e);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			switch (opcao) {
			case 1:
				reservarMesa();
				break;
			case 2:
				pesquisarReserva();
				break;
			case 3:
				imprimirReservas();
				break;
			case 4:
				imprimirListaDeEspera();
				break;
			case 5:
				cancelarReserva();
				break;
			}
		}

	}

	private static void cancelarReserva() {
		// TODO Auto-generated method stub
		if (reservas.size() == 0) {
			JOptionPane.showMessageDialog(null, "Não há nenhuma reserva cadastrada");
			return;
		}

		String documento = JOptionPane.showInputDialog("Insira o número do CPF ou CNPJ:");

		if (documento == null)
			return;
		int posicao = -1;

		for (int i = 0; i < reservas.size(); i++) {

			if (getDoc(reservas.get(i).getCliente()).equals(documento)) {
				posicao = i;
			}

		}
		if (posicao != -1) {
			String nome = reservas.get(posicao).getCliente().getNome();
			reservas.remove(posicao);
			JOptionPane.showMessageDialog(null, nome + ", sua reserva foi cancelada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Infelizmente não achamos sua reserva :(");

		}
	}

	private static void imprimirListaDeEspera() {
		// TODO Auto-generated method stub
		String aux = "LISTA DE ESPERA: \n";

		if (reservas.size() == 0) {
			JOptionPane.showMessageDialog(null, aux + "Não há nenhuma reserva cadastrada");
			return;
		}

		for (int i = 6; i < reservas.size(); i++) {

			if (reservas.get(i).getCliente() != null) {
				aux += reservas.get(i).toString();
			}

		}

		JOptionPane.showMessageDialog(null, aux);
	}

	private static void imprimirReservas() {
		// TODO Auto-generated method stub
		String aux = "MESAS RESERVADAS: \n";

		if (reservas.size() == 0) {
			JOptionPane.showMessageDialog(null, aux + "Não há nenhuma reserva cadastrada");
			return;
		}

		for (int i = 0; i < reservas.size(); i++) {

			if (reservas.get(i).getCliente() != null && i < 6) {
				aux += reservas.get(i).toString();
			}

		}

		JOptionPane.showMessageDialog(null, aux);
	}

	private static void pesquisarReserva() {
		// TODO Auto-generated method stub
		if (reservas.size() == 0) {
			JOptionPane.showMessageDialog(null, "Não há nenhuma reserva cadastrada no sistema");
			return;
		}

		String documento = JOptionPane.showInputDialog("Insira o número do CPF ou CNPJ:");

		if (documento == null)
			return;
		int posicao = -1;

		for (int i = 0; i < reservas.size(); i++) {

			if (getDoc(reservas.get(i).getCliente()).equals(documento)) {
				posicao = i;
			}

		}
		if (posicao != -1) {
			if (posicao > 5) { // lista de espera
				JOptionPane.showMessageDialog(null, reservas.get(posicao).getCliente().getNome()
						+ ", achamos sua reserva!\n" + "Você está em " + (posicao - 5) + "º lugar na lista de espera.");
			} else { // reservados
				JOptionPane.showMessageDialog(null,
						reservas.get(posicao).getCliente().getNome() + ", sua mesa está reservada!\n");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Infelizmente não achamos sua reserva :(");

		}

	}

	public static String getDoc(Cliente cliente) {
		if (cliente instanceof PessoaFisica)

			return ((PessoaFisica) cliente).getCpf();

		else if (cliente instanceof PessoaJuridica)

			return ((PessoaJuridica) cliente).getCnpj();

		return null;
	}

	private static void reservarMesa() {
		// TODO Auto-generated method stub
		int tipo_de_pessoa = 0;
		while (tipo_de_pessoa < 1 || tipo_de_pessoa > 2) {
			try {
				tipo_de_pessoa = Integer.parseInt(
						JOptionPane.showInputDialog("Escolha o tipo de pessoa:\n1. Pessoa Fisica\n2. Pessoa Juridica"));
				if (tipo_de_pessoa > 2 || tipo_de_pessoa < 1) {
					JOptionPane.showMessageDialog(null, "Voce deve digitar 1 ou 2");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Voce deve digitar um numero inteiro");
				tipo_de_pessoa = 0;
			} catch (ArithmeticException e) {
				JOptionPane.showMessageDialog(null, e);
				tipo_de_pessoa = 0;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				tipo_de_pessoa = 0;
			}
		}
		String nome = "";
		int pagamento;

		switch (tipo_de_pessoa) {
		case 1:
			nome = JOptionPane.showInputDialog("Por favor insira seu nome: ");
			String cpf = JOptionPane.showInputDialog("Insira seu CPF: ");
			PessoaFisica pessoa = new PessoaFisica(nome, cpf);

			pagamento = JOptionPane.showConfirmDialog(null, "O pagamento será feito à vista?");

			if (pagamento == 2) {
				JOptionPane.showMessageDialog(null, "Cancelando solicitação");
				return;
			}

			if (reservas.size() >= 6) {
				JOptionPane.showMessageDialog(null,
						"Infelizmente, não estamos aceitando novas reservas no momento.\n\nSua solicitação entrará em nossa lista de espera :)");
			} else {
				JOptionPane.showMessageDialog(null, "Reserva efefuada com sucesso!");
			}

			reservas.add(new Reserva(pessoa, (pagamento == 1) ? false : true));

			break;
		case 2:
			nome = JOptionPane.showInputDialog("Por favor insira o nome da empresa: ");
			String cnpj = JOptionPane.showInputDialog("Insira a CPNJ: ");
			PessoaJuridica empresa = new PessoaJuridica(nome, cnpj);

			pagamento = JOptionPane.showConfirmDialog(null, "O pagamento será feito à vista?");

			if (pagamento == 2) {
				JOptionPane.showMessageDialog(null, "Cancelando solicitação");
				return;
			}

			if (reservas.size() >= 6) {
				JOptionPane.showMessageDialog(null,
						"Infelizmente, não estamos aceitando novas reservas no momento.\n\nSua solicitação entrará em nossa lista de espera :)");
			} else {
				JOptionPane.showMessageDialog(null, "Reserva efefuada com sucesso!");
			}

			reservas.add(new Reserva(empresa, (pagamento == 1) ? false : true));

			break;
		}

	}

}
