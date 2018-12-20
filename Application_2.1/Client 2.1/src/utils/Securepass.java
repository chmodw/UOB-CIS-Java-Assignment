package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * 
 * @author Chamodya Wimansha
 *
 */
public class Securepass {
	
	private byte[] password;
	private String hash;
	
	public Securepass(String password) {
		
		this.password = password.getBytes();
		
		encryptPass();
		
	}
	
	public String getHash() {
		return this.hash;
	}
	
	public boolean isSame(String hash) {
		
		if(this.hash.equals(hash)) {
			return true;
		}
		
		return false;
	}
	
	private void encryptPass() {
		
		MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("SHA");
	        md.reset();
	        md.update(password);
	        
	        byte[] encodedPassword = md.digest();
	        
	        StringBuilder sb = new StringBuilder();
	        
            for (int i = 0; i < encodedPassword.length; i++) {
                if ((encodedPassword[i] & 0xff) < 0x10) {
                    sb.append("0");
                }

                sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
            }
            
            this.hash = sb.toString();
	        
		} catch (NoSuchAlgorithmException e) {
			Helpers.Debug("Password Encryption Error - " + e.toString());
		}

	}
	
}









