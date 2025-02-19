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

public class TC_05_AddToWishlist extends BaseClass{
	
	private static final Logger log = LogManager.getLogger(TC_05_AddToWishlist.class); // Initialize Logger

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void testAddToWishlist() {
        log.debug("Starting test: testAddToWishlist");

        try {
            HomePage hp = new HomePage(getDriver());
            log.debug("Navigating through homepage options...");
            hp.notBoot_Option();
            hp.showAll_option();

            // Add item to Wishlist
            log.debug("Adding product to wishlist...");
            CatalogPage cp = new CatalogPage(getDriver());
            cp.addToWishList();

            // Validate success message
            log.debug("Verifying wishlist success message...");
            try {
                Assert.assertTrue(cp.isWishListSuccessMessageDisplayed(), "Wishlist success message not displayed!");
                log.info("Test Passed: Wishlist success message verified.");
            } catch (AssertionError e) {
                log.error("Assertion Failed: Wishlist success message not found!", e);
                throw e; // Rethrow for TestNG reporting
            }

        } catch (Exception e) {
            log.error("Test failed due to exception: ", e);
            throw e; // Rethrow for TestNG to capture failure
        }

        log.debug("Test testAddToWishlist completed.");
    }
}
