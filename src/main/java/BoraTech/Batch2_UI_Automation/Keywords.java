package BoraTech.Batch2_UI_Automation;

public class Keywords {
	public static void WaitFor(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
