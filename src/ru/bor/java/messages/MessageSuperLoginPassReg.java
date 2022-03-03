package ru.bor.java.messages;

import java.io.ObjectOutputStream;

import ru.bor.java.window.WindowServer;
import ru.bor.java.work_files.WorkWithFiles;

public class MessageSuperLoginPassReg extends MessageSuper {

	public MessageSuperLoginPassReg(String idMessage, String nikUser, String textMessage) {
		super(idMessage, nikUser, textMessage);
		// TODO Auto-generated constructor stub
	}
	
	public void playMessage(ObjectOutputStream writer, WindowServer windowServer) {
		WorkWithFiles workWithFiles = new WorkWithFiles("User.sir");
		MessagesForLan message = new MessagesForLan(getIdMessage(), getNikUser(), getTextMessage());
		
		String[] loginPassInput = (message.getTextMessage()).split("///");
		boolean allGood = false;
		for(MessagesForLan allUsers:workWithFiles.getAllMessages()) {
			String[] login = allUsers.getTextMessage().split("///");
			if(allGood = ( login[0].equals(loginPassInput[0]))) {
				break;
			}
		}
		if(!allGood) {
			workWithFiles.addToFile(message);
			message.createMessage(getIdMessage(), getNikUser(), "Registration_is_good");
		}
		else {
			message.createMessage(getIdMessage(), getNikUser(), "With_this_login_is_registrated");
		}
		
		try {
			writer.writeObject(message);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
