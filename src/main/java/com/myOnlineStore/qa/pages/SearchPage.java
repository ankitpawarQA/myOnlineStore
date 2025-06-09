package com.myOnlineStore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myOnlineStore.qa.base.TestBase;

public class SearchPage extends TestBase{
	@FindBy(xpath="//input[@class='ui-autocomplete-input']")
	public WebElement searchField;
	

}
