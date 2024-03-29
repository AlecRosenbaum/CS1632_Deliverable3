import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.logging.*;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.*;
import java.util.List;

public class WebTest {

	static WebDriver driver = new HtmlUnitDriver();
	final static String baseURL = "https://cs1632ex.herokuapp.com/";


	// Note that the @BeforeClass annotation runs ONCE
	// per class, before any of the test cases are run
	// Compare this to @Before, which runs before
	// EACH @Test-annotated method (test case)

	@BeforeClass
	public static void setUpDriver() {

		// Note that the logging level is a Java standard (thus the
		// use of a java.util class instead of something specific
		// to Selenium.  You can modify these levels yourself if,
		// for example, you would like to see only SEVERE errors.
		// They can be set to ALL (show all messages) or OFF (no messages)
		// or to any minimum level from FINEST (most verbose) to SEVERE
		// (only show the most egregious of errors).
		// A full lists of levels and descriptions are located at:
		// https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html

		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		driver = new HtmlUnitDriver();

	}

	// Start at the home page for reddit for each test
	@Before
	public void setUp() throws Exception {
		driver.get(baseURL);
	}

	// Given that I am on the main page
	// Verify that the following text is present:
	// "Welcome, friend, to a land of pure calculation"
	@Test
	public void testShowsCorrectHomePageText_000() {
				
		String bodyText = driver.findElement(By.className("lead")).getText();
		assertTrue(bodyText.contains("Welcome, friend,\nto a land of pure calculation"));
	}

	// Given that I am on the main page
	// Verify that the following text is present:
	// "Used for CS1632 Software Quality Assurance, taught by Bill Laboon"
	@Test
	public void testShowsCorrectHomePageText_001() {
				
		String bodyText = driver.findElements(By.className("lead")).get(1).getText();
		assertTrue(bodyText.contains("Used for CS1632 Software Quality Assurance, taught by Bill Laboon"));
	}
	
	// Given that I am on the main page
	// When I view the header
	// Then I see that it contains "new", "rising", and "top" links
	@Test
	public void testHasCorrectHeaderLinks_000() {

		// Check for links + link location
		try {
			WebElement link = driver.findElement(By.linkText("CS1632 D3 Home"));
			assertEquals(baseURL, link.getAttribute("href"));

			link = driver.findElement(By.linkText("Factorial"));
			assertEquals(baseURL + "fact", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Fibonacci"));
			assertEquals(baseURL + "fib", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Hello"));
			assertEquals(baseURL + "hello", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Cathedral Pics"));
			assertEquals(baseURL + "cathy", link.getAttribute("href"));

		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

	// Given that I am on the factorial page
	// When I view the header
	// Then I see that it contains "new", "rising", and "top" links
	@Test
	public void testHasCorrectHeaderLinks_001() {

		driver.get(baseURL+"fact");
		// Check for links + link location
		try {
			WebElement link = driver.findElement(By.linkText("CS1632 D3 Home"));
			assertEquals(baseURL, link.getAttribute("href"));

			link = driver.findElement(By.linkText("Factorial"));
			assertEquals(baseURL + "fact", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Fibonacci"));
			assertEquals(baseURL + "fib", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Hello"));
			assertEquals(baseURL + "hello", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Cathedral Pics"));
			assertEquals(baseURL + "cathy", link.getAttribute("href"));

		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

	// Given that I am on the fib page
	// When I view the header
	// Then I see that it contains "new", "rising", and "top" links
	@Test
	public void testHasCorrectHeaderLinks_002() {

		driver.get(baseURL+"fib");
		// Check for links + link location
		try {
			WebElement link = driver.findElement(By.linkText("CS1632 D3 Home"));
			assertEquals(baseURL, link.getAttribute("href"));

			link = driver.findElement(By.linkText("Factorial"));
			assertEquals(baseURL + "fact", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Fibonacci"));
			assertEquals(baseURL + "fib", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Hello"));
			assertEquals(baseURL + "hello", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Cathedral Pics"));
			assertEquals(baseURL + "cathy", link.getAttribute("href"));

		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

	// Given that I am on the hello page
	// When I view the header
	// Then I see that it contains "new", "rising", and "top" links
	@Test
	public void testHasCorrectHeaderLinks_003() {

		driver.get(baseURL+"hello");
		// Check for links + link location
		try {
			WebElement link = driver.findElement(By.linkText("CS1632 D3 Home"));
			assertEquals(baseURL, link.getAttribute("href"));

			link = driver.findElement(By.linkText("Factorial"));
			assertEquals(baseURL + "fact", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Fibonacci"));
			assertEquals(baseURL + "fib", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Hello"));
			assertEquals(baseURL + "hello", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Cathedral Pics"));
			assertEquals(baseURL + "cathy", link.getAttribute("href"));

		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

	// Given that I am on the cathy page
	// When I view the header
	// Then I see that it contains "new", "rising", and "top" links
	@Test
	public void testHasCorrectHeaderLinks_004() {

		driver.get(baseURL+"cathy");
		// Check for links + link location
		try {
			WebElement link = driver.findElement(By.linkText("CS1632 D3 Home"));
			assertEquals(baseURL, link.getAttribute("href"));

			link = driver.findElement(By.linkText("Factorial"));
			assertEquals(baseURL + "fact", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Fibonacci"));
			assertEquals(baseURL + "fib", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Hello"));
			assertEquals(baseURL + "hello", link.getAttribute("href"));

			link = driver.findElement(By.linkText("Cathedral Pics"));
			assertEquals(baseURL + "cathy", link.getAttribute("href"));

		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

	// The factorial page (/fact) shall allow a user to enter a positive integer from 1 to 100,
	// and upon pressing submit, shall show to the user the factorial of the
	// value (e.g. "Factorial of 5 is 120!").
	@Test
	public void testFactPage_000() {
		driver.get(baseURL + "fact");
		try {
			WebElement elem = driver.findElements(By.xpath("//input[@type='text']")).get(0);
			assertNotNull(elem);

			elem.sendKeys("5");

			elem = driver.findElements(By.xpath("//input[@type='submit']")).get(0);
			elem.click();

			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Factorial of 5 is 120!"));

		} catch (Exception e) {
			fail();
		}
	}

	// The factorial page (/fact) shall allow a user to enter a positive integer from 1 to 100,
	// and upon pressing submit, shall show to the user the factorial of the
	// value (e.g. "Factorial of 100 is 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000!").
	@Test
	public void testFactPage_001() {
		driver.get(baseURL + "fact");
		try {
			WebElement elem = driver.findElements(By.xpath("//input[@type='text']")).get(0);
			assertNotNull(elem);

			elem.sendKeys("100");

			elem = driver.findElements(By.xpath("//input[@type='submit']")).get(0);
			elem.click();

			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Factorial of 100 is 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000!"));

		} catch (Exception e) {
			fail();
		}
	}

	// The factorial page (/fact) shall allow a user to enter a positive integer from 1 to 100,
	// and upon pressing submit, shall show to the user the factorial of the
	// value (e.g. "Factorial of 50 is 30414093201713378043612608166064768844377641568960512000000000000!").
	@Test
	public void testFactPage_002() {
		driver.get(baseURL + "fact");
		try {
			WebElement elem = driver.findElements(By.xpath("//input[@type='text']")).get(0);
			assertNotNull(elem);

			elem.sendKeys("50");

			elem = driver.findElements(By.xpath("//input[@type='submit']")).get(0);
			elem.click();

			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Factorial of 50 is 30414093201713378043612608166064768844377641568960512000000000000!"));

		} catch (Exception e) {
			fail();
		}
	}

	// The Fibonacci page (/fib) shall allow a user to enter a positive integer from 1 to 100,
	// and upon pressing submit, shall show to the user the Fibonnaci of the
	// value (e.g. "Fibonacci of 5 is 8!").
	@Test
	public void testFibPage_000() {
		driver.get(baseURL + "fib");
		try {
			WebElement elem = driver.findElements(By.xpath("//input[@type='text']")).get(0);
			assertNotNull(elem);

			elem.sendKeys("5");

			elem = driver.findElements(By.xpath("//input[@type='submit']")).get(0);
			elem.click();

			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Fibonacci of 5 is 8!"));

		} catch (Exception e) {
			fail();
		}
	}

	// The Fibonacci page (/fib) shall allow a user to enter a positive integer from 1 to 100,
	// and upon pressing submit, shall show to the user the Fibonnaci of the
	// value (e.g. "Fibonacci of 100 is 573147844013817084101!").
	@Test
	public void testFibPage_001() {
		driver.get(baseURL + "fib");
		try {
			WebElement elem = driver.findElements(By.xpath("//input[@type='text']")).get(0);
			assertNotNull(elem);

			elem.sendKeys("100");

			elem = driver.findElements(By.xpath("//input[@type='submit']")).get(0);
			elem.click();

			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue("Wrong Fibonacci Displayed!", bodyText.contains("Fibonacci of 100 is 573147844013817084101!"));

		} catch (Exception e) {
			fail();
		}
	}

	// The Fibonacci page (/fib) shall allow a user to enter a positive integer from 1 to 100,
	// and upon pressing submit, shall show to the user the Fibonnaci of the
	// value (e.g. "Fibonacci of 50 is 8!").
	@Test
	public void testFibPage_002() {
		driver.get(baseURL + "fib");
		try {
			WebElement elem = driver.findElements(By.xpath("//input[@type='text']")).get(0);
			assertNotNull(elem);

			elem.sendKeys("50");

			elem = driver.findElements(By.xpath("//input[@type='submit']")).get(0);
			elem.click();

			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue("Wrong Fibonacci Displayed!", bodyText.contains("Fibonacci of 50 is 20365011074!"));

		} catch (Exception e) {
			fail();
		}
	}

	// For both the Fibonacci and Factorial pages, if a user enters an invalid value of any kind,
	// they shall be informed that the value is 1 (e.g., "Fibonacci of -100 is 1!")
	@Test
	public void testInvalidInput_000() {
		driver.get(baseURL + "fact");
		try {
			WebElement elem = driver.findElements(By.xpath("//input[@type='text']")).get(0);
			assertNotNull(elem);

			elem.sendKeys("-100");

			elem = driver.findElements(By.xpath("//input[@type='submit']")).get(0);
			elem.click();

			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Factorial of -100 is 1!"));

		} catch (Exception e) {
			fail();
		}
	}

	// For both the Fibonacci and Factorial pages, if a user enters an invalid value of any kind,
	// they shall be informed that the value is 1 (e.g., "Fibonacci of -100 is 1!")
	@Test
	public void testInvalidInput_001() {
		driver.get(baseURL + "fib");
		try {
			WebElement elem = driver.findElements(By.xpath("//input[@type='text']")).get(0);
			assertNotNull(elem);

			elem.sendKeys("-100");

			elem = driver.findElements(By.xpath("//input[@type='submit']")).get(0);
			elem.click();

			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Fibonacci of -100 is 1!"));

		} catch (Exception e) {
			fail();
		}
	}

	// For both the Fibonacci and Factorial pages, if a user enters an invalid value of any kind,
	// they shall be informed that the value is 1 (e.g., "Fibonacci of -100 is 1!")
	@Test
	public void testInvalidInput_002() {
		driver.get(baseURL + "fib");
		try {
			WebElement elem = driver.findElements(By.xpath("//input[@type='text']")).get(0);
			assertNotNull(elem);

			elem.sendKeys("asdf");

			elem = driver.findElements(By.xpath("//input[@type='submit']")).get(0);
			elem.click();

			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Fibonacci of asdf is 1!"));

		} catch (Exception e) {
			fail("input 'asdf' fails on Fibonacci page");
		}
	}

	// For both the Fibonacci and Factorial pages, if a user enters an invalid value of any kind,
	// they shall be informed that the value is 1 (e.g., "Fibonacci of -100 is 1!")
	@Test
	public void testInvalidInput_003() {
		driver.get(baseURL + "fact");
		try {
			WebElement elem = driver.findElements(By.xpath("//input[@type='text']")).get(0);
			assertNotNull(elem);

			elem.sendKeys("asdf");

			elem = driver.findElements(By.xpath("//input[@type='submit']")).get(0);
			elem.click();

			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Factorial of asdf is 1!"));

		} catch (Exception e) {
			fail("input 'asdf' fails on Factorial page");
		}
	}

	// Accessing the hello page (/hello) with no trailing values in the URL shall display
	// the message "Hello CS1632, from Prof. Laboon!".
	@Test
	public void testHelloNoInput_000() {
		driver.get(baseURL + "hello");
		try {
			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Hello CS1632, from Prof. Laboon!"));

		} catch (Exception e) {
			fail();
		}
	}

	// If a trailing value is provided in the URL when accessing the /hello page, then the
	// message shall display hello from that trailing value. For example, when accessing
	// /hello/Jazzy, the system shall display "Hello CS1632, from Jazzy". This shall work
	// for all input values.
	@Test
	public void testHelloInput_000() {
		driver.get(baseURL + "hello/Jazzy");
		try {
			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Hello CS1632, from Jazzy"));

		} catch (Exception e) {
			fail();
		}
	}

	// If a trailing value is provided in the URL when accessing the /hello page, then the
	// message shall display hello from that trailing value. For example, when accessing
	// /hello/Jazzy, the system shall display "Hello CS1632, from Jazzy". This shall work
	// for all input values.
	@Test
	public void testHelloInput_001() {
		driver.get(baseURL + "hello/Jazzy/NotJazzy");
		try {
			// Check that there is the factorial output
			String bodyText = driver.findElement(By.className("jumbotron")).getText();
			assertTrue(bodyText.contains("Hello CS1632, from Jazzy/NotJazzy"));

		} catch (Exception e) {
			fail("'Jazzy/NotJazzy' not displayed properly");
		}
	}

	// If I am on the Cathy page I will be able to see 3 images
	// which are contained within a list
	@Test
	public void testHasCorrectNumCathies_000() {

		driver.get(baseURL+"cathy");
		List<WebElement> listElements = driver.findElements(By.xpath("//div[@class='jumbotron']/ol/li")); 
		assertEquals(listElements.size() , 3);
		List<WebElement> allImages = driver.findElements(By.tagName("img"));
		assertEquals(allImages.size() , 3);

	}
}
