package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoLogin extends DAO {
	

	public void gravaLogin(LoginBean usuarios) {
		String sql = "insert into usuarios(login, senha) values(?,?)";
		
		
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, usuarios.getLogin());
			pst.setString(2, usuarios.getSenha());
			
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public String acessar(LoginBean usuarios) {
		String sql = "select * from usuarios where login = ? ";
	
		try {
			Connection con = conectar();
			 PreparedStatement pst = con.prepareStatement(sql);
			 pst.setString(1, usuarios.getLogin());
			 ResultSet rs = pst.executeQuery();
			 
			 if(rs.next()) {
				 
				 return rs.getString(3);
			 }else {
				 return "0";
			 }
			 
			
		} catch (Exception e) {
		 System.out.println(e);
		 return "0";
		 
		}
	}
	
	public LoginBean retornaLogin(String user) {
		String read = "select * from usuarios where login = ?";
		LoginBean usuarios = null;
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			 pst.setString(1, user);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String login = rs.getString(2);
				int admin = rs.getInt(4);
				
				 usuarios = new LoginBean(id,login,admin);
				
			
			}
			
			con.close();
			System.out.println("ID Retorno" + usuarios.getId());
			return usuarios;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	


}
