package com.myOnlineStore.qa.testCases;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;
import com.myOnlineStore.qa.pages.CreateAnAccountPage;
import com.myOnlineStore.qa.pages.LoginPage;

public class CreateanAccountPageTest extends TestBase {

	CreateAnAccountPage createAccountObj;
	LoginPage loginPageObj;

	CreateAnAccountPage obj;
	LoginPage obj1;

	@BeforeMethod
	public void setup() {
		initialization();

		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
		loginPageObj.signInBtn.click();
		createAccountObj = PageFactory.initElements(driver, CreateAnAccountPage.class);

		obj1 = PageFactory.initElements(driver, LoginPage.class);
		obj1.signInBtn.click();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void createAnAccPage() {
		boolean createHereLinkDisp = createAccountObj.createHereLink.isDisplayed();
		Assert.assertEquals(createHereLinkDisp, true);
		createAccountObj.createHereLink.click();

		createAccountObj.socailTitleMrBtn.click();
		// createAccountObj.socailTitleMrsBtn.click();

		createAccountObj.firstNameInputField.sendKeys("akshu");
		createAccountObj.lastNameInputField.sendKeys("kalia");
		createAccountObj.emailInputField1.sendKeys("ankit@gmail.com");
		createAccountObj.passwordInputField1.sendKeys("java123");
		createAccountObj.birthdateInputFiled.sendKeys("23 may");

		boolean checkBoxReceiveOfferSelected = createAccountObj.checkBoxReceiveOffer.isSelected();
		if (!checkBoxReceiveOfferSelected) {
			createAccountObj.checkBoxReceiveOffer.click();
		}

		boolean checkBoxTermsandCondtionsSelected = createAccountObj.checkBoxTermsandCondtions.isSelected();
		if (!checkBoxTermsandCondtionsSelected) {
			createAccountObj.checkBoxTermsandCondtions.click();
		}

		boolean checkBoxSignupNewsSelected = createAccountObj.checkBoxSignupNews.isSelected();
		if (!checkBoxSignupNewsSelected) {
			createAccountObj.checkBoxSignupNews.click();
		}

		boolean checkBoxCustomerDataPrivacySelected = createAccountObj.checkBoxCustomerDataPrivacy.isSelected();
		if (!checkBoxCustomerDataPrivacySelected) {
			createAccountObj.checkBoxCustomerDataPrivacy.click();
		}
		createAccountObj.saveBtn.click();

		System.out.println("create login page test case is : pass");
	}
}
