package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import _01_File_Recorder.FileRecorder;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public FileEncryptor(){
		int key = 4;
		String message = JOptionPane.showInputDialog("Secret message:");
		FileWriter fw;
		char[] cs = message.toCharArray();
		for(int i = 0; i<cs.length;i++) {
			int sec = (int)cs[i];
			sec+=key;
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
		
		JOptionPane.showMessageDialog(null,"Encrypted message saved to code.txt");
	}
	public static void main(String[] args){
		new FileEncryptor();
	}
}

//Copyright LOLOLOL