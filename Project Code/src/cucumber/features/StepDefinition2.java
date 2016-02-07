package cucumber.features;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition2 {
	
	WebDriver driver = null;
	
	@Given("^Navigate to Nordstrom website part-2$")
	public void Navigate_to_Nordstrom_website() throws Throwable {
		//Open the browser
		driver = new FirefoxDriver();
		//Go to Nordstorm Website
		driver.navigate().to("http://shop.nordstrom.com/");
		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	
	@When("^I click on Stores & Events link$")
	public void I_click_on_Stores_Events_link() throws Throwable {
		//Click on Stores and Events
		driver.findElement(By.linkText("Stores & Events")).click();
	}

	@Then("^Store & Events page should be displayed$")
	public void Store_Events_page_should_be_displayed() throws Throwable {
		//Check the title of the page
		assertTrue(driver.getTitle().contains("Nordstrom Stores: Locations, Hours & Events | Nordstrom"));
	}
	
	
	
	@When("^I Enter zip code in the search box$")
	public void I_Enter_zip_code_in_the_search_box() throws Throwable {
		//Enter the Zip code
		driver.findElement(By.id("store-search-input")).sendKeys("60018");
	}


	@When("^I click Search button$")
	public void I_click_Search_button() throws Throwable {
		//click on submit button
		driver.findElement(By.id("store-search-submit")).click();
		Actions actionitem1 = new Actions(driver);
		  //press page down key
	  
		 Thread.sleep(3000);
		  
		 actionitem1.sendKeys(Keys.PAGE_DOWN).perform();
	}

	@Then("^List of Stores should be displayed$")
	public void List_of_Stores_should_be_displayed() throws Throwable {
		//Check the List appears on the page
	    assertTrue(driver.getPageSource().contains("Nordstrom stores near "));
	    Thread.sleep(2000);
		driver.quit();
	}
	
	
}
