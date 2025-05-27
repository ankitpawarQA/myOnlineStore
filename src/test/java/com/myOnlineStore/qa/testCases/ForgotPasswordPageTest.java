package com.myOnlineStore.qa.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;import com.myOnlineStore.qa.pages.ForgotPasswordPage;
import com.myOnlineStore.qa.pages.LoginPage;

public class ForgotPasswordPageTest extends TestBase {
	ForgotPasswordPage obj;
	LoginPage obj1;

	@BeforeMethod
	public void setup() {
		initialization();
		obj1=PageFactory.initElements(driver,LoginPage.class);	
		obj1.signInBtn.click();		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test	
	public void forgotPageTC2() {
		obj=PageFactory.initElements(driver, ForgotPasswordPage.class);
		boolean forgotPwdLinkDisp=obj.forgotPasswordLink.isDisplayed();
		Assert.assertEquals(forgotPwdLinkDisp, true);
		obj.forgotPasswordLink.click();
		obj.emailInputFieldOnForgotPassPage.sendKeys("akshu@gmail.com");
		obj.sendReSetLinkBtn.click();
	}
}
