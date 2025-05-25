package com.myOnlineStore.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.myOnlineStore.qa.base.TestBase;

public class ForgotPasswordPageTest extends TestBase {

	@BeforeMethod
	public void setup() {
		initialization();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
