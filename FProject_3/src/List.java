import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class List {
	FileMgr cap = new FileMgr();
	String filename = cap.getDir()+cap.getTNID();
	String tempLine,splitLine[];
	char choice;
	Scanner input = new Scanner(System.in);
	boolean done = false;
	
	List() throws IOException{
		while(!done) {
			System.out.println("\n\n~~~~~~~MEMBERS LIST~~~~~~~\n");
			System.out.println("1. Teacher list \n2. Student list \n3. Subscriber list \n4. Quit");
			choice = input.next().charAt(0);
			
			switch(choice) {
			case '1':
				tList();
				break;
			case '2':
				sList();
				break;
			case '3':
				subList();
				break;
			case '4':
				done = true;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
	}
	
	void tList() throws IOException{
		FileReader reader = new FileReader(cap.getDir()+cap.getTNID());
		BufferedReader br = new BufferedReader(reader);
		
		System.out.println("\n               TEACHER LIST               ");
		System.out.println("        NAME         |         ID         ");
		System.out.println("==========================================");
		
		while((tempLine = br.readLine()) != null) {
			splitLine = tempLine.split(","); // Separate name from ID and assign to array
			System.out.printf("%-28s"+splitLine[1]+"\n",splitLine[0]);
		}
		System.out.println("==========================================");
		br.close();
		sysPause.pEnter();
	}
	
	void sList() throws IOException {
		FileReader reader = new FileReader(cap.getDir()+cap.getSNID());
		BufferedReader br = new BufferedReader(reader);
		
		System.out.println("\n               STUDENT LIST               ");
		System.out.println("        NAME         |         ID         ");
		System.out.println("==========================================");
		
		while((tempLine = br.readLine()) != null) {
			splitLine = tempLine.split(","); // Separate name from ID and assign to array
			System.out.printf("%-28s"+splitLine[1]+"\n",splitLine[0]);
		}
		System.out.println("==========================================");
		br.close();
		sysPause.pEnter();
	}
	
	void subList() throws IOException {
		FileReader reader = new FileReader(cap.getDir()+cap.getSubs());
		BufferedReader br = new BufferedReader(reader);
		
		System.out.println("\n            SUBSCRIBER LIST            ");
		System.out.println("==========================================");
		
		while((tempLine = br.readLine()) != null) {
			System.out.println(tempLine);
		}
		System.out.println("==========================================");
		br.close();
		sysPause.pEnter();
	}
}
