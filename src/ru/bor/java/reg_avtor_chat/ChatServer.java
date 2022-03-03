package ru.bor.java.reg_avtor_chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;

import ru.bor.java.messages.MessagesForLan;
import ru.bor.java.messages.DispatcherOfMessages;
import ru.bor.java.messages.MessageSuper;
import ru.bor.java.messages.MessageSuperLoginPassAvtor;
import ru.bor.java.messages.MessageSuperTextMessage;
import ru.bor.java.network.SetupNetworkServer;
import ru.bor.java.reg_avtor_chat.ChatServer.ButtonSend;
import ru.bor.java.reg_avtor_chat.ChatServer.ForNet;
import ru.bor.java.reg_avtor_chat.ChatServer.ForWindow;
import ru.bor.java.reg_avtor_chat.ChatServer.ListenFromClient;
import ru.bor.java.reg_avtor_chat.ChatServer.SendToClient;
import ru.bor.java.window.WindowServer;
public class ChatServer{

	WindowServer windowServer = new WindowServer();
	SetupNetworkServer sNR = new SetupNetworkServer();
	MessagesForLan inputText = null;
	ArrayList<SetupNetworkServer> allClients = new ArrayList<SetupNetworkServer>();

	public void startServer(){
		Thread forWindow = new Thread (new ForWindow());
		Thread forNet = new Thread(new ForNet());
		forWindow.start();
		forNet.start();
		System.out.println("Old version");
	}

	public class ForWindow implements Runnable {
		@Override
		public void run() {
			windowServer.createWindow();
			windowServer.getButtonSend().addActionListener(new ButtonSend());
		}
	}

	public class ForNet implements Runnable {
		@Override
		public void run() {
			sNR.setupNetwork();
			//Thread addClient = new Thread(new AddClient());
			Thread listenFromClient = new Thread(new ListenFromClient());
			Thread sendToClient = new Thread(new SendToClient());
			//addClient.start();
			listenFromClient.start();
			sendToClient.start();
		}
	}

	public class ButtonSend implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MessageSuperTextMessage messageFromAdmin = new MessageSuperTextMessage("@003TextMessage", "Admin", windowServer.getMessageText());
			messageFromAdmin.playMessage(sNR.getWriter(), windowServer);
			windowServer.getMessageField().setText("");
		}
	}

    /*public class AddClient implements Runnable {
        @Override
        public void run() {
            while (true) {
                sNR.setupNetwork();
            }
        }
    }*/
    
	public class SendToClient implements Runnable {
		@Override
		public void run() {
			//MessagesForLan message = 
		}
			
	}

	

	public class ListenFromClient implements Runnable {
        @Override
        public void run() {
            while (true) {
                    MessagesForLan message = sNR.listenFromClient();
                    message.printMessage();
                    DispatcherOfMessages dispatcher = new DispatcherOfMessages(message);
                    MessageSuper messageSuper = dispatcher.initMessage();
                    messageSuper.playMessage(sNR.getWriter(), windowServer);
            }
        }
    }
}