package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogPage extends BasePage {
	
	public CatalogPage(WebDriver driver)
    {
        super(driver);
    }
	//@FindBy(xpath="//div[@class='caption']//a[contains(text(),'HP LP3065')]")
	//WebElement item_to_buy;
	
	@FindBy(xpath=" //input[@id='input-option225']")
	WebElement deliveryDateInput;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement add_btn;
	
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement cart_total_btn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;
	
	@FindBy(xpath="//strong[normalize-space()='Checkout']")
	WebElement checkout_btn;
	
	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa-heart']")
	private WebElement wishListButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	
	
	
	// method action
	
	/*
	 * public void item_click() { item_to_buy.click(); }
	 */
	
	
	public void date_input() 
	{
		deliveryDateInput.clear();
		LocalDate today = LocalDate.now();
		LocalDate deliveryDate = today.plusDays(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDeliveryDate = deliveryDate.format(formatter);
		deliveryDateInput.sendKeys(formattedDeliveryDate);
	}
	
	public void add_Cart_click()
	{
		add_btn.click();
	}
	
	public void total_cart_click()
	{
		cart_total_btn.click();
	}
	
	public void checkout_click()
	{
		checkout_btn.click();
	}
	
	public boolean verifySuccessMessage() {
		return successMessage.getText().contains("Success");
	}
	
	public void addToWishList() {
		wait.until(ExpectedConditions.elementToBeClickable(wishListButton)).click();
	}

	public boolean isWishListSuccessMessageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(successAlert)).isDisplayed();
	}

}
