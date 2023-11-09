package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface ValidaSenha {
	
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
	
	
	public static boolean ComparaHash(String senhaAtual, String senhaNova) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		//String senhaNovaHash = HashSenha(senhaNova);
	
		if (senhaNova.equals(senhaAtual)) {
			return true;
		}else {
			return false;
		}
		
	}

}
