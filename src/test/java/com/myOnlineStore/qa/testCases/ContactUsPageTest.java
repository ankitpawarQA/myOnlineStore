package com.myOnlineStore.qa.testCases;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;
import com.myOnlineStore.qa.pages.ContactUsPage;

public class ContactUsPageTest extends TestBase {
	ContactUsPage contactUsObj;

	@BeforeMethod
	public void setup() {
		initialization();
		contactUsObj = PageFactory.initElements(driver, ContactUsPage.class);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 4)
	public void contactUsPage() {
		boolean contactUsLinkDisp = contactUsObj.contactUsLink.isDisplayed();
		Assert.assertEquals(contactUsLinkDisp, true);
		contactUsObj.contactUsLink.click();

		boolean subjectInputFieldDisp = contactUsObj.subjectInputField.isDisplayed();
		Assert.assertEquals(subjectInputFieldDisp, true);

		Select selectSubject = new Select(contactUsObj.subjectInputField);
		selectSubject.selectByVisibleText("Webmaster");
		String selectOption = selectSubject.getFirstSelectedOption().getText();
		Assert.assertEquals(selectOption, "Webmaster");
		contactUsObj.subjectInputFieldDropDown1.click();

		boolean emailInputFieldDisp = contactUsObj.emailInputField3.isDisplayed();
		Assert.assertEquals(emailInputFieldDisp, true);
		contactUsObj.emailInputField3.sendKeys("Ankit@gmail.com");

		boolean attachmentFieldDisp = contactUsObj.attachmentField.isDisplayed();
		Assert.assertEquals(attachmentFieldDisp, true);

		boolean createFileBtnDisp = contactUsObj.chooseFileBtn.isDisplayed();
		Assert.assertEquals(createFileBtnDisp, true);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(contactUsObj.chooseFileBtn));

		boolean messageInputFiledDisp = contactUsObj.messageInputFiled.isDisplayed();
		Assert.assertEquals(messageInputFiledDisp, true);
		contactUsObj.messageInputFiled.sendKeys("ankit is a good qa");

		boolean sendBtnDisp = contactUsObj.sendBtn.isDisplayed();
		Assert.assertEquals(sendBtnDisp, true);
		contactUsObj.sendBtn.click();
		
		System.out.println("contactUsPage: PASS");

	}

}
