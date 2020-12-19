package br.espm.main;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.espm.cliente.*;
import br.espm.vinho.*;

public class Main {

	private static ClienteDAO cli_dao = new ClienteDAO();
	private static VinhoDAO vin_dao = new VinhoDAO();

	public static void main(String[] args) {
		Frame frame = JOptionPane.getRootFrame();
		int resp = 0;
		try {
			resp = Integer.parseInt(JOptionPane.showInputDialog(frame, "Importadora BACO\n\nDigite 1 para logar ou 2 para se cadastrar."));

			if (resp > 2 || resp < 1) {
				JOptionPane.showMessageDialog(null, "Voce deve digitar 1 ou 2");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Voce deve digitar um numero inteiro");
		} catch (ArithmeticException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		switch (resp) {
		case 1:
			telaLogin();
			break;
		case 2:
			cadastroDeCliente();
			break;
			
		}

	}

	private static void telaLogin() {

		Frame frame = JOptionPane.getRootFrame();
		String cpf_cnpj = JOptionPane.showInputDialog(frame, "LOGIN\n\nCPF / CNPJ:");
		String senha = JOptionPane.showInputDialog(frame, "LOGIN\n\nSenha:");

		ArrayList<Cliente> users_found = cli_dao.pesquisarCliente(cpf_cnpj, senha);

		if (users_found.size() == 0) {
			int resp = JOptionPane.showConfirmDialog(frame, "Cliente não cadastrado\n\nDeseja realizar o cadastro?");
			System.out.println(resp);
			if (resp == JOptionPane.YES_OPTION) {
				cadastroDeCliente();
			} else {
				JOptionPane.showMessageDialog(frame, "Fechando sistema");
				return;
			}
		} else {
			int resp = 0;
			try {
				resp = Integer.parseInt(JOptionPane.showInputDialog(frame, "Bem vindo " + users_found.get(0).getNome()
						+ "!\n\nDigite 1 para cadastrar um vinho ou 2 para listar."));

				if (resp > 2 || resp < 1) {
					JOptionPane.showMessageDialog(null, "Voce deve digitar 1 ou 2");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Voce deve digitar um numero inteiro");
			} catch (ArithmeticException e) {
				JOptionPane.showMessageDialog(null, e);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			switch (resp) {
			case 1:
				cadastroDeVinhos(users_found.get(0).getCpf_cnpj());
				break;
			case 2:
				listarVinhos();
				break;

			}
		}

	}

	private static void cadastroDeCliente() {
		Frame frame = JOptionPane.getRootFrame();
		String cpf_cnpj = JOptionPane.showInputDialog(frame, "Cadastro\n\nInsira seu CPF / CNPJ:");
		String nome = JOptionPane.showInputDialog(frame, "Cadastro\n\nInsira seu nome:");
		String email = JOptionPane.showInputDialog(frame, "Cadastro\n\nInsira seu email:");
		String senha = JOptionPane.showInputDialog(frame, "Cadastro\n\nInsira sua senha:");
		String tipoDeCliente = JOptionPane.showInputDialog(frame, "Cadastro\n\nTipo de cliente:");

		Cliente c = new Cliente(nome, cpf_cnpj, email, senha, tipoDeCliente);

		String res = cli_dao.cadastrarCliente(c);

		if (res.equals("")) {
			int resp = 0;
			try {
				resp = Integer.parseInt(JOptionPane.showInputDialog(frame,
						"Cliente cadastrado com sucesso!\n\tDigite 1 para cadastrar um vinho ou 2 para listar."));

				if (resp > 2 || resp < 1) {
					JOptionPane.showMessageDialog(null, "Voce deve digitar 1 ou 2");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Voce deve digitar um numero inteiro");
			} catch (ArithmeticException e) {
				JOptionPane.showMessageDialog(null, e);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			switch (resp) {
			case 1:
				cadastroDeVinhos(c.getCpf_cnpj());
				break;
			case 2:
				listarVinhos();
				break;
			}
		} else {
			JOptionPane.showMessageDialog(frame, res);
			return;
		}

	}

	private static void listarVinhos() {
		Frame frame = JOptionPane.getRootFrame();
		ArrayList<Vinho> vinho = vin_dao.listarVinhos();
		String aux = "";
		for (Vinho v : vinho) {
			aux += "Produto: " + v.getProduto() + "\nCasta: " + v.getCasta() + "\nSafra: " + v.getSafra() + "\nPontuacao: " + v.getPontuacao() + "\n\n";
		}

		JOptionPane.showMessageDialog(frame, "LISTAGEM DE VINHOS:\n\n" + aux);

	}

	private static void cadastroDeVinhos(String cpf_cnpj) {
		int safra = 0;
		double pontuacao = 0;
		Frame frame = JOptionPane.getRootFrame();
		String produto = JOptionPane.showInputDialog(frame, "Cadastro de vinhos\n\nProduto:");
		String casta = JOptionPane.showInputDialog(frame, "Cadastro de vinhos\n\nCasta (tipo de uva):");
		try {
			safra = Integer.parseInt(JOptionPane.showInputDialog(frame, "Cadastro de vinhos\n\nSafra (ano):"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Voce deve digitar um numero inteiro");
		} catch (ArithmeticException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		try {
			pontuacao = Double.parseDouble(JOptionPane.showInputDialog(frame, "Cadastro de vinhos\n\nPontuacao:"));

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Voce deve digitar um numero");
		} catch (ArithmeticException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

		Vinho v = new Vinho(vin_dao.contarVinhos(), cpf_cnpj, produto, casta, safra, pontuacao);

		String res = vin_dao.inserir(v);

		if (res.equals("")) {
			int resp = 0;
			try {
				resp = Integer.parseInt(JOptionPane.showInputDialog(frame,
						"Vinho cadastrado com sucesso!\n\tDigite 1 para voltar para a tela de login ou 2 para listar os vinhos."));

				if (resp > 2 || resp < 1) {
					JOptionPane.showMessageDialog(null, "Voce deve digitar 1 ou 2");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Voce deve digitar um numero inteiro");
			} catch (ArithmeticException e) {
				JOptionPane.showMessageDialog(null, e);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			switch (resp) {
			case 1:
				telaLogin();
				break;
			case 2:
				listarVinhos();
				break;
			}
		} else {
			JOptionPane.showMessageDialog(frame, res);
			return;
		}

	}

}
