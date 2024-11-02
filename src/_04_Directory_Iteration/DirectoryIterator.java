package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] files = directory.listFiles();
			ArrayList<File[]> allFiles = new ArrayList<File[]>();
			if(files != null) {
				for(File f : files) {
					allFiles.add(f.listFiles());
				  System.out.println(f.getAbsolutePath());
				}
			}
			for(File[] ff:allFiles) {
				if(ff!=null) {
				for(File f:ff) {
					if(f.getAbsolutePath().endsWith(".java")) {
						try {
							FileWriter fw = new FileWriter(f.getPath(), true);
							fw.append("\n//Copyright LOLOLOL");
							fw.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			}
		}
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
	}
}

//Copyright LOLOLOL