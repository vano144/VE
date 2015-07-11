package vectoreditor.main;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import vectoreditor.forms.*;
public class Program {
	public static void main(String[] args)
	{
		MainFrame  myWindow = new MainFrame();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		myWindow.setSize(screenSize.width, screenSize.height);
		
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setVisible(true);
	}

}
