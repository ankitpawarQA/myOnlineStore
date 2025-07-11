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
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myOnlineStore.qa.base.TestBase;
import com.myOnlineStore.qa.pages.AddItemToCart;
import com.myOnlineStore.qa.pages.ClothesPage;

@Listeners(screenshot.ListnerClass.class)
public class AddToCartTest extends TestBase {

	AddItemToCart addItemToCartObj;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		initialization(browser);
		addItemToCartObj = PageFactory.initElements(driver, AddItemToCart.class);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 7)
	public void addItemToCartScenario() {

		logger.info("starting addItemToCartScenario TC");

		try {
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
			logger.info("price is verified..");

			Select select = new Select(addItemToCartObj.dimensionDropdown);
			select.selectByValue("20");
			select.selectByValue("19");
			logger.info("size is selected..");

			WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(10));
			wb.until(ExpectedConditions.elementToBeClickable(addItemToCartObj.addToCartButton)).click();
			driver.switchTo().activeElement();

			String prodSuccessAddedMsg = wb
					.until(ExpectedConditions.visibilityOf(addItemToCartObj.addedToCartSuccessMsg)).getText().trim();

			Assert.assertEquals(prodSuccessAddedMsg.contains("Product successfully added to your shopping cart"), true);
			logger.info("product successfully added..");
			addItemToCartObj.proceedToCheckoutBtn.click();
			addItemToCartObj.proceedToCheckoutBtnFinal.click();

			String actualText = addItemToCartObj.personalInfoText.getText().replaceAll("\\s+", " ").trim()
					.toLowerCase();
			Assert.assertTrue(actualText.contains("personal information"));

			// Personal information form fill
			addItemToCartObj.socialTitleMr.click();
			addItemToCartObj.firstNameInput.sendKeys("Tester QA");
			addItemToCartObj.lastNameInput.sendKeys("Lastname of Tester");
			addItemToCartObj.emailInput.sendKeys("abc@gmail.com");
			addItemToCartObj.iAgreeCheckbox.click();
			addItemToCartObj.CXPrivacyCheckbox.click();
			addItemToCartObj.continueBtn.click();
			logger.info("continue btn is clicked");
		} catch (Exception e) {
			logger.error("addItemToCartScenario TC FAIL");
			logger.debug("debug logs for TC addItemToCartScenario");
			Assert.fail();
		}

		// Address form fill
		// addItemToCartObj.AddressesPageAddressInput.sendKeys("alpha test address ");

		logger.info("ending addItemToCartScenario TC");
	}

}
