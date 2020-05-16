// Grab student/teacher names from file and send mock notification.
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class notify {
	String tempLine,splitLine[];
	FileMgr cap = new FileMgr();
	notify(){
		
	}
	
	// Notify teachers only
	void tNotify() throws IOException{
		System.out.println("\nSending mock notification to Teachers...");
		FileReader reader = new FileReader(cap.getDir()+cap.getTNID());
		BufferedReader br = new BufferedReader(reader);
		
		while((tempLine = br.readLine()) != null) {
			splitLine = tempLine.split(",");
			System.out.println("Sending to "+splitLine[0]);
		}
		System.out.println("Done!");
		br.close();
	}
	
	// Notify students only
	void sNotify() throws IOException{
		System.out.println("\nSending mock notification to Students...");
		FileReader reader = new FileReader(cap.getDir()+cap.getSNID());
		BufferedReader br = new BufferedReader(reader);
		
		while((tempLine = br.readLine()) != null) {
			splitLine = tempLine.split(",");
			System.out.println("Sending to "+splitLine[0]);
		}
		System.out.println("Done!");
		br.close();
	}
	
	void subNotify() throws IOException{
		System.out.println("\nSending mock notification to Subscribers...");
		FileReader reader = new FileReader(cap.getDir()+cap.getSubs());
		BufferedReader br = new BufferedReader(reader);
		
		while((tempLine = br.readLine()) != null) {
			System.out.println("Sending to "+tempLine);
		}
		System.out.println("Done!");
		br.close();
	}
}