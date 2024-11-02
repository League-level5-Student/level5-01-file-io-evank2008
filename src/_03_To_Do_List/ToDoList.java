package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<JButton> blist = new ArrayList<JButton>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Task");
	JButton view = new JButton("View Tasks");
	JButton remove = new JButton("Remove Task");
	JButton save = new JButton("Save List");
	JButton load = new JButton("Load List");
	
	JFrame fram;
	JPanel pan;
	
	public ToDoList() {
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		load("src/_03_To_Do_List/data.txt");
	}
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	public static void main(String[] args) {
		new ToDoList();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object so = arg0.getSource();
		// TODO Auto-generated method stub
		if(so==add) {
			list.add(JOptionPane.showInputDialog("Enter task"));
		} else if(so==view) {
			if(list.size()==0) {
				JOptionPane.showMessageDialog(null,"All caught up!");
			} else {
			String msg = "To do:";
			
			for(String s:list) {
				msg+="\n-"+s;
			}
			JOptionPane.showMessageDialog(null,msg);
		}}
		else if(so==remove) {
			if(list.size()==0) {
				JOptionPane.showMessageDialog(null,"No tasks in list!");
				return;
			}
			fram = new JFrame("Remove a Task");
			pan = new JPanel();
			fram.add(pan);
			fram.setVisible(true);
			int i = 0;
			for(String s: list) {
				blist.add(new JButton(s));
				blist.get(i).addActionListener(this);
				pan.add(blist.get(i));
				i++;
			}
			fram.pack();
		}else if(so==save) {
			save();
		}else if(so==load) {
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				load(jfc.getSelectedFile().getAbsolutePath());
			}
			
		}else {
			for(int i = 0; i<blist.size();i++) {
				if(so==blist.get(i)) {
					blist.remove(i);
					list.remove(i);
					fram.dispose();
					return;
				}
			}
		}

	}
	void save() {
		boolean good = true;
		try {
			FileWriter fw = new FileWriter("src/_03_To_Do_List/data.txt");
			for(String s: list) {
				fw.append(s);
				fw.append("\n");
			}
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			good=false;
			e.printStackTrace();
		}
		if(good) {
JOptionPane.showMessageDialog(null, "Data saved successfully!");
		} else {
			JOptionPane.showMessageDialog(null, "error or smthn idk");
		}
	}
	void load(String path) {
		list=new ArrayList<String>();
		try {
			BufferedReader fr = new BufferedReader(new FileReader(path));
			try {
				boolean stop=false;
				while(!stop) {
					String s =fr.readLine();
					if(s==null) {
						stop=true;
					} else {
						list.add(s);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
JOptionPane.showMessageDialog(null, "File Loaded!");
	}
}

//Copyright LOLOLOL