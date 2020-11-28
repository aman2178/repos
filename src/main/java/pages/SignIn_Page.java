package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class SignIn_Page extends Base {

	//Page Repository Or Object Repository
	
		//Sign In
		@FindBy(xpath ="//*[@class='css-1si6i1z ezalzhu0']")
		WebElement WalmartLogo;
		@FindBy(xpath ="//a[@href='/en']")
		WebElement WalmartLogoLink;
		@FindBy(xpath ="//*[@class='css-17uo84k e17nj3uo1']")
		WebElement SignInToYourAccountText;
		
			
		
		//Initiate Page Repository/Object above to use
		public SignIn_Page() {
		PageFactory.initElements(driver, this); //this means current class object and driver is coming from base class
	
		}
		
		//Methods or Actions
		
		//Sign In
		public boolean validateWalmartLogo() {
			return WalmartLogo.isDisplayed();
		}
		
		public boolean validateSignInToYourAccountText() {
			return SignInToYourAccountText.isDisplayed();
		}
		
		public String validateWordSignInToYourAccountText() {
			return SignInToYourAccountText.getText();
		}
		
		
		
		//Click
		public HomePage validateWalmartLogoLink() {
			WalmartLogoLink.click();
			return new HomePage();
		}
		
		
		
		
		//Highlight
		public WebElement WalmartLogo() {
			WebElement Logo = WalmartLogo;
			return Logo;
		}
		
		public WebElement SignInToYourAccountText() {
			WebElement SignInToYourAccountText1 = SignInToYourAccountText;
			return SignInToYourAccountText1;
		}
}
