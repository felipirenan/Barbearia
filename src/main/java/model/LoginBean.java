package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginBean  {
	private int id;
	private String login; 
	private String senha;
	private int admin;
	
	public LoginBean() {
		
	}
	
	public LoginBean(String login, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		super();
		this.login = login;
		setSenha(senha);
	}
	
	


	public LoginBean(int id, String login, int admin) {
		super();
		this.id = id;
		this.login = login;
		this.admin = admin;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.senha = HashSenha(senha);
	} 
	
	public static  String HashSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		String senha_ = senha;
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
	     byte messageDigestsenha_[] = algorithm.digest(senha_.getBytes("UTF-8"));

	     StringBuilder hexStringsenha_ = new StringBuilder();
	     for (byte b : messageDigestsenha_) {
	              hexStringsenha_.append(String.format("%02X", 0xFF & b));
	     }
	     String senhahex = hexStringsenha_.toString();
		
	  return senhahex;
	}
	
	
	
	
	
}
