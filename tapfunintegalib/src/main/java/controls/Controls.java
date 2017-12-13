package controls;

public class Controls {
	private static String language;
	private boolean isPortrait;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public boolean isPortrait() {
		return isPortrait;
	}
	public void setPortrait(boolean isPortrait) {
		this.isPortrait = isPortrait;
	}
	private Controls(){
		
	}
	public static Controls controls;
	public static Controls getInstance(){
		if(controls!=null)
			return controls;
		else
			return controls=new Controls();
	}
}
