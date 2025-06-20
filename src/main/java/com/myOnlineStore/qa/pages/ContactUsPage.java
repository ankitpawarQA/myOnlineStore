package com.myOnlineStore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myOnlineStore.qa.base.TestBase;

public class ContactUsPage extends TestBase{
	
	@FindBy(xpath = "//div[@id='contact-link']")
	public WebElement contactUsLink;
	
	@FindBy(xpath = "//select[@id='id_contact']")
	public WebElement subjectInputField;
	
	@FindBy(xpath = "//option[normalize-space()='Webmaster']")
	public WebElement subjectInputFieldDropDown1;
	
	@FindBy(xpath = "//option[normalize-space()='Customer service']")
	public WebElement subjectInputFieldDropDown2;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailInputField3;
	
	@FindBy(xpath = "//span[@class='buttonText']")
	public WebElement attachmentField;
	

	@FindBy(xpath="//span[@class='buttonText']")
	public WebElement chooseFileBtn;
	

	@FindBy(xpath = "//textarea[@id='contactform-message']")
	public WebElement messageInputFiled;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	public WebElement sendBtn;	
	

	@FindBy(xpath = "//span[normalize-space()='Home']")
	public WebElement HomeLink;	
	



	
	
	
	
	

	
	

}
