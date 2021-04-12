package Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.HomePage;
import Utils.BaseClass;

public class TestCode extends BaseClass {

	WebDriver driver;
	
	
	@Test
	public void openPartnersPage() throws IOException, InterruptedException {
		driver=Intializedriver();
		HomePage home_page= new HomePage(driver);
		home_page.clickHamburgerNavigation();
		home_page.clickPartnersSubMenu();
		}

	@Test
	public void verifyPartnersNotNull() throws IOException, InterruptedException {
		HomePage home_page= new HomePage(driver);
		home_page.getPartnersDetails();
		
		}
	
}