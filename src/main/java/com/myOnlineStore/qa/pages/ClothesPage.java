package com.myOnlineStore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myOnlineStore.qa.base.TestBase;

public class ClothesPage extends TestBase{
	
	@FindBy(xpath="//a[@class='dropdown-item' and contains(@href,'clothes')]")
	public WebElement clothesLink;
	
	@FindBy(xpath="//li[@id='category-4']/a")
	public WebElement menLink;
	
	@FindBy(xpath="//li[@id='category-5']/a")
	public WebElement womenLink;
	

}
