package com.myOnlineStore.qa.testCases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;
import com.myOnlineStore.qa.pages.ClothesPage;
import com.myOnlineStore.qa.pages.ContactUsPage;

public class ClothesPageTest extends TestBase {
	ClothesPage clothesObj;

	@BeforeMethod
	public void setup() {
		initialization();
		clothesObj = PageFactory.initElements(driver, ClothesPage.class);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void validateClothesPage() throws InterruptedException {
		boolean clothesLinkDisp = clothesObj.clothesLink.isDisplayed();
		Assert.assertEquals(clothesLinkDisp, true);

		Actions ac = new Actions(driver);

		ac.moveToElement(clothesObj.menLink).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(clothesObj.menLink));

		Assert.assertTrue(clothesObj.menLink.isDisplayed(), "Men link is not displayed after hover");

		if (clothesObj.menLink.getText().contains("MEN")) {
			clothesObj.menLink.click();
			Assert.assertTrue(driver.getTitle().contains("Men"), "Not navigated to Men page");
		}

	}

}
