package screenshot;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.myOnlineStore.qa.base.TestBase;

import extentReporterPackage.ExtentReportManager;

public class ListnerClass extends TestBase implements ITestListener {

	private static ExtentReports extent = ExtentReportManager.getInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, "Test Failed");
		test.get().log(Status.FAIL, result.getThrowable());

		try {
			// Use the updated method from TestBase that returns screenshot path
			String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
			test.get().addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, "Test Skipped");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
