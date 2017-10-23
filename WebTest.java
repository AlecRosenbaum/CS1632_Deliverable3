import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user,
 * I would like to see reddit links in all sorts of ways,
 * So that I can know what is happening in the world
 * @author wlaboon
 *
 */

public class WebTest {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for reddit for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.reddit.com");
	}

	// Given that I am on the main page
	// When I view the title
	// Then I see that it contains the word "reddit"
	@Test
	public void testShowsCorrectTitle() {
		
		// Simply check that the title contains the word "reddit"
		
		String title = driver.getTitle();
		assertTrue(title.contains("reddit"));
	}
	
	// Given that I am on the main page
	// When I view the header
	// Then I see that it contains "new", "rising", and "top" links
	@Test
	public void testHasCorrectHeaderLinks() {
		
		// Check for new, rising, and top links - if any of
		// these is not found, fail the test
		
		try {
			driver.findElement(By.linkText("new"));
			driver.findElement(By.linkText("rising"));
			driver.findElement(By.linkText("top"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	// Given that I am on the main page
	// When I view the Remember Me section
	// Then I should see that it contains the phrase "remember me"
	@Test
	public void testHasRememberMe() {
		
		// Check that there is a remember-me element
		// that contains the text "remember me"
		// If it does not exist, or text is incorrect, fail test
		
		try {
			WebElement e = driver.findElement(By.id("remember-me"));
			String elementText = e.getText();
			assertTrue(elementText.contains("remember me"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	// Given that I am on the main page
	// When I click on the "new" link
	// Then I should be redirected to the "new" page
	@Test
	public void testSeeNewLinks() {
		
		// find the "new" link and click on it
		// The page you go to should include "newest submissions"
		// in the title
		
		driver.findElement(By.linkText("new")).click();
		String newPageTitle = driver.getTitle();
		assertTrue(newPageTitle.contains("newest submissions"));
	}
	
	// Given that I am on the main page
	// And I am not logged in 
	// When I try to login with an valid username and invalid password
	// Then I am given the opportunity to reset the password
	@Test
	public void testBadPasswordResetLink() {
		
		// Enter username "meow", password "meow"
	    
                // ENTER YOUR OWN USERNAME/INVALID PASSWORD HERE!
	    
		// driver.findElement(By.name("user")).sendKeys("dasbill");
		// driver.findElement(By.name("passwd")).sendKeys("meow");
		
		// Look for the submit button (in the login div) and click
		// to attempt to login 
		
		WebElement loginDiv = driver.findElement(By.id("login_login-main"));
		
		WebElement submitButton = loginDiv.findElement(By.className("btn"));
		submitButton.click();
		
		// Check that there is a link to reset password and it is visible
		
		try {
			WebElement resetPw = driver.findElement(By.linkText("reset password"));
			assertTrue(resetPw.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	// The homepage shall display the text "Welcome, friend, to a land of pure calculation" as well as "Used for CS1632 Software Quality Assurance, taught by Bill Laboon"
	
	// Every page shall include five links at the top, to "CS1632 D3 Home", "Factorial", "Fibonacci", "Hello", and "Cathedral Pics". These shall link to /, /fact, /fib, /hello, and /cathy, respectively.
	
	// The factorial page (/fact) shall allow a user to enter a positive integer from 1 to 100, and upon pressing submit, shall show to the user the factorial of the value (e.g. "Factorial of 5 is 120!").
	
	// The Fibonacci page (/fib) shall allow a user to enter a positive integer from 1 to 100, and upon pressing submit, shall show to the user the Fibonnaci of the value (e.g. "Fibonacci of 5 is 8!").
	
	// For both the Fibonacci and Factorial pages, if a user enters an invalid value of any kind, they shall be informed that the value is 1 (e.g., "Fibonacci of -100 is 1!")
	
	// Accessing the hello page (/hello) with no trailing values in the URL shall display the message "Hello CS1632, from Prof. Laboon!".
	
	// If a trailing value is provided in the URL when accessing the /hello page, then the message shall display hello from that trailing value. For example, when accessing /hello/Jazzy, the system shall display "Hello CS1632, from Jazzy". This shall work for all input values.
	
	// The Cathedral page (/cathy) shall display three images of the Cathedral of Learning in a numbered list.

}
