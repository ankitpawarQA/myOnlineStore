package com.myOnlineStore.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Credentials;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;
	protected String user;
	protected String pass;

	public static Logger logger;

	static {
		try {
			prop = new Properties();
			String path = System.getProperty("user.dir")
					+ "/src/main/java/com/myOnlineStore/qa/config/config.properties";
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		logger = LogManager.getLogger(TestBase.class);

		ExtentReports extent = new ExtentReports();

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("please enter a browser name in config file");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get(prop.getProperty("url"));
	}

	public static List<String> readExcelData() throws BiffException, IOException {
		List<String> credentialsList = new ArrayList<>();

		FileInputStream f = new FileInputStream("C:\\Users\\Ankit\\Desktop\\AUTOMATION DOCS\\excel file\\p1.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet1");

		int rc = s.getRows();

		for (int i = 0; i < rc; i++) {
			String user = s.getCell(0, i).getContents();
			String pass = s.getCell(1, i).getContents();
			credentialsList.add(new String(user));
		}

		return credentialsList;
	}

	public static String captureScreenshot(String methodName) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Create screenshots directory if not exists
		String screenshotsDir = System.getProperty("user.dir") + "/screenshots/";
		new File(screenshotsDir).mkdirs();

		String path = screenshotsDir + methodName + ".png";
		FileUtils.copyFile(srcFile, new File(path));
		return path;
	}
}
