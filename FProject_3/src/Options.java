import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;

public class Options {
	private Scanner input = new Scanner(System.in);
	private char choice;
	private FileReader reader;
	private FileWriter writer;
	private BufferedReader br;
	private boolean done = false;
	private FileMgr mgr = new FileMgr();
	private String tempLine,newName;
	
	Options() throws IOException{
		while(!done) {
			System.out.println("~~~~~~~~ADMIN OPTIONS~~~~~~~~");
			System.out.println("1. Change admin username\n2. Change admin password\n3. Quit");
			choice = input.next().charAt(0);
			
			switch(choice) {
				case '1':
					reader = new FileReader(mgr.getDir()+mgr.getADFile());
					br = new BufferedReader(reader);
					tempLine = br.readLine(); // Grab username from file
					
					System.out.print("Type current Admin username: ");
					input.nextLine();
					newName = input.nextLine();
					
					if(newName.equals(tempLine)) {
						System.out.print("Type new Admin username: ");
						newName = input.nextLine();
						tempLine = br.readLine(); // Grab password
						
						br.close();
						reader.close();
						writer = new FileWriter(mgr.getDir()+mgr.getADFile());
						
						writer.write(newName+"\n"+tempLine); // Write new name and current password
						writer.close();
						System.out.println("Done!");
					}
					else
						System.out.println("Incorrect username.");
					sysPause.pEnter();
					break;
				case '2':
					reader = new FileReader(mgr.getDir()+mgr.getADFile());
					br = new BufferedReader(reader);
					br.readLine(); // Skip username in file
					tempLine = br.readLine(); // Grab password from file
					
					System.out.print("Type current Admin password: ");
					input.nextLine();
					newName = input.nextLine();
					
					if(newName.equals(tempLine)) {
						System.out.print("Type new Admin password: ");
						newName = input.nextLine();
						
						// Reset file
						br.close();
						reader.close();
						reader = new FileReader(mgr.getDir()+mgr.getADFile());
						br = new BufferedReader(reader);
						
						tempLine = br.readLine(); // Grab username
						
						br.close();
						reader.close();
						writer = new FileWriter(mgr.getDir()+mgr.getADFile());
						
						writer.write(tempLine+"\n"+newName); // Write current username and new password
						writer.close();
						System.out.println("Done!");
					}
					else
						System.out.println("Incorrect password.");
					sysPause.pEnter();
					break;
				case '3':
					done = true;
			}
		}
	}
}
