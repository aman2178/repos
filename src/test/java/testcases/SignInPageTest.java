package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.SignIn_Page;
import utilities.Util;

public class SignInPageTest extends Base {
	Util util;
	HomePage homepage;
	SignIn_Page signin_page;
	
	public SignInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		initialization();		
		util = new Util();		
		homepage = new HomePage();
		signin_page = new SignIn_Page();
		util.ThreadSleep1();
		
		util.Highlight(driver, homepage.SignInMyAccountText());
		util.ThreadSleep2();
		homepage.mouseover();
		util.Highlight(driver, homepage.SignInBtn());
		util.ThreadSleep2();
		signin_page = homepage.clickSignInBtn(); //From HomePage_POM it activates SignIn_Page_POM to get @FindBy elements to use below test cases
	}
	
	@Test (priority=1)
	public void validateWalmartLogoDisplayed() throws InterruptedException {
		util.Highlight(driver, signin_page.WalmartLogo());
		util.ThreadSleep2();
		boolean Logo = signin_page.validateWalmartLogo();
		Assert.assertTrue(Logo);
	}
	
	@Test (priority=2)
	public void validateWalmartUrlAsExpected() {
		
		String Url = homepage.validateWalmartUrl();
		Assert.assertEquals(Url, "https://www.walmart.ca/en");
	}
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
