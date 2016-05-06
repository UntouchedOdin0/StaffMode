package staffmode.utils;

public class VersionHandler 
{	

	

	/**
	 * NOTE: Chaning This To True Will Not Change The Plugin In Any Way. 
	 */
	public VersionHandler() {

	}

	static VersionHandler instance = new VersionHandler();

	public static VersionHandler getInstance() {
		return instance;
	}
	public boolean version_pro = false;
	
	public boolean is_Pro() {
		return version_pro;
	}
	
}
