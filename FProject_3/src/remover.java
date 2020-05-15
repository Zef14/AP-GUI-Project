import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;

public class remover extends register implements corrector{
	private Scanner input = new Scanner(System.in);
	private FileReader reader;
	private FileWriter writer;
	private File file;
	private BufferedReader br;
	private String name, number;
	private String temp;
	private FileMgr mgr = new FileMgr();
	
	remover(String name, String number) throws IOException{
		super();
		this.name = name;
		this.number = number;
	}
	
	public void RegForm(String name, String number) throws IOException{
		
		// Copy contents of file to temp file
		file = new File(mgr.getDir()+getFileName());
		reader = new FileReader(file);
		br = new BufferedReader(reader);
		writer = new FileWriter(mgr.getDir()+mgr.getTemp());// Temp file
		String temp; // Holds temporary line of data
		
    	while((temp = br.readLine()) != null) {
    		writer.write(temp+"\n");
    	} 
    	br.close(); 
    	reader.close();
    	writer.close();
    	
    	// Re-write contents of file excluding deleted line
    	reader = new FileReader(mgr.getDir()+mgr.getTemp());
    	br = new BufferedReader(reader);
    	writer = new FileWriter(mgr.getDir()+getFileName());
    	
    	while((temp = br.readLine()) != null) {
    		if(temp.equals(name+","+number))
    			continue;
    		writer.write(temp+"\n");
    	}
    	br.close(); 
    	reader.close();
    	writer.close();
	}
	
	public void RegForm(String name) throws IOException {
		// Copy contents of file to temp file
		file = new File(mgr.getDir()+getFileName());
		reader = new FileReader(file);
		br = new BufferedReader(reader);
		writer = new FileWriter(mgr.getDir()+mgr.getTemp());// Temp file
		String temp; // Holds temporary line of data
		
    	while((temp = br.readLine()) != null) {
    		writer.write(temp+"\n");
    	} 
    	br.close(); 
    	reader.close();
    	writer.close();
    	
    	// Re-write contents of file excluding deleted line
    	reader = new FileReader(mgr.getDir()+mgr.getTemp());
    	br = new BufferedReader(reader);
    	writer = new FileWriter(mgr.getDir()+getFileName());
    	
    	while((temp = br.readLine()) != null) {
    		if(temp.equals(name))
    			continue;
    		writer.write(temp+"\n");
    	}
    	br.close(); 
    	reader.close();
    	writer.close();
	}
	
	public void comparator(String name, String number) throws IOException {
		file = new File(mgr.getDir()+getFileName());
		reader = new FileReader(file);
		br = new BufferedReader(reader);
		temp = br.readLine();
		String[] splitLine;
		name = this.name;
		number = this.number;
		
		if(getChoice() == '1' || getChoice() == '2') { // Teachers/students
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
}
