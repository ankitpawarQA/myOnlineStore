package com.myOnlineStore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage {

	@FindBy(xpath = "//*[@id=\"email\"]")
	public WebElement emailInputFieldOnForgotPassPage;

}
