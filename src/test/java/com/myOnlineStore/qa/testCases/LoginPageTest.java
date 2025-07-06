package com.myOnlineStore.qa.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;
import com.myOnlineStore.qa.pages.LoginPage;

import jxl.read.biff.BiffException;

@Listeners(screenshot.ListnerClass.class)
public class LoginPageTest extends TestBase {
	LoginPage obj;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		initialization(browser);
		obj = PageFactory.initElements(driver, LoginPage.class);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginPageInvalid() {

		logger.info("starting loginPageInvalid TC");

		try {
			boolean signBtnDispl = obj.signInBtn.isDisplayed();
			Assert.assertEquals(signBtnDispl, true);
			obj.signInBtn.click();
			logger.info("singin btn displayed and clicked");

			boolean emailInputFieldDisp = obj.emailInputField.isDisplayed();
			Assert.assertEquals(emailInputFieldDisp, true);
			obj.emailInputField.sendKeys("ankit@gmail.com");
			logger.info("email is entered");

			boolean passwordInputFieldDisp = obj.passwordInputField.isDisplayed();
			Assert.assertEquals(passwordInputFieldDisp, true);

			boolean showBtnDisp = obj.showBtn.isDisplayed();
			Assert.assertEquals(showBtnDisp, true);
			String showBtnText = obj.showBtn.getText();
			Assert.assertEquals(showBtnText, "SHOW");

			obj.passwordInputField.sendKeys("welcome@123");
			obj.showBtn.click();
			logger.info("password entered and clicked on show button..");
			String hideBtnText = obj.showBtn.getText();
			Assert.assertEquals(hideBtnText, "HIDE");

			boolean signInBtn1Disp = obj.signInBtn1.isDisplayed();
			Assert.assertEquals(signInBtn1Disp, true);
			obj.signInBtn1.click();
			Assert.assertEquals(obj.authErrorMsg.isDisplayed(), true);
		}

		catch (Exception e) {
			logger.error("loginPageInvalid TC FAIL");
			logger.debug("debug logs");
			Assert.fail();
		}
		logger.info("ending loginPageInvalid TC..");

	}

}
