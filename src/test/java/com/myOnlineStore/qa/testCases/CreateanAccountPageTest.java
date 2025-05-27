package com.myOnlineStore.qa.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;
import com.myOnlineStore.qa.pages.CreateAnAccountPage;
import com.myOnlineStore.qa.pages.LoginPage;

public class CreateanAccountPageTest extends TestBase {

	CreateAnAccountPage obj;
	LoginPage obj1;

	@BeforeMethod
	public void setup() {
		initialization();
		obj1 = PageFactory.initElements(driver, LoginPage.class);
		obj1.signInBtn.click();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void createAnAccPage() {
		obj = PageFactory.initElements(driver, CreateAnAccountPage.class);
		obj1.noAccountCreateOneHereLink.click();
		obj.socailTitleMrBtn.click();
		obj.firstNameInputField.sendKeys("akshu");
		obj.lastNameInputField.sendKeys("kalia");
		obj.emailInputField1.sendKeys("ankit@gmail.com");
		obj.passwordInputField1.sendKeys("java123");
		obj.birthdateInputFiled.sendKeys("23 may");
		obj.checkBoxReceiveOffer.click();
		obj.checkBoxTermsandCondtions.click();
		obj.checkBoxSignupNews.click();
		obj.checkBoxCustomerDataPrivacy.click();
		obj.saveBtn.click();

	}
}
