
public class FileMgr {
	private String fileDir = "C:\\Users\\Zef\\git\\UIPR-Announcement-System\\FProject_3\\";
	private String TNID = "TNID.data";
	private String SNID = "SNID.data";
	private String ADFile = "ADMIN.data";
	private String subs = "Subs.data";
	private String temp = "temp.data";
	private String history = "history.data";
	
	String getDir() {
		return fileDir;
	}
	
	void setDir(String fileDir) {
		this.fileDir = fileDir;
	}
	
	String getTNID(){
		return TNID;
	}
	
	String getSNID() {
		return SNID;
	}
	
	String getADFile() {
		return ADFile;
	}
	
	String getSubs() {
		return subs;
	}
	
	String getTemp() {
		return temp;
	}
	
	String getHistory() {
		return history;
	}
}