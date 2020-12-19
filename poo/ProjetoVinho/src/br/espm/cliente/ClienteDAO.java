package br.espm.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.espm.banco.Conexao;

public class ClienteDAO {

	private Connection connection;
	private PreparedStatement ps;
	private String sql;
	private ResultSet rs;

	public String cadastrarCliente(Cliente c) {
		sql = "INSERT INTO java_cliente (cpf_cnpj, nome, email, senha, tipoDeCliente) VALUES (?, ?, ?, ?, ?)";
		connection = new Conexao().conectar();
		String res = "";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, c.getCpf_cnpj());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getSenha());
			ps.setString(5, c.getTipoDeCliente());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro cadastrar usuário\n" + e);
			res = ("Erro cadastrar usuário\n" + e);
		}
		return res;
	}

	public ArrayList<Cliente> pesquisarCliente(String cpf_cnpj, String senha) {
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		sql = "SELECT cpf_cnpj, nome, email, senha, tipoDeCliente FROM java_cliente WHERE cpf_cnpj LIKE ? AND senha LIKE ?";
		connection = new Conexao().conectar();
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, cpf_cnpj);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Cliente(rs.getString("cpf_cnpj"), rs.getString("nome"), rs.getString("email"),
						rs.getString("senha"), rs.getString("tipoDeCliente")));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao logar\n" + e);
		}

		return lista;
	}

}
