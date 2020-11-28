package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class HomePage extends Base{

	//Page Repository Or Object Repository
	
		//HomePage
		@FindBy(xpath ="//*[@class='css-ywfyo0 enytrj80']")
		WebElement WalmartLogo;
		@FindBy(xpath ="//a[@href='/en']")
		WebElement WalmartLogoLink;		
		@FindBy(xpath="//a[@href='/sign-in?from=%2Fen']")
		WebElement SignInMyAccount;
		
		//Click Button
		@FindBy(xpath ="//*[@class='css-1i45fk4 edzik9p0']")
		WebElement SignInBtn;
		@FindBy(xpath="//a[@href='/create-account']")		
		WebElement JoinNowBtn;
		
		//After Sign In
		@FindBy(xpath="//span[@class='user-name']")
		WebElement Username;
			
		
		//Initiate Page Repository/Object above to use
		public HomePage() {
		PageFactory.initElements(driver, this); //this means current class object and driver is coming from base class

		}
		
		//Methods or Actions
		
		//HomePage
		public String validateWalmartPageTitle() {
			return driver.getTitle();
		}
		
		public String validateWalmartUrl() {
			return driver.getCurrentUrl();
		}
		
		public boolean validateWalmartLogo() {
			return WalmartLogo.isDisplayed();
		}			
		
		public boolean validateSignInMyAccountText() {
			return SignInMyAccount.isDisplayed();
		}
		
		public String validateWordSignInMyAccountText() {
			return SignInMyAccount.getText();
		}
		
		public void mouseover() {
			Actions action = new Actions(driver);
			action.moveToElement(SignInMyAccount).build().perform();			
		}
		
		public boolean validateSignInBtn() {
			return SignInBtn.isDisplayed();
		}
		
		public String validateWordSignInDisplayedOnBtn() {
			return SignInBtn.getText();
			
		}
				
		public boolean validateJoinNowBtn() {
			return JoinNowBtn.isDisplayed();
		}
		
		public String validateWordJoinNowDisplayedOnBtn() {
			return JoinNowBtn.getText();
			
		}
		
		
		
		//Click Button
		public void validateWalmartLogoLink() {
			WalmartLogoLink.click();
		}
		
		public SignIn_Page clickSignInMyAccountTextBtn() {
			SignInMyAccount.click();
			return new SignIn_Page();		
		}
		
		public SignIn_Page clickSignInBtn() {
			SignInBtn.click();
			return new SignIn_Page();
		}
		
		public JoinNow_Page clickJoinNowBtn() {
			JoinNowBtn.click();
			return new JoinNow_Page();
		}
		
		
		
	
		
		//After Sign In
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Highlight Elements
		public WebElement WalmartLogo() {
			WebElement Logo = WalmartLogo;
			return Logo;
		}
		
		public WebElement WalmartLogoLink() {
			WebElement LogoLink = WalmartLogoLink;
			return LogoLink;
		}
		
		public WebElement SignInMyAccountText() {
			WebElement SignInMyAccountText = SignInMyAccount;
			return SignInMyAccountText;
		}
		
		public WebElement SignInBtn() {
			WebElement SignInBtn1 = SignInBtn;
			return SignInBtn1;
		}
		
		public WebElement JoinNowBtn() {
			WebElement JoinNowBtn1 = JoinNowBtn;
			return JoinNowBtn1;
		}

}
