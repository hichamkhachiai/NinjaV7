package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.CatalogPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import utilities.RetryAnalyzer;

public class TC_03_AddToCart extends BaseClass {
	
	private static final Logger log = LogManager.getLogger(TC_03_AddToCart.class); // Initialize Logger

    @Test(groups = {"smoke", "regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void testAddToCart() {
        log.debug("Starting test: testAddToCart");

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

            // Assertion with try-catch
            try {
                log.debug("Verifying success message...");
                Assert.assertTrue(addTo.verifySuccessMessage(), "Success message not displayed!");
                log.info("Test Passed: Success message verified.");
            } catch (AssertionError e) {
                log.error("Assertion Failed: Success message not found!", e);
                throw e; // Rethrow for TestNG reporting
            }

        } catch (Exception e) {
            log.error("Test failed due to exception: ", e);
            throw e; // Rethrow for TestNG to capture failure
        }

        log.debug("Test testAddToCart completed.");
    }
}
