package ru.bor.java.reg_avtor_chat;

import javax.swing.*;

import ru.bor.java.messages.MessagesForLan;
import ru.bor.java.window.WindowAvtor;
import ru.bor.java.window.WindowReg;
import ru.bor.java.work_files.WorkWithFiles;

import java.awt.event.*;

public class Authorization{
	private WindowReg windowReg;
	private WindowAvtor windowAvtor;
	private WorkWithFiles workWithFiles = new WorkWithFiles("Admin.sir");

	public Authorization(){
		if( workWithFiles.isFileNotEmpty() ) {
			doAuthorization();
		}
		else {
			doRegistration();
		}
	}
	
	public void doRegistration(){
			windowReg = new WindowReg(); 
			windowReg.createWindow();
			windowReg.getButtonOk().addActionListener(new ButtonOkListenerForRegistration());
	}

	class ButtonOkListenerForRegistration implements ActionListener{
		public void actionPerformed( ActionEvent e){
			if( windowReg.getLoginText().equals("") || windowReg.getPasswordText().equals("") ){
				getDialog( "All fields must be filled in!" );
			}
			else{
				if( !(windowReg.getPasswordText().equals(windowReg.getRepPasswordText())))
				{
					getDialog( "Passwords don't match!");
				}
				else
				{
					MessagesForLan mes = new MessagesForLan("@001Login/PassReg", "unknow", windowReg.getLoginText() + "///" + windowReg.getPasswordText());
					workWithFiles.addToFile(mes);
					windowReg.frame.dispose();
					windowReg = null;
					doAuthorization();
				}
			} 
		}
	}
	
	public void doAuthorization(){
			windowAvtor = new WindowAvtor();
			windowAvtor.createWindow();
			windowAvtor.getButtonOk().addActionListener(new ButtonOkListenerForAvtorisation());
		
	}
	
	class ButtonOkListenerForAvtorisation implements ActionListener{
		public void actionPerformed( ActionEvent e){
			if( windowAvtor.getLoginText().equals("") || windowAvtor.getPasswordText().equals("")){
				getDialog( "All fields must be filled in!");
			}
			else{
				for( MessagesForLan mes:workWithFiles.getAllMessages()) {
					String[] loginPass = mes.getTextMessage().split("///");
					if(loginPass[0].equals(windowAvtor.getLoginText()) && loginPass[1].equals( windowAvtor.getPasswordText())) {
						windowAvtor.frame.dispose();
						windowAvtor = null;
						ChatServer serv = new ChatServer();
						serv.startServer();
					}
					else {
						getDialog("Invalid login or password!");
					}
				}
			}
		}
	}

	

	public void getDialog(String a ){
		JFrame frameMessage = new JFrame();
		JOptionPane.showMessageDialog(frameMessage, a);
	}

}

