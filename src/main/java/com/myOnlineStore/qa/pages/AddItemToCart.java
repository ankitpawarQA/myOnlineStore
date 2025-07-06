package com.myOnlineStore.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myOnlineStore.qa.base.TestBase;

public class AddItemToCart extends TestBase {

	@FindBy(className = "reviews-loaded")
	List<WebElement> allItems;

	public List<WebElement> getAllItems() {
		return allItems;
	}

	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[1]/div/span")
	public WebElement priceOfItem;

	@FindBy(id = "group_3")
	public WebElement dimensionDropdown;

	@FindBy(xpath = "//button[@data-button-action='add-to-cart']")
	public WebElement addToCartButton;

	@FindBy(xpath = "//h4[normalize-space(text())='Product successfully added to your shopping cart']")
	public WebElement addedToCartSuccessMsg;
	//// *[@id="myModalLabel"]/text()

	@FindBy(xpath = "//span[@class ='value' and text()='₹30.45']")
	public WebElement totalPrice;

	@FindBy(xpath = "//a[normalize-space(text())='Proceed to checkout']")
	public WebElement proceedToCheckoutBtn;

	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	public WebElement continueShoppingBtn;

	@FindBy(xpath = "//iframe[@allow=\"microphone\"]")
	public WebElement iframeAddr;

	@FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
	public WebElement proceedToCheckoutBtnFinal;

	@FindBy(xpath = "//*[@id=\"checkout-personal-information-step\"]/h1$") // bug here
	public WebElement personalInfoText;

	@FindBy(id = "field-id_gender-1")
	public WebElement socialTitleMr;

	@FindBy(id = "field-firstname")
	public WebElement firstNameInput;

	@FindBy(id = "field-lastname")
	public WebElement lastNameInput;

	@FindBy(id = "field-email")
	public WebElement emailInput;

	@FindBy(css = "button[name='continue']")
	public WebElement continueBtn;

	@FindBy(css = "input[name='psgdpr']")
	public WebElement iAgreeCheckbox;

	@FindBy(css = "input[name='customer_privacy']")
	public WebElement CXPrivacyCheckbox;

	@FindBy(xpath = "//*[@id=\"field-address1\"]")
	public WebElement AddressesPageAddressInput;
}
