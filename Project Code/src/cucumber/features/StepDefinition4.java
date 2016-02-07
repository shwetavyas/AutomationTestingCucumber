package cucumber.features;

import java.io.File;
import java.util.concurrent.TimeUnit;




import static org.junit.Assert.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition4 {
	WebDriver driver = null;
	String expected = "$376.00";
	
	@Given("^Navigate to Nordstorm website partFour$")
	public void Navigate_to_Nordstrom_website() throws Throwable {
		//Open firefox browser
		driver = new FirefoxDriver();
		//go to nordstorm website
		driver.navigate().to("http://shop.nordstrom.com/");
		//maximize the window size
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Given("^Navigate to Nordstrom website part-5$")
	public void Navigate_to_Nordstrom_website2() throws Throwable {
		//Open firefox browser
		driver = new FirefoxDriver();
		//go to nordstorm website
		driver.navigate().to("http://shop.nordstrom.com/");
		//maximize the window size
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("^I click on Women link$")
	public void I_click_on_Women_link() throws Throwable {
		Thread.sleep(3000);
		//Click on Women's Link
		driver.findElement(By.linkText("Women")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Women")).click();
		//Check the title of the Page
		assertTrue(driver.getTitle().contains("Women's Clothing, Shoes & Accessories | Nordstrom"));
		Thread.sleep(1000);
		
		
	}

	@When("^I click on Clothing link$")
	public void I_click_on_Clothing_link() throws Throwable {
		//Click on Clothing link
		driver.findElement(By.linkText("Clothing")).click();
		//assertTrue(driver.getTitle().equals("Women's Clothing, Shoes & Accessories | Nordstrom"));
		Thread.sleep(1000);
	    
	}
	@When("^I click on Dresses link$")
	public void I_click_on_Dresses_link() throws Throwable {
		//Click on Dresses Link
		driver.findElement(By.linkText("Dresses")).click();
		//Check the title of the page
		assertTrue(driver.getTitle().equals("Dresses | Cocktail Dresses | Maxi Dresses | Nordstrom"));
	    
	}
	
	@When("^I select first item$")
	public void I_select_an_item() throws Throwable {
		//Click on Eliza J Belted Print Dress
		driver.findElement(By.linkText("Eliza J Belted Print Faille Fit & Flare Dress (Regular & Petite)")).click();
		//Check the title of the page
		assertTrue(driver.getTitle().equals("Eliza J Belted Print Faille Fit & Flare Dress (Regular & Petite) | Nordstrom"));
		//Check the price of the dress
		assertTrue(driver.getPageSource().contains("$138.00"));
		//Select the size of dress
		driver.findElement(By.id("size-id-3")).click();
		
	}
	
	
	@When("^I click on Add to cart$")
	public void I_click_on_Add_to_cart() throws Throwable {
		//Add the dress to the shopping bag
		driver.findElement(By.id("add-to-shopping-bag-button")).click();
	    
	}
	
	@When("^I click on Shopping Bag$")
	public void I_click_on_Shopping_Bag() throws Throwable {
		//Click on Shopping bag link to check if dress is added
		driver.findElement(By.linkText("Shopping Bag")).click();
	    
	}
	
	@When("^I click on CONTINUE SHOPPING$")
	public void I_click_on_CONTINUE_SHOPPING() throws Throwable {
		//Click on Continue shopping to add another dress
		driver.findElement(By.xpath("//img[@alt='CONTINUE SHOPPING']")).click();
		Thread.sleep(1000);
	    
	}
	
	@When("^I select second item$")
	public void I_select_another_item() throws Throwable {
		//Select and add another dress to the shopping bag
		driver.findElement(By.linkText("Tadashi Shoji Lace Overlay Dress")).click();
		assertTrue(driver.getTitle().equals("Tadashi Shoji Lace Overlay Dress | Nordstrom"));
		assertTrue(driver.getPageSource().contains("$238.00"));
		driver.findElement(By.id("size-id-3")).click();
		
		
		}
	
	 
	 @When("^I click on CHECKOUT$")
		public void I_click_on_CHECKOUT() throws Throwable {
		 	//Click on Checkout
		 	driver.findElement(By.xpath("//img[@alt='CHECKOUT']")).click();
		 	//Get subtotal cost as a string variable
		 	String actual = driver.findElement(By.xpath("//b[@class='right ng-binding']")).getText();
		 	//System.out.println(actual);
		 	//Substring to just get the price
			actual = actual.substring(10);
			//System.out.println(actual);
			//Compare with the expected and actual price of the dresses
		 	assertEquals(expected, actual);
			Thread.sleep(1000);
		    
		}
	@Then("^I should be directed to the checkout page$")
	public void I_should_be_directed_to_the_checkout_page() throws Throwable {
		//Check the title of the page and quit
		driver.getTitle().contains("Nordstorm Checkout");
		Thread.sleep(3000);
		driver.quit();
	   
	}

	@When("^I click on Nordstrom Stylists Link$")
	public void I_click_on_Get_Started_Link() throws Throwable {
		Thread.sleep(3000);
		//Click on Nordstorm Stylist to book an appointment
	    driver.findElement(By.linkText("Nordstrom Stylists")).click();
	}

	@When("^I enter zipcode to check store$")
	public void I_enter_zipcode_to_check_store() throws Throwable {
		//Enter zip code in the zip field
	    driver.findElement(By.id("zip")).sendKeys("60290");
	    //click on Check Stores button
	    driver.findElement(By.xpath("//button[contains(text(),'Check Stores')]")).click();
	}

	@When("^I select a store$")
	public void I_select_a_store() throws Throwable {
		//Select Michigan Avenue Store
	    driver.findElement(By.xpath("//label[contains(text(), 'Michigan Avenue (1 mi.)')]")).click();
	}

	@When("^I click on Book Appointment$")
	public void I_click_on_Book_Appointment() throws Throwable {
		//CLick on Book An Appointment button
	    driver.findElement(By.xpath("//button[contains(text(), 'Book an Appointment')]")).click();
	}

	@When("^I select Personal Styling for women$")
	public void I_select_Personal_Styling_for_women() throws Throwable {
		//As new modal window opens we need to switch to that frame
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		//Click on Personal Styling Services for Women
		driver.findElement(By.xpath("//div[contains(text(), 'Personal Styling Services for Women')]")).click();
		//Click on contiune button
		driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
	}

	@When("^I select Any Stylist$")
	public void I_select_Any_Stylist() throws Throwable {
		Thread.sleep(3000);
		//Select Any Stylist
	    driver.findElement(By.xpath("//div[contains(text(),'Any Stylist')]")).click();
	    //Click on continue
	    driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
	}

	@When("^I select Quick wardrobe update for Women$")
	public void I_select_Quick_wardrobe_update_for_Women() throws Throwable {
		Thread.sleep(3000);
		//Select Quick Wardrobe Update for Women
		driver.findElement(By.xpath("//div[contains(text(),'Quick Wardrobe Update for Women')]")).click();
		//Click on continue
		driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
	}

	@When("^I select a date and time$")
	public void I_select_a_date_and_time() throws Throwable {
		Thread.sleep(3000);
		//Select the date from calender and a time slot for that date
	    driver.findElement(By.xpath("//td[@id='2015-03-31']/div[@widgetid='tt_form_ChoiceSelect_4']/select[@id='tt_form_ChoiceSelect_4']/option[starts-with(text(),'3:00 PM')]")).click();//Change here! (I can't see data here that's why I have commented line181 for now.
	    Thread.sleep(3000);
	  //Click on continue
	    driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
	}

	@When("^I enter details$")
	public void I_enter_details() throws Throwable {
		//Enter the Personal Details
	   driver.findElement(By.xpath("//input[@id='attendee_person_firstName']")).sendKeys("Shweta");
	   driver.findElement(By.xpath("//input[@id='attendee_person_lastName']")).sendKeys("Vyas");
	   driver.findElement(By.id("attendee_email")).sendKeys("selenium501@gmail.com");
	   driver.findElement(By.id("attendee_mobile_phoneNumber")).sendKeys("309323535");
	   driver.findElement(By.xpath("//select[@id='attendee_customField1']/option[contains(text(), 'E-mail')]")).click();
	   driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
	}

	@When("^I review the details$")
	public void I_review_the_details() throws Throwable {
		//On Review Page check the details are as entered
	    System.out.println(driver.findElement(By.xpath("//table[@id='location']/tbody/tr/td[contains(text(),'Michigan Avenue')]")).getText());
	    assertTrue(driver.findElement(By.xpath("//table[@id='location']/tbody/tr/td[contains(text(),'Michigan Avenue')]")).getText().equals("Michigan Avenue"+"\n"+"55 East Grand Ave"+"\n"+"Chicago, IL 60611"+"\n"+"3124641515"));
	    assertTrue(driver.findElement(By.xpath("//table[@id='card_header']/thead/tr/td/h2/span[contains(text(),'Tuesday, March 31, 2015')]")).getText().equals("Tuesday, March 31, 2015"));
	    assertTrue(driver.findElement(By.xpath("//table[@id='card_header']/thead/tr/td/h2[contains(text(),'3:00 PM - 3:30 PM')]")).getText().equals("3:00 PM - 3:30 PM" +"\n"+"Central Time"));
	    System.out.println(driver.findElement(By.xpath("//table[@id='card_header']/thead/tr/td/h2[contains(text(),'3:00 PM - 3:30 PM')]")).getText());
	    assertTrue(driver.findElement(By.xpath("//table[@id='appointment-type-group']/tbody/tr/td[contains(text(),'Personal Styling Services for Women')]")).getText().equals("Personal Styling Services for Women"));
	    assertTrue(driver.findElement(By.xpath("//table[@id='resource']/tbody/tr/td/ul/li[contains(text(),'Any Stylist')]")).getText().equals("Any Stylist"));
	    System.out.println(driver.findElement(By.xpath("//table[@id='appointment-type']/tbody/tr/td[contains(text(),'Quick Wardrobe Update for Women')]")).getText());
	    assertTrue(driver.findElement(By.xpath("//table[@id='appointment-type']/tbody/tr/td[contains(text(),'Quick Wardrobe Update for Women')]")).getText().equals("Quick Wardrobe Update for Women"));
	    assertTrue(driver.findElement(By.xpath("//table[@id='attendee']/tbody/tr/td/ul/li[contains(text(),'Shweta Vyas')]")).getText().equals("Shweta Vyas"));
	    assertTrue(driver.findElement(By.xpath("//table[@id='attendee']/tbody/tr/td/ul/li[contains(text(),'selenium501@gmail.com')]")).getText().equals("selenium501@gmail.com"));
	    assertTrue(driver.findElement(By.xpath("//table[@id='attendee']/tbody/tr/td/ul/li[contains(text(),'309323535')]")).getText().equals("309323535"));



	    
	}

	@When("^I click on confirm$")
	public void I_click_on_confirm() throws Throwable {
			//COnfirm the details and appointment
		   driver.findElement(By.xpath("//input[@value = 'Confirm']")).click(); //Uncomment this
		 

	}

	@Then("^I should be directed to the confirmed appointment page$")
	public void I_should_be_directed_to_the_confirmed_appointment_page() throws Throwable {
		//Capture screenshot of appointment details
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);    //Uncomment line 215-218
		FileUtils.copyFile(scrFile, new File("D:\\Spring 2015\\IT468\\Project\\AfterAppointmentConfirm.jpg"));
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.id("mainTitle")).getText().equals("Your appointment is confirmed! We'll e-mail you soon."));
		
		Thread.sleep(3000);
		driver.quit();
	}

}
