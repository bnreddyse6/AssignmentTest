package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class BaseClass {

public WebDriver driver;
	
	public WebDriver Intializedriver() throws IOException, InterruptedException
	{
		
	
		String path= BrowserData.getbrowserpath();
		System.setProperty("webdriver.chrome.driver", path);

	        driver = new ChromeDriver();
	        driver.navigate().to("https://www.achieve3000.com/");
	        
	        driver.manage().window().maximize();
	        String CurrentURL= driver.getCurrentUrl();
		    System.out.println("Current URL is : " + CurrentURL);
		    Thread.sleep(10000);
			
			
		return driver;
	}
	
	public static void scrollDown(WebDriver driver,String xpath){
		// TODO Auto-generated method stub
		//if pressX was zero it didn't work for me
		WebElement Element= driver.findElement(By.xpath(xpath));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", Element);
		}
	
	public static void seleniumSaveScreenshot(WebDriver driver, String fileName) {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File(BrowserData.getScreenshotsPath()+fileName+".png"));
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
			 }	}
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}
}
