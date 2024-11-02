package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public FileDecryptor() throws IOException{
		int key = 4;
		String message=null;
		FileWriter fw;
		FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/code.txt");
		int n = 0;
		StringBuilder sto = new StringBuilder();
		while(n!=-1) {
			n=fr.read();
			sto.append((char)n);
		}
		n=0;
		message=sto.toString();
		System.out.println(message);
		char[] cs = message.toCharArray();
		for(int i = 0; i<cs.length;i++) {
			int sec = (int)cs[i];
			sec-=key;
			cs[i]=(char)sec;
		}
		message = new String(cs);
		System.out.println(message);
		try {
			fw = new FileWriter("src/_02_File_Encrypt_Decrypt/code.txt");
			fw.write(message);
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null,"Decrypted message saved to code.txt");
	}
	public static void main(String[] args) throws IOException{
		new FileDecryptor();
	}
}

//Copyright LOLOLOL