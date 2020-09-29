package principal;

import java.util.Random;

import javax.swing.JOptionPane;

import br.espm.bilhete.*;
import br.espm.tipo.TipoDeUsuario;
import br.espm.usuario.Usuario;

public class Main {

	private static BilheteUnico[] bilhetes = new BilheteUnico[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String entrada = "";

		while (entrada.compareToIgnoreCase("sair") != 0) {

			entrada = JOptionPane.showInputDialog("Senha ou CPF ou Sair");

			if (entrada.equalsIgnoreCase("admin")) {
				int operacao = Integer.parseInt(JOptionPane.showInputDialog(
						"Escolha uma operação:\n1. Emitir bilhete\n2. Imprimir bilhete\n3. Consultar bilhete\n4. Sair"));

				switch (operacao) {
				case 1:
					emitirBilhete();

					break;
				case 2:
					imprimirBilhete();

					break;
				case 3:
					consultarBilhete();

					break;

				default:
					break;
				}
			} else {
				boolean achei = false;
				int i = 0;
				while (bilhetes[i] != null) {
					if (entrada.equals(bilhetes[i].getUsuario().getCpf())) {
						
						achei = true;
						
						int operacao = Integer.parseInt(JOptionPane.showInputDialog(
								"Escolha uma operação:\n1. Carregar bilhete\n2. Passar na catraca\n3. Consultar saldo\n4. Sair"));
						
						switch (operacao) {
						case 1:
							double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja carregar: "));
							bilhetes[i].carregarBilhete(valor);
							JOptionPane.showMessageDialog(null, "Saldo antigo -> R$ " + (bilhetes[i].getSaldo() - valor) + "\nNovo saldo -> R$ " + bilhetes[i].getSaldo());

							break;
						case 2:
							bilhetes[i].passarNaCatraca();

							break;
						case 3:
							JOptionPane.showMessageDialog(null, "Seu saldo é de R$ " + bilhetes[i].getSaldo());

							break;

						default:
							break;
						}
					}
					i++;
				} 
				if(!achei && entrada.compareToIgnoreCase("sair") != 0) {
					JOptionPane.showMessageDialog(null, "CPF não encontrado!");
				}
			}
		}
	}

	public static void consultarBilhete() {
		String entrada = JOptionPane.showInputDialog("CPF para consulta: ");
		int i = 0;
		while (bilhetes[i] != null) {
			if (entrada.equals(bilhetes[i].getUsuario().getCpf())) {
				JOptionPane.showMessageDialog(null, bilhetes[i].getDados());
				return;
			}
			i++;
		}
		JOptionPane.showMessageDialog(null, "CPF não encontrado!");
	}

	public static void imprimirBilhete() {

		String aux = "Bilhetes cadastrados: \n\n";
		int i = 0;
		while (bilhetes[i] != null) {
			aux += bilhetes[i].getDados();
			i++;
		}

		JOptionPane.showMessageDialog(null, aux);
	}

	public static void emitirBilhete() {
		TipoDeUsuario tipoUsu = null;

		String cpf = JOptionPane.showInputDialog("CPF do novo usuário: ");

		int i = 0;
		while (bilhetes[i] != null) {
			if (cpf.equals(bilhetes[i].getUsuario().getCpf())) {
				JOptionPane.showMessageDialog(null, "O usuário já existe!");
				return;
			}
			i++;
		}

		String nome = JOptionPane.showInputDialog("Digite o nome do usuário: ");
		int tipo = Integer.parseInt(
				JOptionPane.showInputDialog("Digite o tipo de usuário:\n1. Normal\n2. Estudante\n3. Professor "));

		switch (tipo) {
		case 1:
			tipoUsu = TipoDeUsuario.Normal;
			break;
		case 2:
			tipoUsu = TipoDeUsuario.Estudante;
			break;
		case 3:
			tipoUsu = TipoDeUsuario.Professor;
			break;

		default:
			JOptionPane.showMessageDialog(null, "Tipo de usuário inválido");
			break;
		}

		Usuario novoUsuario = new Usuario(nome, cpf, tipoUsu);

		int qtdBilhetes = 0;
		while (bilhetes[qtdBilhetes] != null) {
			qtdBilhetes++;
		}

		Random gerador = new Random(qtdBilhetes);

		int numeroGerado = gerador.nextInt(8999) + 1000;

		bilhetes[qtdBilhetes] = new BilheteUnico(numeroGerado, novoUsuario, 0);

		JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

	}

}
