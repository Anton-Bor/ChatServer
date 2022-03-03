package ru.bor.java.network;

import java.net.*;

import ru.bor.java.messages.MessagesForLan;

import java.io.*;

public class SetupNetworkServer{
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket sock;
	private ServerSocket serverSock;

	public SetupNetworkServer(){
		try
		{
			serverSock = new ServerSocket( 4240 );		 
		}
		catch ( Exception ex )
		{
		  	ex.printStackTrace();
		}
		
	}
	
	public void setupNetwork(){
		try{
			sock = serverSock.accept();
			if( sock.isConnected()) {
				System.out.println("connect");
				reader = new ObjectInputStream(sock.getInputStream());
				writer = new ObjectOutputStream(sock.getOutputStream());
			}
		}
		catch( Exception ex ){
			ex.printStackTrace();
		}
	}

	public ObjectInputStream getReader() {
		return reader;
	}
	
	public ObjectOutputStream getWriter() {
		return writer;
	}

	public MessagesForLan listenFromClient() {
		MessagesForLan message = null;
		try {
			message = (MessagesForLan) reader.readObject();
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return message;
	}
	
	public void sendMessageToClient( MessagesForLan message){
		try {
		writer.writeObject(message);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		//writer.flush();
	}
	
	//void closeRaeder(){
	//try{
	//	reader.close();
	//}
	//catch(Exception ex){
	//	ex.printStackTrace();
	//}
	//}

}
