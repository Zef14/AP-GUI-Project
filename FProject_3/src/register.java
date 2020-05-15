import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class register extends RegForm implements corrector{
	
	private Scanner input = new Scanner(System.in);
	private FileReader reader;
	private FileWriter writer;
	private File file;
	private BufferedReader br;
	
	private String temp;				 // Holds user/number for comparison purposes
	private String name,number;
	private FileMgr mgr = new FileMgr(); // Variable capsule object
	private String fileName;			 // Holds filename depending on chosen option
	private char choice;
	boolean usrExist = false,numExist = false; // Flags for existing user/number
	remover rem;
	boolean done = false;
	
	register() throws IOException{
		
		while(!done) {
			System.out.println("~~~~~~~~~~~~REGISTRATION~~~~~~~~~~~~");
			System.out.println("1. Register Teacher");
			System.out.println("2. Register Student");
			System.out.println("3. Register Subscriber");
			System.out.println("4. Remove Teacher");
			System.out.println("5. Remove Student");
			System.out.println("6. Remove Subscriber");
			System.out.println("7. Quit");
			choice = input.next().charAt(0);
			
			switch(choice) {
				case '1': // Teacher register
					fileName = mgr.getTNID();
					System.out.print("Enter name: ");
					name = input.nextLine();
					System.out.print("Enter ID number: ");
					number = input.nextLine();
					correctionChk(name, number);
					break;
				case '2': // Student register
					fileName = mgr.getSNID();
					System.out.print("Enter name: ");
					name = input.nextLine();
					System.out.print("Enter ID number: ");
					number = input.nextLine();
					correctionChk(name, number);
					break;
				case '3': // Subscriber register
					fileName = mgr.getSubs();
					System.out.print("Enter name: ");
					name = input.nextLine();
					correctionChk(name, "0");
					break;
				default:
					System.out.println("Invalid choice.");
			}
			
			if(choice == '1' || choice == '2')
				regForm(name,number);
			if(choice == '3')
				regForm(name);
			if(choice == '3' || choice == '4') {
				rem = new remover(name,number);
				rem.RegForm(name,number);
			}
				
			if(choice == '5')
				rem = new remover(name,number);
				rem.RegForm(name);
			if(choice == '6')
				done = true;
		}
	}
	
	public void regForm(String name, String number) throws IOException{ // Option for students/teachers
		comparator(name,number);
		if(numExist || usrExist) {
			System.out.println("The user or number already exists.");
		}
		
		else {
			file = new File(mgr.getDir()+fileName);
			writer = new FileWriter(file,true);
			
			writer.write(name+","+number+"\n"); // Append to end of file
			writer.close();
			System.out.println("Done!");
		}
	}
	
	public void regForm(String name) throws IOException { // Overload regForm for subscriber option
		comparator(name,"0"); // Number not applicable for Subscribers
		if(usrExist) {
			System.out.println("The user or number already exists.");
		}
		
		else {
			file = new File(mgr.getDir()+fileName);
			writer = new FileWriter(file,true);
			
			writer.write(name+"\n"); // Append to end of file
			writer.close();
			System.out.println("Done!");
		}
	}

	public void comparator(String name, String number) throws IOException {
		
		file = new File(mgr.getDir()+fileName);
		reader = new FileReader(file);
		br = new BufferedReader(reader);
		temp = br.readLine();
		String[] splitLine;
		name = this.name;
		number = this.number;
		
		if(choice == '1' || choice == '2') { // Teachers/students
			while((temp = br.readLine()) != null) {
				splitLine = temp.split(","); // Separate name from ID and assign to array
				temp = splitLine[0];		 // Assign user to temp
				if(name.equals(temp)) 		 // Confirm username
					usrExist = true;
				
				temp = splitLine[1]; 		 // assign number to temp

				if(number.equals(temp)) 	 // Confirm number
					numExist = true;
			}
		}
		else { 								 // Subscribers
			while((temp = br.readLine()) != null) {
				if(name.equals(temp)) 		 // Confirm username
					usrExist = true;
			}
		}	
	}

	public void correctionChk(String name, String number) {
		boolean invalid = false;
		
		invalid = name.matches("-?\\d+(\\.\\d+)?");
		
		if(invalid) {
			System.out.print("Invalid name input. Make sure to only use letters and spaces.");
		}
		
		invalid = number.matches("-?\\d+(\\.\\d+)?");
		
		if(!invalid) {
			System.out.println("Invalid number input. Only 8 numbers are permitted.");
		}
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public char getChoice() {
		return choice;
	}
}
