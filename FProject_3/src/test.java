import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
		
		while(!login.credStat) {
			login();
			if(login.credStat) {
				menu menu = new menu();
			}
			
			else
				System.out.println("Invalid username or password.");
		}
		
	}

	public static void login() throws IOException{
		login log = new login();
		log.comparator(log.getUsr(),log.getPass());
		
		if(login.credStat)
			System.out.println("Login success!");
		else
			System.out.println("Login fail!");
	}
}
