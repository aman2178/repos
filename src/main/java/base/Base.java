package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Util;

public class Base{
	
	public static WebDriver driver;
	public static Properties configprop;
	

	public Base(){
		
		try {
			configprop = new Properties();
			FileInputStream ip = new FileInputStream("S:\\Java\\Workspace\\Walmart\\src\\main\\java\\EnvironmentVariable\\config.properties");
			configprop.load(ip);
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialization(){
		String browsername = configprop.getProperty("browser");
		
		if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "S:\\Java\\geckodriver-v0.25.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "S:\\Java\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		Dimension d = new Dimension(1500,1017);
		driver.manage().window().setSize(d);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(configprop.getProperty("url"));	
		
	}
	
}
