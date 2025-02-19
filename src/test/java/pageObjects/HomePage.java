package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver); 
	}
	
	//Locators
	
	@FindBy(xpath="//a[normalize-space()='Qafox.com']")
	WebElement content_HomePage;
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement link_MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement link_Login;
	////////
	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement NotebooksCatalog;
	
	@FindBy(xpath = "//a[normalize-space()='Show AllLaptops & Notebooks']")
    WebElement showAll;
	
	@FindBy(xpath = "//a[normalize-space()='Gift Certificates']")
	private WebElement giftCertificate;
	
	public void clickMyAccount()
	{
		link_MyAccount.click();
	}
	
	public void goToLogin()
	{
		link_Login.click();
	}
	
	//Action Methods
	
	public String confirmHomepage()
	{
		return content_HomePage.getText();
	}
	//////
	public void notBoot_Option() {
		NotebooksCatalog.click();
	}
	///////
	public void showAll_option() {
		showAll.click();
	}
	
	public void clickGiftCertificate() {
		wait.until(ExpectedConditions.elementToBeClickable(giftCertificate)).click();
	}

	
}
