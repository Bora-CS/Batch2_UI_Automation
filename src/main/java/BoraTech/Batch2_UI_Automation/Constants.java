package BoraTech.Batch2_UI_Automation;

public class Constants {
	public static final String CHROME_DRIVER_PATH_MAC = "src/test/resource/chromedriver";
	public static final String CHROME_DRIVER_PATH_WINDOWS = "src/test/resource/chromedriver.exe";
	public static final String PROJECT_PATH = System.getProperty("user.dir").replaceAll("\\\\", "/"); 
	public static final String APPLICATION_URL = "file:///" + PROJECT_PATH + "/src/test/resource/index.html";
}
