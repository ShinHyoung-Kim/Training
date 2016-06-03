import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class AdvancedSearch extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		ChromeDriver driver = new ChromeDriver();
		String baseUrl = "http://www.google.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		selenium.start();
	}

	@Test
	public void testAdvancedSearch() throws Exception {
		selenium.open("http://www.google.com/");
		selenium.click("link=Advanced search");
		selenium.waitForPageToLoad("30000");
		selenium.type("as_q", "selftechy, selenium, eclipse");
		selenium.select("num", "label=20 results");
		selenium.click("//input[@value='Advanced Search']");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}