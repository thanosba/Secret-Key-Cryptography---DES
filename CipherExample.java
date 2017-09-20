import java.io.*;
import java.security.*;
import javax.crypto.*;
public class CipherExample
{	public static void main (String args[]) throws Exception
	{	
		BufferedReader stdin = new BufferedReader
(new InputStreamReader (System.in));
		System.out.print ("Cleartext: ");
		byte [] cleartext =stdin.readLine().getBytes("UTF8");
		
		KeyGenerator keyGen = KeyGenerator.getInstance
("DES");
		Key key = keyGen.generateKey ();
		
		Cipher cipher = Cipher.getInstance
("DES/ECB/PKCS5Padding");
		
		System.out.println ("\nEncryption...");
		cipher.init (Cipher.ENCRYPT_MODE, key);
		byte [] ciphertext = cipher.doFinal (cleartext);
		
		System.out.println ("Ciphertext: " + new String
(ciphertext, "UTF8"));
		
		System.out.println ("\nDecryption...");
		cipher.init (Cipher.DECRYPT_MODE, key);
		byte [] newcleartext = cipher.doFinal (ciphertext);
		
		System.out.println ("Cleartext: " + new String
(newcleartext, "UTF8"));
		
		System.out.println ("\nProvider Name: " +
cipher.getProvider().getName());
		System.out.println ("Provider Version: " +
cipher.getProvider().getVersion());
		System.out.println ("Provider Info: " +
cipher.getProvider().getInfo());
	}
} // CipherExample
