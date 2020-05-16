import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class List {
	FileMgr cap = new FileMgr();
	String filename = cap.getDir()+cap.getTNID();
	String tempLine,splitLine[];
	
	List() throws IOException{
		sList();
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
	}
}
