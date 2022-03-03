package ru.bor.java.messages;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class MessagesForLan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idMessage;
	private String textMessage;
	private String nikUser;
	private String timeMessage;
	
	public MessagesForLan(String idMessage, String nikUser, String textMessage){
		this.idMessage=idMessage;
		this.nikUser=nikUser;
		this.textMessage=textMessage;
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
		setTimeMessage(dateFormat.format(calendar.getTime()));
	}

	
	
	public String getTextMessage() {
		return textMessage;
	}
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}
	
	public void createMessage(String idMessage, String nikUser,  String textMessage ) {
		setIdMessage(idMessage);
		setNikUser(nikUser);
		setTextMessage(textMessage);
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
		setTimeMessage(dateFormat.format(calendar.getTime()));
	}
	
	public void doMessage() {}
	public String getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}
	public String getNikUser() {
		return nikUser;
	}
	public void setNikUser(String nikUser) {
		this.nikUser = nikUser;
	}
	
	public void printMessage() {
		System.out.println( timeMessage + " " + idMessage + " " + nikUser + " " + textMessage);
	}
	public String getTimeMessage() {
		return timeMessage;
	}
	public void setTimeMessage(String timeMessage) {
		this.timeMessage = timeMessage;
	}
	
	
}
