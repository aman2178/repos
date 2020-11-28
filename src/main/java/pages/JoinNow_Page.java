package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class JoinNow_Page extends Base{

	//Page Repository Or Object Repository
	@FindBy(id = "walmartblue_Layer_1")
	WebElement WalmartLogo;	
	@FindBy(partialLinkText = "Sign in")
	WebElement SignInLink;
	@FindBy(partialLinkText = "My account")
	WebElement MyAccountLink;		
	@FindBy(xpath="//a[@href='/sign-in?from=%2Fen']")
	WebElement SignIn;
	@FindBy(xpath="//a[@href='/create-account']")
	WebElement JoinNow;
		
	
	//Initiate Page Repository/Object above to use
	public JoinNow_Page() {
	PageFactory.initElements(driver, this); //this means current class object and driver is coming from base class

	}
	
	//Methods or Actions	
	public String validateCreateAccountUrl() {
		return driver.getCurrentUrl();
	}
	
	
}
