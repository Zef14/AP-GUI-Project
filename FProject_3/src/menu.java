import java.io.IOException;
import java.util.Scanner;

public class menu {

	menu() throws IOException{
		boolean done = false;
		Scanner input = new Scanner(System.in);
		Announce ann;
		register reg;
		Options op;
		History hist;
		List list;
		
		while(!done) {
			char choice;
		    System.out.println("\n\nPROTOTYPE University Announcement System");
		    System.out.println("1. Announce");
		    System.out.println("2. Register Member");
		    System.out.println("3. Admin Options");
		    System.out.println("4. History");
		    System.out.println("5. List");
		    System.out.println("6. Quit");
		    System.out.print("Enter option number: ");
		    choice = input.next().charAt(0);
		    
		    switch(choice) {
			    case '1': // Send announcements to teachers, students, both or non-members
			    	ann = new Announce();
			    	break;
			    case '2': // Register students and teachers
			    	 reg = new register();
			    	break;
			    case '3': // Change administrator settings
			    	op = new Options();
			    	break;
			    case '4': // Display history of sent announcements
			    	hist = new History();
			    	break;
			    case '5': // Display registered student/teacher list
			    	list = new List();
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