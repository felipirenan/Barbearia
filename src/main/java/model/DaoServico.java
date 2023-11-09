package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoServico extends DAO {
	
	public void gravaServico(ServicoBean servico) {
		String sql = "insert into servicos(descricao,valor) values(?,?)";
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,servico.getDescricao());
			pst.setDouble(2, servico.getValor());
			
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public ArrayList<ServicoBean> listarServico() {
		ArrayList<ServicoBean> servicos = new ArrayList<>();
		String read = "select * from servicos";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String descricao = rs.getString(2);
				double valor = rs.getDouble(3);
			
				servicos.add(new ServicoBean(id, descricao, valor));
			}
			con.close();
			return servicos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	public void alterarServico(ServicoBean servicos) {
		String update = "update servicos set descricao=?,valor=? where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, servicos.getDescricao());
			pst.setDouble(2, servicos.getValor());
			pst.setInt(3, servicos.getId());
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteServico(ServicoBean servico) {
		String sql = "DELETE FROM servicos WHERE id = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, servico.getId());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void selecionarServico(ServicoBean servico) {
		String read2 = "select * from servicos where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, servico.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				servico.setId(rs.getInt(1));
				servico.setDescricao(rs.getString(2));
				servico.setValor(rs.getDouble(3));
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
