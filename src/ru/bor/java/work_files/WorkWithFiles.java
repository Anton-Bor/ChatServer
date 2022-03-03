package ru.bor.java.work_files;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import ru.bor.java.messages.MessagesForLan;

public class WorkWithFiles{
	private String nameFile;
	private ArrayList<MessagesForLan> allMessages;
	
	public WorkWithFiles(String nameFile) {
		setNameFile(nameFile);
		if (isFileNotEmpty()) {
			try {
				FileInputStream fIS = new FileInputStream(nameFile);
				ObjectInputStream reader = new ObjectInputStream(fIS);
				allMessages = (ArrayList<MessagesForLan>) reader.readObject();
				reader.close();
				fIS.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else {
			allMessages = new ArrayList<MessagesForLan>();
		}
	}
	
	void setNameFile( String nameFile ){
		this.nameFile = nameFile;
	}

	String getNameFile(){
		return nameFile;
	}
	
	public void addToFile( MessagesForLan message) {
		allMessages.add(message);
		try {
			FileOutputStream fOS = new FileOutputStream(nameFile);
			ObjectOutputStream writer = new ObjectOutputStream(fOS);
			writer.writeObject(allMessages);
			writer.close();
			fOS.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public ArrayList<MessagesForLan> getAllMessages() {
		return allMessages;
	}
	
	public boolean isFileNotEmpty () {
		boolean isNotEmpty = false;
		try {
			FileReader fR=new FileReader(nameFile);
			Scanner scan = new Scanner(fR);
			if (isNotEmpty = ( scan.hasNext()));
			scan.close();
			fR.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return isNotEmpty;
	}	
}
