package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gameui extends JFrame implements ActionListener {
	
	public JTextArea textarea;
	private JPanel panel;
	private JLabel label;
	private JTextField textfield;
	private JButton button;
	
	
	public Gameui() {
		buildWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String s = textfield.getText();
		Game.processCommand(s);
	}
	
	private void buildWindow() {
		setTitle("An average morning in my normal ");
		setLayout(new BorderLayout()); //Sets Bordered layout
		
		textarea = new JTextArea();
		panel = new JPanel(new GridLayout(3,1));
		label = new JLabel("What would you like to do");
		textfield = new JTextField();
		button = new JButton("Commit");
		button.addActionListener(this);
		
		
		add(textarea, BorderLayout.CENTER);
		panel.add(label);
		panel.add(textfield);
		panel.add(button);
		add(panel, BorderLayout.SOUTH);
		
		
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500); //Sets window's size
		setLocationRelativeTo(null); //Centers window
		setVisible(true); // Makes window visible
	}

}
