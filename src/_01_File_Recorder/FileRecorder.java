package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	
	public FileRecorder(){
		String message = JOptionPane.showInputDialog("Secret message:");
		System.out.println("message = "+message);
		FileWriter fw;
		try {
			fw = new FileWriter("src/_01_File_Recorder/message2.txt");
			fw.write(message);
			fw.append("bran");
			
			fw.append('ඞ');fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null,"Message saved to message.txt");
	}
	public static void main(String[] args){
		new FileRecorder();
	}
}

//Copyright LOLOLOL