package cryptography.com;

import java.util.Base64;

public class CeasarCipherImplementation {
	private static String alphabet="    ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String plaintText="rakesh kumar sonker";
		String cipherText=encrypt(plaintText,5801);
		System.out.println(cipherText);
		System.out.println(decrypt(cipherText, 5801));
		
	}
	public static String encrypt(String plainText, int key) {
		String cipherText="";
		plainText=plainText.toUpperCase();
		for(int i=0;i<plainText.length();i++) {
			char c=plainText.charAt(i);
			int charIndex=alphabet.indexOf(c);
			int ecryptedIndex=Math.floorMod(charIndex+key,alphabet.length());
			cipherText=cipherText+alphabet.charAt(ecryptedIndex);
		}
		String encodedCipherText=Base64.getEncoder().encodeToString(cipherText.getBytes());
		return encodedCipherText;
	}
	public static String decrypt(String cipherText,int key) {
		byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
         String decodedCipherText = new String(decodedBytes);
		decodedCipherText=decodedCipherText.toUpperCase();
		String plainText="";
		for(int i=0;i<decodedCipherText.length();i++) {
			char c=decodedCipherText.charAt(i);
			int charIndex=alphabet.indexOf(c);
			int decryptedIndex=Math.floorMod(charIndex-key,alphabet.length());
			plainText=plainText+alphabet.charAt(decryptedIndex);
		}
		return plainText;
	}

}
