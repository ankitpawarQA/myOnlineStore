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
		obj = PageFactory.initElements(driver, LoginPage.class);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginPageInvalid() {
		boolean signBtnDispl = obj.signInBtn.isDisplayed();
		Assert.assertEquals(signBtnDispl, true);
		obj.signInBtn.click();

		boolean emailInputFieldDisp = obj.emailInputField.isDisplayed();
		Assert.assertEquals(emailInputFieldDisp, true);
		obj.emailInputField.sendKeys("ankit@gmail.com");

		boolean passwordInputFieldDisp = obj.passwordInputField.isDisplayed();
		Assert.assertEquals(passwordInputFieldDisp, true);

		boolean showBtnDisp = obj.showBtn.isDisplayed();
		Assert.assertEquals(showBtnDisp, true);
		String showBtnText = obj.showBtn.getText();
		Assert.assertEquals(showBtnText, "SHOW");

		obj.passwordInputField.sendKeys("welcome@123");
		obj.showBtn.click();
		String hideBtnText = obj.showBtn.getText();
		Assert.assertEquals(hideBtnText, "HIDE");

		boolean signInBtn1Disp = obj.signInBtn1.isDisplayed();
		Assert.assertEquals(signInBtn1Disp, true);
		obj.signInBtn1.click();
		Assert.assertEquals(obj.authErrorMsg.isDisplayed(), true);
		System.out.println("loginPageInvalid :PASS");
	}

	@Test(priority = 2)
	public void loginPageValid() {
		obj.signInBtn.click();
		obj.emailInputField.sendKeys("ankit.pawar.ankit@gmail.com");
		obj.passwordInputField.sendKeys("pass@123");
		obj.signInBtn1.click();
		System.out.println("loginPageValid: PASS");
	}

}
