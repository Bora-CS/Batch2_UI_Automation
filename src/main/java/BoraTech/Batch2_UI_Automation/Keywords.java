package BoraTech.Batch2_UI_Automation;

public class Keywords {
	
	public static void waitFor(int second){
		
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
