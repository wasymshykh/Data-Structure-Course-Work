import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;

public class Block {

	public int index;
	public long timestamp;
	public String data;
	public String previousHash;
	public String hash;
	public int nonce;
	
	Block(int index, String data, String previousHash) {
		this.index = index;
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = new Timestamp(new Date().getTime()).getTime();
		this.nonce = 0;
		this.hash = calculateHash();
	}
	
	public String generateBlock(int difficulty) {
		
		String zeros = "";
		for(int i = 0; i < difficulty; i++) {
			zeros += "0";
		}
		
		while(!hash.substring(0, difficulty).equals(zeros)) {
			this.nonce++;
			this.hash = this.calculateHash();
		}
		
		return hash;
	}

	public String calculateHash() {
		
		String encodeString =  this.index + " " + this.timestamp + " " + this.data + " " + this.nonce + " " + this.previousHash; 
		
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(encodeString.getBytes(StandardCharsets.UTF_8));
			
			StringBuffer hexString = new StringBuffer();
		    for (int i = 0; i < encodedhash.length; i++) {
		    String hex = Integer.toHexString(0xff & encodedhash[i]);
		    if(hex.length() == 1) hexString.append('0');
		        hexString.append(hex);
		    }
		    return hexString.toString();
		    
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
