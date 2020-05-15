import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;

public class login implements corrector{
	private String usrName;
	private String usrPass;
	private String temp;
	static boolean credStat;
	
	// File manip variables
	private FileReader reader;
	private File file;
	private FileMgr mgr;
	private BufferedReader br;
	
	login() throws IOException{
		Scanner input = new Scanner(System.in);
		mgr = new FileMgr();
		
		System.out.println("~~~~~~~~~~~ LOG-IN ~~~~~~~~~~~");
		System.out.print("Username: ");
		usrName = input.nextLine();
		System.out.print("Password: ");
		usrPass = input.nextLine();
	}

	// Check for user/pass validity
	public void comparator(String name, String number) throws IOException {
		mgr = new FileMgr();
		file = new File(mgr.getDir()+mgr.getADFile());
		reader = new FileReader(file);
		br = new BufferedReader(reader);
		temp = br.readLine();
		boolean usrOK = false,passOK = false;
		
		name = this.usrName;
		number = this.usrPass;
		
		if(name.equals(temp)) { // Confirm username
			System.out.println("User OK");
			usrOK = true;
		}
		
		temp = br.readLine(); // jump to next line

		if(number.equals(temp)) { // Confirm Password
			System.out.println("Pass OK");
			passOK = true;
		}
		
		if(usrOK && passOK) { // If user and pass match, proceed to menu
			credStat = true;
		}
	}

	// Unused
	public void correctionChk(String name, String number) {
		
	}
	
	String getUsr() {
		return usrName;
	}
	
	String getPass() {
		return usrPass;
	}
}
