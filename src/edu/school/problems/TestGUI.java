package edu.school.problems;

import javax.swing.JFrame;

public class TestGUI {

	public static void main(String[] args) {
		JFrame flame=new JFrame();
		File file1=new File("Parks.txt",20);
		File file2=new File("Gardents.txt",30);
		File file3=new File("Reservations.txt",70);
		File file4=new File("Parks.xlx",50);
		FileSystemObject[] files= {file1,file2,file3,file4};
		Folder folder=new Folder("Green files",files);
	
		
		
		flame.setBounds(0, 0, 800, 800);
		flame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		flame.setVisible(true);
		
	
		GUIView gui=new GUIView(folder);
        flame.add(gui);
	}

}
