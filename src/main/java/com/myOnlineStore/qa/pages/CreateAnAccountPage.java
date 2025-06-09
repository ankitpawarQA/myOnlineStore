package com.myOnlineStore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myOnlineStore.qa.base.TestBase;

public class CreateAnAccountPage extends TestBase {

	@FindBy(xpath="//div[@class='no-account']")
	public WebElement createHereLink;	

	@FindBy(xpath = "//input[@id='field-id_gender-1']")
	public WebElement socailTitleMrBtn;

	@FindBy(xpath = "//input[@id='field-id_gender-2']")
	public WebElement socailTitleMrsBtn;

	@FindBy(xpath = "//input[@id='field-firstname']")
	public WebElement firstNameInputField;

	@FindBy(xpath = "//input[@id='field-lastname']")
	public WebElement lastNameInputField;

	@FindBy(xpath = "//input[@id='field-email']")
	public WebElement emailInputField1;

	@FindBy(xpath = "//input[@id='field-password']")
	public WebElement passwordInputField1;

	@FindBy(xpath = "//button[@data-action='show-password']")
	public WebElement showBtn1;

	@FindBy(xpath = "//input[@id='field-birthday']")
	public WebElement birthdateInputFiled;

	@FindBy(xpath = "//input[@type='checkbox' and @name='optin']")
	public WebElement checkBoxReceiveOffer;

	@FindBy(xpath = "//input[@type='checkbox' and @name='psgdpr']")
	public WebElement checkBoxTermsandCondtions;

	@FindBy(xpath = "//input[@type='checkbox' and @name='newsletter']")
	public WebElement checkBoxSignupNews;

	@FindBy(xpath = "//input[@type='checkbox' and @name='customer_privacy']")
	public WebElement checkBoxCustomerDataPrivacy;

	@FindBy(xpath = "//button[@class='btn btn-primary form-control-submit float-xs-right']")
	public WebElement saveBtn;

}
