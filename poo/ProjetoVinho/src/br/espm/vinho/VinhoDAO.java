package br.espm.vinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.espm.banco.Conexao;

public class VinhoDAO {
	private Connection connection; 
	private PreparedStatement ps; 
	private String sql; 
	private ResultSet rs; 

	public String inserir(Vinho v) {
		String res = "";
		sql = "INSERT INTO java_vinho (id, cpf_cnpj, produto, casta, safra, pontuacao) VALUES (?, ?, ?, ?, ?, ?)";
		connection = new Conexao().conectar();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, v.getId());
			ps.setString(2, v.getCpf_cnpj());
			ps.setString(3, v.getProduto());
			ps.setString(4, v.getCasta());
			ps.setInt(5, v.getSafra());
			ps.setDouble(6, v.getPontuacao());
			ps.execute(); 
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar vinho\n" + e);
			res = "Erro ao cadastrar vinho\n" + e;
		}
		return res;
	}
	
	public ArrayList<Vinho> listarVinhos() {
		ArrayList<Vinho> lista = new ArrayList<Vinho>();
		sql = "SELECT id, cpf_cnpj, produto, casta, safra, pontuacao FROM java_vinho ORDER BY pontuacao DESC";
		connection = new Conexao().conectar();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while (rs.next()) {
				lista.add(new Vinho(rs.getInt("id"), rs.getString("cpf_cnpj"), rs.getString("produto"), rs.getString("casta"),  rs.getInt("safra"), rs.getDouble("pontuacao")));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar vinhos\n" + e);
		}
 
		return lista;
	}
	
	public int contarVinhos() {
		int id = 0;
		sql = "SELECT COUNT(*) as id FROM java_vinho";
		connection = new Conexao().conectar();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while (rs.next()) {
				id += (rs.getInt("id"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao contar vinhos\n" + e);
		}
 
		return id + 1001;
	}

	
}
