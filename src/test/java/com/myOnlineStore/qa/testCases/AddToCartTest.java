package com.myOnlineStore.qa.testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;
import com.myOnlineStore.qa.pages.AddItemToCart;
import com.myOnlineStore.qa.pages.ClothesPage;

public class AddToCartTest extends TestBase {

	AddItemToCart addItemToCartObj;

	@BeforeMethod
	public void setup() {
		initialization();
		addItemToCartObj = PageFactory.initElements(driver, AddItemToCart.class);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 7)
	public void addItemToCartScenario() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		List<WebElement> allItemElements = addItemToCartObj.getAllItems();

		for (WebElement item : allItemElements) {
			if (item.getText().contains("Adventure")) {
				item.click();
				break;
			}
		}
		String priceText = addItemToCartObj.priceOfItem.getText().replaceAll("[^0-9.]", "");
		Assert.assertEquals(priceText, "30.45");

		Select select = new Select(addItemToCartObj.dimensionDropdown);
		select.selectByValue("20");
		select.selectByValue("19");

		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(10));
		wb.until(ExpectedConditions.elementToBeClickable(addItemToCartObj.addToCartButton)).click();
		driver.switchTo().activeElement();

		String prodSuccessAddedMsg = wb.until(ExpectedConditions.visibilityOf(addItemToCartObj.addedToCartSuccessMsg))
				.getText().trim();

		Assert.assertEquals(prodSuccessAddedMsg.contains("Product successfully added to your shopping cart"), true);
		addItemToCartObj.proceedToCheckoutBtn.click();
		addItemToCartObj.proceedToCheckoutBtnFinal.click();

		String actualText = addItemToCartObj.personalInfoText.getText().replaceAll("\\s+", " ").trim().toLowerCase();
		Assert.assertTrue(actualText.contains("personal information"));

		// Personal information form fill
		addItemToCartObj.socialTitleMr.click();
		addItemToCartObj.firstNameInput.sendKeys("Tester QA");
		addItemToCartObj.lastNameInput.sendKeys("Lastname of Tester");
		addItemToCartObj.emailInput.sendKeys("abc@gmail.com");
		addItemToCartObj.iAgreeCheckbox.click();
		addItemToCartObj.CXPrivacyCheckbox.click();
		addItemToCartObj.continueBtn.click();

		// Address form fill
		// addItemToCartObj.AddressesPageAddressInput.sendKeys("alpha test address ");
		System.out.println("addItemToCartScenario: PASS");

	}

}
