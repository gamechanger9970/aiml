import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.io.*;
public class AESCrypt{
public static void main(String args[]) throws
NoSuchAlgorithmException,NoSuchPaddingException,
InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
InvalidAlgorithmParameterException,IOException {

//KeyGeneration
KeyGenerator keygenerator=KeyGenerator.getInstance("AES");
SecretKey secretkey=keygenerator.generateKey();
String

secretKeyString=Base64.getEncoder().encodeToString(secretkey.getEncoded());
System.out.println("generated key: "+secretKeyString);
//Encryption of message
Cipher encryptionCipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
byte[] InitVectorBytes=keygenerator.generateKey().getEncoded();
IvParameterSpec parameterSpec=new IvParameterSpec(InitVectorBytes);
encryptionCipher.init(Cipher.ENCRYPT_MODE,secretkey,parameterSpec);
BufferedReader bfn=new BufferedReader(new

InputStreamReader(System.in));

System.out.println("Enter the String: ");
String str=bfn.readLine();
byte[] encryptedMessageBytes=encryptionCipher.doFinal(str.getBytes());
String

encryptedMessage=Base64.getEncoder().encodeToString(encryptedMessageBytes);
System.out.println("Encrypted Message: "+encryptedMessage);
//Decryption of message
Cipher decryptioncipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
decryptioncipher.init(Cipher.DECRYPT_MODE,secretkey,parameterSpec);
byte[]

decryptedMessageBytes=decryptioncipher.doFinal(encryptedMessageBytes);
String decryptedMessage=new String(decryptedMessageBytes);
System.out.println("Decrypted Message: "+decryptedMessage);
}}