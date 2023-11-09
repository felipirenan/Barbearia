package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Daobarbeiro extends DAO {
	
	

	
	
	public void gravaBarbeiro(BarbeiroBean barbeiro) {
	String sql =  "insert into barbeiros(nome, telefone) values(?,?)";
	
	try {
		
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, barbeiro.getNome());
		pst.setString(2, barbeiro.getTelefone());
		
		pst.executeUpdate();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	}
	

	public void alterarBarbeiros(BarbeiroBean barbeiros) {
		String update = "update barbeiros set nome=?,telefone=? where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, barbeiros.getNome());
			pst.setString(2, barbeiros.getTelefone());
			pst.setInt(3, barbeiros.getId());
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public ArrayList<BarbeiroBean> listarBarbeiros() {
		ArrayList<BarbeiroBean> barbeiros = new ArrayList<>();
		String read = "select * from barbeiros";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
			
				barbeiros.add(new BarbeiroBean(id, nome, fone));
			}
			con.close();
			return barbeiros;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void selecionarBarbeiros(BarbeiroBean barbeiros) {
		String read2 = "select * from barbeiros where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, barbeiros.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				barbeiros.setId(rs.getInt(1));
				barbeiros.setNome(rs.getString(2));
				barbeiros.setTelefone(rs.getString(3));
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
