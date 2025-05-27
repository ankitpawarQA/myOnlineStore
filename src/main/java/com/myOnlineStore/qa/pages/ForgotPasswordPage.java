package com.myOnlineStore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage {

	@FindBy(xpath = "//a[@href='http://qanextgen.com/practice/liveprojects/p1myonlinestore/en/password-recovery']")
	public WebElement forgotPasswordLink;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailInputFieldOnForgotPassPage;

	@FindBy(xpath = "//button[@id='send-reset-link']")
	public WebElement sendReSetLinkBtn;

	@FindBy(css = ".send-renew-password-link")
	public WebElement forgetPassText;

	@FindBy(xpath = "//*[@id=\"back-to-login\"]/span")
	public WebElement backToLoginLink;

}
