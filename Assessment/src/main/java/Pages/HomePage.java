package Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.expectThrows;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import junit.framework.Assert;

public class HomePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public String navigationBtn= "(//div[@class='nav-section']/button)[1]";
	public String partners="//a[contains(text(),'Partners')]";
	public String whoWeAreMenu= "//div[contains(text(),'Who We Are')]";
	
	public String partnerText="//div[@class='row h-100 ']/div/div/child::p";
	public String partnerLogo="//div[@class='row h-100 ']/div/child::a/img";
	public String partnerHeader="//div[@class='row h-100 ']/div/child::a/h3";
			
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}

	public void clickHamburgerNavigation() throws InterruptedException {
		wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(navigationBtn)));
		Thread.sleep(3000);
		try{
			driver.findElement(By.xpath(navigationBtn)).click();
			 System.out.println("Navigation Icon is clicked");

		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
	}
	
	public void clickPartnersSubMenu() throws InterruptedException {
		wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(whoWeAreMenu)));
		try{
			if(driver.findElement(By.xpath(partners)).isDisplayed()){
				 driver.findElement(By.xpath(partners)).click();
				 System.out.println("Partners Sub Menu is clicked");
				}
			}
		catch(NoSuchElementException e){
			e.printStackTrace();
			assertFalse(true);
		}
	    
		
	}
	

	public void getPartnersDetails(){		
		List<WebElement> partHeaders= driver.findElements(By.xpath(partnerHeader));
		List<WebElement> partText= driver.findElements(By.xpath(partnerText));
		List<WebElement> partLogo= driver.findElements(By.xpath(partnerLogo));

		for(int i=0;i<partHeaders.size();i++){
			String headerText=partHeaders.get(i).getText();
			String partnerDescriptionText= partText.get(i).getText();
			String partnerLogo=partLogo.get(i).getAttribute("alt");
			//System.out.println("Position "+(i+1)+"\nPartner Header text is:"+headerText +"\nPartner Description text is:"+partnerDescriptionText+"\nPartner Logo link is:"+partnerLogo);
			if(headerText==null||partnerDescriptionText==null||partnerLogo==null){
				assertFalse(true);
			}
		}
	}
}
