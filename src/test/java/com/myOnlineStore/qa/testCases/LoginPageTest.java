package com.myOnlineStore.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;
import com.myOnlineStore.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage obj;

	@BeforeMethod
	public void setup() {
		initialization();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void loginPageTC1() {
		obj = PageFactory.initElements(driver, LoginPage.class);
		boolean signBtnDispl = obj.signInBtn.isDisplayed();
		Assert.assertEquals(signBtnDispl, true);

	}

}
