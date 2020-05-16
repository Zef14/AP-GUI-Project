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
	private BufferedReader br;
	private FileMgr mgr = new FileMgr();
	String name,number,fileName;
	
	remover(String name, String number, String fileName) throws IOException{
		this.name = name;
		this.number = number;
		this.fileName = fileName;
	}
	
	remover(String name, String fileName) throws IOException{
		this.name = name;
		this.fileName = fileName;
	}
	
	public void RegForm(String name, String number) throws IOException{
		
		// Copy contents of file to temp file
		reader = new FileReader(mgr.getDir()+fileName);
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
    	writer = new FileWriter(mgr.getDir()+fileName);
    	
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
		reader = new FileReader(mgr.getDir()+fileName);
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
    	writer = new FileWriter(mgr.getDir()+fileName);
    	
    	while((temp = br.readLine()) != null) {
    		if(temp.equals(name))
    			continue;
    		writer.write(temp+"\n");
    	}
    	br.close(); 
    	reader.close();
    	writer.close();
	}
}
