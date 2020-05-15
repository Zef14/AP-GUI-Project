
public class FileMgr {
	private String fileDir = "C:\\Users\\Zef\\eclipse-workspace\\FProject_3\\";
	private String TNID = "TNID.data";
	private String SNID = "SNID.data";
	private String ADFile = "ADMIN.data";
	private String subs = "SUBS.data";
	private String adUser = "NULL";
	private String adPass = "NULL";
	private String temp = "temp.data";
	
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
	
	String getAd() {
		return adUser;
	}
	
	void setAd(String adUser) {
		this.adUser = adUser;
	}
	
	String getPass() {
		return adPass;
	}
	
	void setPass(String adPass) {
		this.adPass = adPass;
	}
	
	String getTemp() {
		return temp;
	}
}