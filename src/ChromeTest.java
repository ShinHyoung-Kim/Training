

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class ChromeTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C://Selenium/chromedriver.exe");
		//driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
		baseUrl = "http://www.palaoo.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testChromeTest() throws Exception {
		driver.get(baseUrl + "/pkm/index.jsp");
		driver.findElement(By.linkText("ÀÌºÏ¸ô")).click();
		driver.findElement(By.linkText("ÀÚ±â°è¹ß")).click();
		driver.findElement(By.id("keyword")).clear();
		driver.findElement(By.id("keyword")).sendKeys("ÂøÇÑ ¼º°ø");
		assertTrue("¾ÈÃ¶¼ö", true);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
