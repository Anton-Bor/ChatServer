package ru.bor.java.messages;

import java.io.ObjectOutputStream;

public class DispatcherOfMessages {
	private MessagesForLan message;
	private MessageSuper init;
	
	public DispatcherOfMessages(MessagesForLan message) {
		this.message=message;
	}
	
	
	public MessageSuper initMessage() {
		switch(message.getIdMessage()) {
			case("@001Login/PassAvtor"):
				init = new MessageSuperLoginPassAvtor(message.getIdMessage(), message.getNikUser(), message.getTextMessage());
				break;
			case("@002Login/PassReg"):
				init = new MessageSuperLoginPassReg(message.getIdMessage(), message.getNikUser(), message.getTextMessage());
				break;
			case("@003TextMessage"):
				init = new MessageSuperTextMessage(message.getIdMessage(), message.getNikUser(), message.getTextMessage());
				break;
		}
		return init; 
	}
	public void sendToClient(ObjectOutputStream writer) {
		try {
			writer.writeObject(getMessage());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private MessagesForLan getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
