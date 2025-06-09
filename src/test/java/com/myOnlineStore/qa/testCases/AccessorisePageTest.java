package com.myOnlineStore.qa.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;
import com.myOnlineStore.qa.pages.Accessorise;
import com.myOnlineStore.qa.pages.ClothesPage;

public class AccessorisePageTest extends TestBase {

	Accessorise accessoriseObj;

	@BeforeMethod
	public void setup() {
		initialization();
		accessoriseObj = PageFactory.initElements(driver, Accessorise.class);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void validateAccessorisePage() {
		boolean accessoriseLinkDisp = accessoriseObj.accessoriseLink.isDisplayed();
		Assert.assertEquals(accessoriseLinkDisp, true);

	}

}
