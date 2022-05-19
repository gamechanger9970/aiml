package descrypt; 
import java.util.*; 
import javax.crypto.*; 
import java.io.*; 
import java.security.InvalidKeyException; 
import java.security.NoSuchAlgorithmException; 
import java.security.spec.InvalidKeySpecException; 
public class descrypt { 
public static void main(String args[]) throws IOException, 
NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException { try { 
BufferedReader bfn=new BufferedReader(new 
InputStreamReader(System.in)); 
System.out.println("Enter the String: "); 
String str=bfn.readLine(); 
byte[] msg=str.getBytes(); 
KeyGenerator Mygenerator=KeyGenerator.getInstance("DES"); SecretKey mydeskey=Mygenerator.generateKey(); 
Cipher myCipher = Cipher.getInstance("DES"); 
myCipher.init(Cipher.ENCRYPT_MODE, mydeskey); 
byte[] myEncryptedBytes=myCipher.doFinal(msg); 
myCipher.init(Cipher.DECRYPT_MODE, mydeskey); 
byte[] myDecryptedBytes=myCipher.doFinal(myEncryptedBytes); 
String encrypteddata=new String(myEncryptedBytes); 
String decrypteddata=new String(myDecryptedBytes); 
System.out.println("Encrypted - "+ encrypteddata); 
System.out.println("Decrypted Message - "+ decrypteddata); } 
catch(Exception e) { 
System.out.println("Exception caught!!!"); 
} 
}}
