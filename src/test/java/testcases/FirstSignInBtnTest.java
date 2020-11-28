package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.SignIn_Page;
import utilities.Util;

public class FirstSignInBtnTest extends Base {
	Util util;
	HomePage homepage;
	SignIn_Page signin_page;

	
	public FirstSignInBtnTest() {
		super();
	}
	
	@BeforeMethod
	public void SetupSecondSignInBtn() throws InterruptedException {
		initialization();			
		util = new Util();		
		homepage = new HomePage();	
		signin_page = new SignIn_Page();
		util.ThreadSleep1();
				
		util.Highlight(driver, homepage.SignInMyAccountText());
		util.ThreadSleep2();		
		signin_page = homepage.clickSignInMyAccountTextBtn(); //From HomePage_POM it activates SignIn_Page_POM to get @FindBy elements to use below test cases
	}
	
	@Test (priority=1)
	public void validateUserGoesToSignInPage() throws InterruptedException {
		util.Highlight(driver, signin_page.SignInToYourAccountText());
		util.ThreadSleep2();
		boolean Text1 = signin_page.validateSignInToYourAccountText();
		Assert.assertTrue(Text1);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
