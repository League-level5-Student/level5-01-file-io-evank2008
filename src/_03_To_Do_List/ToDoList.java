package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//fix line 97
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
			System.out.println("To do:");
			for(String s:list) {
				System.out.println("-"+s);
			}
		}else if(so==remove) {
			if(list.size()==0) {
				System.out.println("No tasks in list!");
				return;
			}
			JFrame fram = new JFrame("Remove a Task");
			JPanel pan = new JPanel();
			fram.add(pan);
			fram.setVisible(true);
			fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			int i = 0;
			for(String s: list) {
				blist.add(new JButton((i+1)+": "+s));
				blist.get(i).addActionListener(this);
				pan.add(blist.get(i));
				i++;
			}
			fram.pack();
		}else if(so==save) {
			
		}else if(so==load) {
			
		}else {
			//replace this with a for int i thingy or iterator
			for(JButton j:blist) {
				if(so==j) {
					blist.remove((int)j.getText().charAt(0)-(50));
				}
			}
		}

	}
}
