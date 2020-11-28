package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Base;

public class Util extends Base{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	
	public void ScreenShot() {
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Line is for WebDriver
		try {
			FileUtils.copyFile(screenshotfile, new File("S:\\Java\\Workspace\\Walmart\\screenshot\\" + screenshotfilename + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Add throw declaration
	}
	
	public void Highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: ; border: 3px solid red;');", element);
	}
	
	public void ThreadSleep1() throws InterruptedException {
		Thread.sleep(1200);
	}
	
	public void ThreadSleep2() throws InterruptedException {
		Thread.sleep(300);
	}
	
	
	
}
