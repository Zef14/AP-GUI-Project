import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;

public class History {
	private FileMgr mgr = new FileMgr();
	private FileWriter writer;
	private FileReader reader = new FileReader(mgr.getDir()+mgr.getHistory());
	private BufferedReader br = new BufferedReader(reader);
	private Scanner input = new Scanner(System.in);
	private String tempLine;
	private char choice;
	private int newLine = 0;
	private boolean done = false;
	
	History() throws IOException{
		while(!done) {
			System.out.println("~~~~~~~~~~~ANNOUNCEMENT LOG~~~~~~~~~~~");
			System.out.println("1. Show Announcement log\n2. Clear announcement log\n3. Quit");
			choice = input.next().charAt(0);
			
			switch(choice) {
			case '1':
				showHist();
				break;
			case '2':
				System.out.print("Clear history log? Y/N: ");
				choice = input.next().charAt(0);
				if(choice == 'y' || choice == 'Y') {
					clearHist();
				}
				break;
			case '3':
				done = true;
			}
		}
	}
	
	public void showHist() throws IOException {
		while((tempLine = br.readLine()) != null) {
			System.out.println(tempLine);
			newLine++;
			if(newLine == 2) {
				System.out.println();
				newLine = 0;
			}
		}
		System.out.println();
		sysPause.pEnter();
	}
	
	public void clearHist() throws IOException {
		writer = new FileWriter(mgr.getDir()+mgr.getHistory());
		writer.close();
		System.out.println("History log cleared.");
		sysPause.pEnter();
	}
}
