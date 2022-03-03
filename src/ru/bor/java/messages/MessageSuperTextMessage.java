package ru.bor.java.messages;

import java.io.ObjectOutputStream;

import ru.bor.java.window.WindowServer;
import ru.bor.java.work_files.WorkWithFiles;

public class MessageSuperTextMessage extends MessageSuper {

	public MessageSuperTextMessage(String idMessage, String nikUser, String textMessage) {
		super(idMessage, nikUser, textMessage);
		// TODO Auto-generated constructor stub
	}
	
	public void playMessage(ObjectOutputStream writer, WindowServer windowServer) {
		MessagesForLan message = new MessagesForLan(getIdMessage(), getNikUser(), getTextMessage());
		windowServer.getMessagesArea().append( "\n" + message.getTimeMessage() + " " +  message.getNikUser() + " " + message.getTextMessage());
		
		try {
			writer.writeObject(message);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		//��������� ��������� � chatServer
		//������� MessageForLan
		//�������� ���� ��������(!!!!���� ���������� ������ writer ����� ������)
	}
}
