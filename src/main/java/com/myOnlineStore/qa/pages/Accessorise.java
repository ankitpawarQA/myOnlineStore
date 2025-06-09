package com.myOnlineStore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myOnlineStore.qa.base.TestBase;

public class Accessorise extends TestBase{
	
	@FindBy(xpath="//li[@id='category-6']/a")
	public WebElement accessoriseLink;
	
	@FindBy(xpath="//li[@id='category-7']/a")
	public WebElement stationeryLink;
	
	@FindBy(xpath="//li[@id='category-8']/a")
	public WebElement homeAccessoriseLink;
	

}
