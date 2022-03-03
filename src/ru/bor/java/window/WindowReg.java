package ru.bor.java.window;

import javax.swing.*;

import java.awt.*;

public class WindowReg extends WindowSuper{
	
	private JLabel repPassword = new JLabel("Repeat the password: ");
 	private JPasswordField repPasswordText = new JPasswordField(20);
 	private JButton buttonOk = new JButton("Ok");
 	private JLabel login = new JLabel("Login: ");
 	private JLabel password = new JLabel("Password: ");
 	private JTextField loginText = new JTextField(20);
 	private JPasswordField passwordText = new JPasswordField(20);


	public void createPanel( Container con ){
		
		con.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		con.setLayout( new GridBagLayout() );
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;

		constraints.gridx = 0;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(10,10,0,0);
		con.add( login, constraints );

		constraints.gridx = 1;
		constraints.insets = new Insets(10,0,0,10);
		con.add( loginText, constraints );

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(10,10,0,0);
		constraints.anchor = GridBagConstraints.EAST;
		con.add( password, constraints );
	
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.insets = new Insets(10,0,0,10);
		constraints.anchor = GridBagConstraints.EAST;
		con.add( passwordText, constraints );

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(10,10,0,0);
		constraints.anchor = GridBagConstraints.EAST;
		con.add( repPassword, constraints );

		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.insets = new Insets(10,0,0,10);
		constraints.anchor = GridBagConstraints.EAST;
		con.add( repPasswordText, constraints );

		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.insets = new Insets(10,0,10,0);
		constraints.ipadx = 5;
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.ipadx = 50;
		con.add( buttonOk, constraints );
	}

	public void createWindow(){
		createPanel(getFrame().getContentPane());	
		setNameWindow("Registration");
		super.createWindow();
	}

	public JButton getButtonOk(){
		return buttonOk;
	}

	public String getLoginText(){
		return loginText.getText();
	}
	
	public String getPasswordText(){
		String a =  new String(passwordText.getPassword());
		return a;
	}

	public String getRepPasswordText(){
		String a = new String(repPasswordText.getPassword());
		return a;
	}
}
