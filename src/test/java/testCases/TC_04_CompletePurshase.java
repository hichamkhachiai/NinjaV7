package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.CatalogPage;
import pageObjects.ConfirmationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC_04_CompletePurshase extends BaseClass {

	
	 private static final Logger log = LogManager.getLogger(TC_04_CompletePurshase.class); // Initialize Logger

	    @Test(groups = {"smoke", "regression"}, retryAnalyzer = RetryAnalyzer.class)
	    public void testCompletePurchase() {
	        log.debug("Starting test: testCompletePurchase");

	        try {
	            HomePage hp = new HomePage(getDriver());
	            log.debug("Navigating through homepage options...");
	            hp.notBoot_Option();
	            hp.showAll_option();

	            // Select HP Laptop
	            log.debug("Selecting a product...");
	            ProductsPage pp = new ProductsPage(getDriver());
	            pp.selectProduct();

	            // Add to Cart
	            log.debug("Adding product to cart...");
	            CatalogPage addTo = new CatalogPage(getDriver());
	            addTo.date_input();
	            addTo.add_Cart_click();
	            addTo.total_cart_click();
	            addTo.checkout_click();

	            // Login
	            log.debug("Logging in...");
	            LoginPage lp = new LoginPage(getDriver());
	            lp.setEmail("hichamkhachiai@gmail.com");
	            lp.setPwd("hicham123");
	            lp.clickLogin();

	            // Validate order confirmation
	            log.debug("Verifying order confirmation...");
	            ConfirmationPage confp = new ConfirmationPage(getDriver());

	            try {
	                Assert.assertTrue(confp.verifyOrderConfirmation(), "Order was not placed successfully!");
	                log.info("Test Passed: Order confirmation verified.");
	            } catch (AssertionError e) {
	                log.error("Assertion Failed: Order confirmation not found!", e);
	                throw e; // Rethrow for TestNG reporting
	            }

	        } catch (Exception e) {
	            log.error("Test failed due to exception: ", e);
	            throw e; // Rethrow for TestNG to capture failure
	        }

	        log.debug("Test testCompletePurchase completed.");
	    }
}
