import java.io.IOException;
import java.util.Scanner;

public class menu {

	menu() throws IOException{
		boolean done = false;
		Scanner input = new Scanner(System.in);
		login();
		
		if(login.credStat) {
			while(!done) {
				char choice;
			    System.out.println("\n\nPROTOTYPE University Announcement System");
			    System.out.println("1. Announce");
			    System.out.println("2. Register Member");
			    System.out.println("3. Admin Options");
			    System.out.println("4. List");
			    System.out.println("5. Quit");
			    System.out.print("Enter option number: ");
			    choice = input.next().charAt(0);
			    
			    switch(choice) {
				    case '1': // Send announcements to teachers, students, both or non-members
				    	
				    	break;
				    case '2': // Register students and teachers
				    	 
				    	break;
				    case '3': // Change administrator settings
				    	
				    	break;
				    case '4': // Display history of sent announcements
				    	
				    	break;
				    case '5': // Display registered student/teacher list
				    	 
				    	break;
				    case '6': // Quit the program
				    	done = true;
				    	System.out.print("Quitting program...");
				    	break;
				    default:
				    	System.out.println("Invalid choice.");
			    }
			}
		}
	}

	public void login() throws IOException{
		login log = new login();
		
		log.comparator(log.getUsr(),log.getPass());
		
		if(login.credStat)
			System.out.println("Login success!");
		else
			System.out.println("Login fail!");
	}

}