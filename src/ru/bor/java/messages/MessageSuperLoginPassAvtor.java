package ru.bor.java.messages;


import java.io.ObjectOutputStream;

import ru.bor.java.window.WindowServer;
import ru.bor.java.work_files.WorkWithFiles;

public class MessageSuperLoginPassAvtor extends MessageSuper {

	public MessageSuperLoginPassAvtor(String idMessage, String nikUser, String textMessage) {
		super(idMessage, nikUser, textMessage);
		// TODO Auto-generated constructor stub
	}
	
	public void playMessage(ObjectOutputStream writer, WindowServer windowServer) {
		
		WorkWithFiles workWithFiles = new WorkWithFiles("User.sir");
		MessagesForLan message = new MessagesForLan(getIdMessage(), getNikUser(), getTextMessage());

		if(!getTextMessage().equals("User is loaded")){
			String[] loginPassInput = (message.getTextMessage()).split("///");
			boolean allGood = false;
			for(MessagesForLan allUsers:workWithFiles.getAllMessages()) {
				String[] loginPass = allUsers.getTextMessage().split("///");
					if(allGood = (( loginPass[0].equals(loginPassInput[0])) && ( loginPass[1].equals(loginPassInput[1])))) {
						break;
					}
			}
			if(allGood) {
				message.createMessage(getIdMessage(), getNikUser(), "Authorization_is_good");
			}
			else {
				message.createMessage(getIdMessage(), getNikUser(), "Invalid login or password!");
			}
			
			try {
				writer.writeObject(message);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else {
			windowServer.getMessagesArea().append(message.getTimeMessage() + " " + message.getNikUser() + " is append to chat!");
			MessagesForLan messageIsUserAppend = new MessagesForLan("@003TextMessage", getNikUser(), " is append to chat!");
			messageIsUserAppend.printMessage();
			
			try {
				writer.writeObject(messageIsUserAppend);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
	}
}
