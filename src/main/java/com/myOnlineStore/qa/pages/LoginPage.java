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

	@FindBy(xpath = "//*[@id=\"login-form\"]/div/div[3]/a")
	public WebElement forgetPasswordLink;

	// all locators will be added here
}
