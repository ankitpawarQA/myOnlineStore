package com.myOnlineStore.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myOnlineStore.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//span[normalize-space()='Sign in']")
	public WebElement signInBtn;

	@FindBy(xpath = "//input[@id='field-email']")
	public WebElement emailInputField;

	@FindBy(xpath = "//input[@id='field-password']")
	public WebElement passwordInputField;

	@FindBy(xpath = "//button[@data-action='show-password']")
	public WebElement showBtn;

	@FindBy(xpath = "//a[contains(text(), ' No account? Create one here')]")
	public WebElement noAccountCreateOneHereLink;

	@FindBy(xpath = "//*[@id=\"login-form\"]/div/div[3]/a")
	public WebElement forgetPasswordLink;

	@FindBy(css = "button[id='submit-loginn']")
	public WebElement signInBtn1;

	@FindBy(xpath = "//li[@class='alert alert-danger']")
	public WebElement authErrorMsg;

}
