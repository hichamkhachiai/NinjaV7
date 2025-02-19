package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GiftPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC_06_GiftPurshase extends BaseClass {

	 private static final Logger log = LogManager.getLogger(TC_06_GiftPurshase.class); // Initialize Logger

	    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
	    public void testPurchaseAGiftCertificate() {
	        log.debug("Starting test: testPurchaseAGiftCertificate");

	        try {
	            HomePage hp = new HomePage(getDriver());
	            log.debug("Clicking on Gift Certificate option...");
	            hp.clickGiftCertificate();

	            GiftPage gcp = new GiftPage(getDriver());
	            log.debug("Entering recipient details...");
	            gcp.enterRecipientDetails("slima", "slima@gmail.com");

	            log.debug("Entering sender details...");
	            gcp.enterSenderDetails("hicham", "hichamkhachiai@gmail.com");

	            log.debug("Selecting gift theme...");
	            gcp.selectGiftTheme();

	            log.debug("Agreeing to terms and proceeding...");
	            gcp.agreeToTerms();
	            gcp.clickContinue();

	            // Validate confirmation message
	            log.debug("Verifying purchase success message...");
	            try {
	                Assert.assertTrue(gcp.isPurchaseSuccessMessageDisplayed(), "Gift Certificate purchase failed!");
	                log.info("Test Passed: Gift Certificate purchase success message verified.");
	            } catch (AssertionError e) {
	                log.error("Assertion Failed: Purchase success message not found!", e);
	                throw e; // Rethrow for TestNG reporting
	            }

	        } catch (Exception e) {
	            log.error("Test failed due to exception: ", e);
	            throw e; // Rethrow for TestNG to capture failure
	        }

	        log.debug("Test testPurchaseAGiftCertificate completed.");
	    }
}

