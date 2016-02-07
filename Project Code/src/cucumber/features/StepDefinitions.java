package cucumber.features;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	WebDriver driver = null;
	
	
	@Given("^Navigate to Nordstrom website$")
	public void Navigate_to_Nordstrom_website() throws Throwable {
		//Open the browser
		driver = new FirefoxDriver();
		//Go to Nordstorm site
		driver.navigate().to("http://shop.nordstrom.com/");
		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@When("^I click Your Account link$")
	public void I_click_Your_Account_link() throws Throwable {
		//Click on Your Account link
		driver.findElement(By.linkText("Your Account")).click(); 
	}
	
	@And("^I am directed to signup page$")
	public void I_should_be_directed_to_signup_page() throws Throwable {
		//Check the title of the page
	 	assertTrue(driver.getTitle().contains("Nordstrom: Designer Collections and Top Apparel, Shoe and Beauty Brands"));
	}
	
	
	@When("^I fill the signup form$")
	public void I_fill_the_signup_form() throws Throwable {
		//Add the details to create the account
		driver.findElement(By.id("ctl00_mainContentPlaceHolder_accountProfileForm_firstNameTextBox")).sendKeys("Nikunj");
		driver.findElement(By.id("ctl00_mainContentPlaceHolder_accountProfileForm_emailAddressTextBox")).sendKeys("nikunj40.ratnaparkhi@gmail.com");
		driver.findElement(By.id("ctl00_mainContentPlaceHolder_accountProfileForm_emailAddressConfirmTextBox")).sendKeys("nikunj40.ratnaparkhi@gmail.com");
		driver.findElement(By.id("ctl00_mainContentPlaceHolder_accountProfileForm_passwordTextBox")).sendKeys("Pass456Pass");
		driver.findElement(By.id("ctl00_mainContentPlaceHolder_accountProfileForm_passwordConfirmTextBox")).sendKeys("Pass456Pass");
		driver.findElement(By.id("ctl00_mainContentPlaceHolder_accountProfileForm_zipCodeTextBox")).sendKeys("61761");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='3']")).click();
		
		Thread.sleep(1000);
				
	}

	@When("^I click on Create an Account button$")
	public void I_click_on_Create_an_Account_button() throws Throwable {
		//Click on Create An Account button
		driver.findElement(By.xpath("//img[@alt='Create An Account']")).click();
	}

	@Then("^Account should get created and I should get LoggedOut$")
	public void Account_should_get_created() throws Throwable {
		//Now check the title of the page
		assertTrue(driver.getTitle().contains("Nordstrom: Designer Collections and Top Apparel, Shoe and Beauty Brands"));
		Thread.sleep(2000);
		//Click on sign-out 
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		//Exit the browser
		driver.quit();
	 	 
	}


}
