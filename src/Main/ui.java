package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ui extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
		new ui();
	}
	
	
	public ui() {
		buildWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton b = (JButton) event.getSource();
	}
	
	private void buildWindow() {
		setTitle("An average morning in my normal life");
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500); //Sets window's size
		setLocationRelativeTo(null); //Centers window
		setVisible(true); // Makes window visible
	}

}
