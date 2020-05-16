import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class History {
	FileMgr mgr = new FileMgr();
	FileReader reader = new FileReader(mgr.getDir()+mgr.getHistory());
	BufferedReader br = new BufferedReader(reader);
	String tempLine;
	int newLine = 0;
	
	History() throws IOException{
		System.out.println("~~~~~~~~~~~ANNOUNCEMENT LOG~~~~~~~~~~~");
		
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
}
