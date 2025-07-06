package screenshot;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.myOnlineStore.qa.base.TestBase;

public class ListnerClass extends TestBase implements ITestListener {

	public void onTestFailure(ITestResult result) {
		try {
			captureScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
