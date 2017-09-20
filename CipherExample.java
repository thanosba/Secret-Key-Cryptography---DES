import java.io.*;
import java.security.*;
import javax.crypto.*;
public class CipherExample
{	public static void main (String args[]) throws Exception
	{	// ζήτα από το χρήστη ένα απλό κείμενο
		BufferedReader stdin = new BufferedReader
(new InputStreamReader (System.in));
		System.out.print ("Cleartext: ");
		byte [] cleartext =stdin.readLine().getBytes("UTF8");
		// δημιούργησε το μυστικό κλειδί (χρησιμοποίησε τον
		// αλγόριθμο DES)
		KeyGenerator keyGen = KeyGenerator.getInstance
("DES");
		Key key = keyGen.generateKey ();
		// δημιούργησε ένα αντικείμενο τύπου Cipher που να
		// χρησιμοποιεί τον αλγόριθμο DES
		Cipher cipher = Cipher.getInstance
("DES/ECB/PKCS5Padding");
		// κρυπτογράφησε το απλό μήνυμα
		System.out.println ("\nEncryption...");
		cipher.init (Cipher.ENCRYPT_MODE, key);
		byte [] ciphertext = cipher.doFinal (cleartext);
		// εμφάνισε το κρυπτογραφημένο μήνυμα στο χρήστη
		System.out.println ("Ciphertext: " + new String
(ciphertext, "UTF8"));
		// αποκρυπτογράφησε το κρυπτογραφημένο μήνυμα
		System.out.println ("\nDecryption...");
		cipher.init (Cipher.DECRYPT_MODE, key);
		byte [] newcleartext = cipher.doFinal (ciphertext);
		// εμφάνισε το απλό μήνυμα στο χρήστη
		System.out.println ("Cleartext: " + new String
(newcleartext, "UTF8"));
		// εμφάνισε στο χρήστη τις σχετικές πληροφορίες για
		// τον παροχέα του αντικειμένου τύπου Cipher
		System.out.println ("\nProvider Name: " +
cipher.getProvider().getName());
		System.out.println ("Provider Version: " +
cipher.getProvider().getVersion());
		System.out.println ("Provider Info: " +
cipher.getProvider().getInfo());
	}
} // CipherExample
