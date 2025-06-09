package com.myOnlineStore.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myOnlineStore.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']/li[position() <= 4]")
	public List<WebElement> languageOption;

	

	
	

}
