import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Announce extends notify{
	private Scanner input = new Scanner(System.in);
	private FileReader reader;
	private FileWriter writer;
	private BufferedReader br;
	private char choice;
	private FileMgr mgr;
	private String message;
	
	Announce() throws IOException{
		announce();
	}
	
	public void announce() throws IOException {
		System.out.println("\nANNOUNCEMENT OPTION");
		System.out.println("1. Notify Teachers");
		System.out.println("2. Notify Students");
		System.out.println("3. Notify Subscribers");
		System.out.println("4. Notify all");
		System.out.print("Enter option number: ");
		choice = input.next().charAt(0);
		
		switch(choice){
		case '1':
			System.out.println("Write mock announcement:");
			input.nextLine();
			message = input.nextLine();
			tNotify();
			addHistory();
			break;
		case '2':
			System.out.println("Write mock announcement:");
			input.nextLine();
			message = input.nextLine();
			sNotify();
			addHistory();
			break;
		case '3':
			System.out.println("Write mock announcement:");
			input.nextLine();
			message = input.nextLine();
			subNotify();
			addHistory();
			break;
		case '4':
			System.out.println("Write mock announcement:");
			input.nextLine();
			message = input.nextLine();
			tNotify();
			sNotify();
			subNotify();
			addHistory();
			break;
		default:
			System.out.println("Invalid choice");
		}
		sysPause.pEnter();
	}
	
	public void addHistory() throws IOException {
		
		// Copy file to temp
		mgr = new FileMgr();
		reader = new FileReader(mgr.getDir()+mgr.getHistory());
		br = new BufferedReader(reader);
		writer = new FileWriter(mgr.getDir()+mgr.getTemp());
		String tempLine;
		
		while((tempLine = br.readLine()) != null) {
			writer.write(tempLine+"\n");
		}
		br.close();
		reader.close();
		writer.close();
		
		// Re-write history file
		reader = new FileReader(mgr.getDir()+mgr.getTemp());
		br = new BufferedReader(reader);
		writer = new FileWriter(mgr.getDir()+mgr.getHistory());
		
		while((tempLine = br.readLine()) != null) {
			writer.write(tempLine+"\n");
		}
		
		// Add new log to file
		writer.write("MESSAGE: "+message+"\n");
		writer.write("Sent to ");
		switch(choice) {
		case'1':
			writer.write("Teachers\n");
			break;
		case '2':
			writer.write("Students\n");
			break;
		case '3':
			writer.write("Subscribers\n");
			break;
		case '4':
			writer.write("Everyone\n");
		}
		br.close();
		reader.close();
		writer.close();
	}
}
