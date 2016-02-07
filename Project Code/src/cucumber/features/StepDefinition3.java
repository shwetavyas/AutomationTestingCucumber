package cucumber.features;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition3 {
	WebDriver driver = null;
	
	@Given("^Navigate to Nordstrom website part-3$")
	public void Navigate_to_Nordstrom_website() throws Throwable {
		//Open the browser
		driver = new FirefoxDriver();
		//Go to Nordstorm website
		driver.navigate().to("http://shop.nordstrom.com/");
		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^I click signin button")
	public void I_click_signin_button() throws Throwable {
		//click sign-in button
		Thread.sleep(2000);
	    driver.findElement(By.linkText("Sign In")).click();
	}

	@And("^I populate the fields")
	public void I_populate_the_fields() throws Throwable {
		//Enter username
	    driver.findElement(By.xpath("//input[@name='ctl00$mainContentPlaceHolder$signIn$email']")).sendKeys("selenium501@gmail.com");
	    //Enter password
	    driver.findElement(By.xpath("//input[@name='ctl00$mainContentPlaceHolder$signIn$password']")).sendKeys("selenium501");
	    Thread.sleep(2000);
	    //click sign-in button
	    driver.findElement(By.id("ctl00_mainContentPlaceHolder_signIn_enterButton")).click();
	    Thread.sleep(2000);
	}

	@Then("^I should be logged in to the website")
	public void I_should_be_logged_in_to_the_website() throws Throwable {
		//Check the title of the page
//		String expected = "Nordstrom: Designer Collections and Top Apparel, Shoe and Beauty Brands";
//		String actual = driver.getTitle();
//		assertEquals(expected, actual);
		assertTrue(driver.getTitle().contains("Nordstrom"));
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		driver.quit();
		
		//check whether you are signed-in
		//boolean actualpagesource = driver.getPageSource().contains("Hello, Selenium");
		//assertTrue(actualpagesource);
		
		
	}
	
	
	

	@When("^Search item on website")
	public void Search_item_on_website() throws Throwable {
		//Search the term makeup in the search field
		driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("makeup");
		//Enter search button
		driver.findElement(By.xpath("//button[@id='primary-search-submit']")).click();
		Thread.sleep(1000);
	}

	@And("^I filter the item")
	public void I_filter_the_item() throws Throwable {
		//Filter Eyes from makeup
		driver.findElement(By.xpath("//a[@name='Eyes']")).click();
		Thread.sleep(2000);
		//select item type
		driver.findElement(By.xpath("//div[@class='header']/span[contains(text(),'Item Type')]")).click();
		Thread.sleep(3000);
		//select makeup sets
		driver.findElement(By.xpath("//li[@id='option_filtercategory_8000797']")).click();
		Thread.sleep(2000);
		//filter the price
		driver.findElement(By.xpath("//div[@class='header']/span[contains(text(),'Price')]")).click();
		Thread.sleep(3000);
		//select the range $25-50
		driver.findElement(By.xpath("//li[@id='option_Price_25-50']")).click();
		Thread.sleep(2000);
		
	}

	@And("^I sort the item")
	public void I_sort_the_item() throws Throwable {
		//sort the result by customer rating
		driver.findElement(By.xpath("//select[@name='sort']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@name='sort']/option[@value='customer-rating']")).click();
		Thread.sleep(2000);
	}

	@And("^I select the item")
	public void I_select_the_item() throws Throwable {
		Actions actionitem1 = new Actions(driver);
		  //press page down key
	  
		 Thread.sleep(2000);
		  
		 actionitem1.sendKeys(Keys.PAGE_DOWN).perform();
		 //select the makeupkit that you want
	 	driver.findElement(By.linkText("Urban Decay 'Electric' Pressed Pigment Palette")).click();
		
		Thread.sleep(3000);
		
	}

	@And("^I add the item to cart")
	public void I_add_the_item_to_cart() throws Throwable {
		//add to shopping cart
		
		driver.findElement(By.xpath("//div[@id='add-to-shopping-bag']/button[@id='add-to-shopping-bag-button']")).click();
		Thread.sleep(3000);
	}

	@Then("^The item should be displayed in cart")
	public void The_item_should_be_displayed_in_cart() throws Throwable {
		Thread.sleep(2000);
		//click shopping cart link
		driver.findElement(By.xpath("//a[@id='shopping-bag-link']")).click();
		Thread.sleep(2000);
		
		//check whether the item has been added to the shopping cart
		boolean actualsource = driver.getPageSource().contains("Urban Decay 'Electric' Pressed Pigment Palette");
		assertTrue(actualsource);
		
		//check the title of the page
//		String expected = "Nordstrom: Designer Collections and Top Apparel, Shoe and Beauty Brands";
//		String actual = driver.getTitle();
		//assertTrue(driver.getTitle().contains("Urban Decay"));
//		assertEquals(expected, actual);
		Thread.sleep(3000);
		driver.quit();
	}




}
