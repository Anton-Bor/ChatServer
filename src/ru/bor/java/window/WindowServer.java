package ru.bor.java.window;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class WindowServer extends WindowSuper{
	
	private JLabel chat = new JLabel("Chat:");
	private JLabel users = new JLabel("Users: ");
	private JTextArea messages = new JTextArea( 15 , 50 );
	private JTextArea nikUsers = new JTextArea( 15, 15 );
	private JLabel otvetMessage = new JLabel("The message selected for the response");
	private JTextField message = new JTextField(50);
	private JButton buttonSend = new JButton("Send");

	public void createWindow(){
		setNameWindow("Server");
		messages.setLineWrap(true);
		nikUsers.setLineWrap(true);
		createPanel(getFrame().getContentPane());
		super.createWindow();
	}
	
	public JTextArea getMessagesArea() {
		return messages;
	}

	public void createPanel( Container con ){
		con.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		con.setLayout( new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10,10,0,0);
		con.add( chat, constraints);

		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10,10,0,0);
		con.add( users, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0,10,10,10);
		con.add(messages, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0,10,10,10);
		con.add(nikUsers, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10,10,0,0);
		con.add( otvetMessage, constraints );

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10,10,0,0);
		con.add( message, constraints);
	
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.insets = new Insets(20,10,10,10);
		con.add( buttonSend, constraints );
	}

	public JButton getButtonSend() {
		return buttonSend;
	}
	
	public String getMessageText(){
		return message.getText();
	}
	
	public JTextField getMessageField() {
		return message;
	}
	
}