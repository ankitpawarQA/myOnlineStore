package com.myOnlineStore.qa.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;
import com.myOnlineStore.qa.pages.ForgotPasswordPage;
import com.myOnlineStore.qa.pages.LoginPage;

public class ForgotPasswordPageTest extends TestBase {
	ForgotPasswordPage ForgotPasswordPageObj;
	LoginPage LoginPageObj;

	@BeforeMethod
	public void setup() {
		initialization();
		LoginPageObj = PageFactory.initElements(driver, LoginPage.class);
		ForgotPasswordPageObj = PageFactory.initElements(driver, ForgotPasswordPage.class);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void forgotPageTC2() {
		LoginPageObj.signInBtn.click();
		String signPageTitle = driver.getTitle();

		boolean forgotPwdLinkDisp = ForgotPasswordPageObj.forgotPasswordLink.isDisplayed();
		Assert.assertEquals(forgotPwdLinkDisp, true);

		ForgotPasswordPageObj.forgotPasswordLink.click();
		String forgetPassPageTitle = driver.getTitle();

		boolean emailInputFieldOnForgotPassPageDisp = ForgotPasswordPageObj.emailInputFieldOnForgotPassPage
				.isDisplayed();
		Assert.assertEquals(emailInputFieldOnForgotPassPageDisp, true);

		boolean sendReSetLinkBtnDisp = ForgotPasswordPageObj.sendReSetLinkBtn.isDisplayed();
		Assert.assertEquals(sendReSetLinkBtnDisp, true);

		Assert.assertEquals(ForgotPasswordPageObj.forgetPassText.getText(),
				"Please enter the email address you used to register. You will receive a temporary link to reset your password.");

		ForgotPasswordPageObj.backToLoginLink.click();
		Assert.assertEquals(driver.getTitle(), signPageTitle);

		LoginPageObj.signInBtn.click();
		ForgotPasswordPageObj.forgotPasswordLink.click();
		ForgotPasswordPageObj.emailInputFieldOnForgotPassPage.sendKeys("akshu@gmail.com");
		ForgotPasswordPageObj.sendReSetLinkBtn.click();
		System.out.println("forgotPageTC2: PASS");
	}
}
