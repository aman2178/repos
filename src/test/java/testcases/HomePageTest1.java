package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.SignIn_Page;
import takescreenshotlistener.TakeScreenShot;
import utilities.Util;

@Listeners(TakeScreenShot.class)
public class HomePageTest extends Base{
	Util util;
	HomePage homepage;
	SignIn_Page signin_page;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		initialization();			
		util = new Util();
		homepage = new HomePage();
		signin_page = new SignIn_Page();
		util.ThreadSleep1();
	}
	
	@Test (priority=1)
	public void validateWalmartTitleAsExpected() {
		String Title = homepage.validateWalmartPageTitle();
		Assert.assertEquals(Title, "Online Shopping Canada: Everyday Low Prices at Walmart.ca!");
	}
	
	@Test (priority=2)
	public void validateWalmartUrlAsExpected() {
		String Url = homepage.validateWalmartUrl();
		Assert.assertEquals(Url, "https://www.walmart.ca/en");
	}
	
	@Test (priority=3)
	public void validateWalmartLogoDisplayed() throws InterruptedException {
		util.Highlight(driver, homepage.WalmartLogo());
		util.ThreadSleep2();
		boolean Logo = homepage.validateWalmartLogo();
		Assert.assertTrue(Logo);
	}
	
	@Test (priority=4)
	public void validateWalmartLogoLinkToHomePage() throws InterruptedException {
		util.Highlight(driver, homepage.WalmartLogoLink());
		util.ThreadSleep2();
		homepage.validateWalmartLogoLink();
		util.ThreadSleep1();
		String Url = homepage.validateWalmartUrl();
		Assert.assertEquals(Url, "https://www.walmart.ca/en");		
	}
	
	@Test (priority=5)
	public void validateSignInMyAccountTextDisplayed() throws InterruptedException {
		util.Highlight(driver, homepage.SignInMyAccountText());
		util.ThreadSleep2();
		boolean SignInMyAccountText = homepage.validateSignInMyAccountText();
		Assert.assertTrue(SignInMyAccountText);				
	}
	
	@Test (priority=6)
	public void validateWordSignInMyAccountTextAsExpected() throws InterruptedException {
		util.Highlight(driver, homepage.SignInMyAccountText());
		util.ThreadSleep2();
		String WordSignInMyAccountText = homepage.validateWordSignInMyAccountText();
		Assert.assertEquals(WordSignInMyAccountText, "Sign in" + "\n" + "My account");				
	}
	
	@Test (priority=7)
	public void validateSignInBtnDisplayed() throws InterruptedException {
		util.Highlight(driver, homepage.SignInMyAccountText());
		util.ThreadSleep2();
		homepage.mouseover();
		util.ThreadSleep2();
		util.Highlight(driver, homepage.SignInBtn());
		util.ThreadSleep2();		
		boolean SignInBtn = homepage.validateSignInBtn();
		Assert.assertTrue(SignInBtn);
	}
	
	@Test (priority=8)
	public void validateWordSignInDisplayedOnBtn() throws InterruptedException {
		util.Highlight(driver, homepage.SignInMyAccountText());
		util.ThreadSleep2();
		homepage.mouseover();
		util.ThreadSleep2();
		util.Highlight(driver, homepage.SignInBtn());
		util.ThreadSleep2();		
		String WordSignInOnBtn = homepage.validateWordSignInDisplayedOnBtn();
		Assert.assertEquals(WordSignInOnBtn, "Sign in");
	}
	
	@Test (priority=9)
	public void validateJoinNowBtnDisplayed() throws InterruptedException {
		util.Highlight(driver, homepage.SignInMyAccountText());
		util.ThreadSleep2();
		homepage.mouseover();
		util.ThreadSleep2();
		util.Highlight(driver, homepage.JoinNowBtn());
		util.ThreadSleep2();		
		boolean JoinNowBtn = homepage.validateJoinNowBtn();
		Assert.assertTrue(JoinNowBtn);
	}
	
	@Test (priority=10)
	public void validateWordJoinNowDisplayedOnBtn() throws InterruptedException {
		util.Highlight(driver, homepage.SignInMyAccountText());
		util.ThreadSleep2();
		homepage.mouseover();
		util.ThreadSleep2();
		util.Highlight(driver, homepage.JoinNowBtn());
		util.ThreadSleep2();		
		String WordJoinNowOnBtn = homepage.validateWordJoinNowDisplayedOnBtn();
		Assert.assertEquals(WordJoinNowOnBtn, "Join now");
	}
	
	@Test (priority=11)
	public void validateUserGoesToSignInPageBtn1() throws InterruptedException {
		util.Highlight(driver, homepage.SignInMyAccountText());
		util.ThreadSleep2();		
		signin_page = homepage.clickSignInMyAccountTextBtn(); //From HomePage_POM it activates SignIn_Page_POM to get @FindBy elements to use below test cases
	
		util.Highlight(driver, signin_page.SignInToYourAccountText());
		util.ThreadSleep2();
		boolean Text1 = signin_page.validateSignInToYourAccountText();
		Assert.assertTrue(Text1);
	}
	
	@Test (priority=12)
	public void validateUserGoesToSignInPageBtn2() throws InterruptedException {
		util.Highlight(driver, homepage.SignInMyAccountText());
		util.ThreadSleep2();
		homepage.mouseover();
		util.ThreadSleep2();
		util.Highlight(driver, homepage.SignInBtn());
		util.ThreadSleep2();
		signin_page = homepage.clickSignInBtn(); //From HomePage_POM it activates SignIn_Page_POM to get @FindBy elements to use below test cases
		
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
