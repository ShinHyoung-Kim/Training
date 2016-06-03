
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

public class ConditionSearch {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "C://Selenium/chromedriver.exe");
//		driver = new ChromeDriver();
		baseUrl = "http://tadmin.palaoo.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testConditionSearch() throws Exception {
		driver.get(baseUrl + "/_aocstp/index.jsp");
		driver.findElement(By.id("uid")).clear();
		driver.findElement(By.id("uid")).sendKeys("admin");
		driver.findElement(By.id("upass")).clear();
		driver.findElement(By.id("upass")).sendKeys("vkffkdn12!");
		driver.findElement(By.xpath(".//*[@id='admin_form']/dl/dd[3]/a/img")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("top");
		driver.findElement(By.linkText("사이트관리")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
    	driver.findElement(By.xpath("(//input[@id='s_beopen'])[3]")).click();
		new Select(driver.findElement(By.id("s_kind"))).selectByVisibleText("내용");
		driver.findElement(By.id("s_value")).clear();
		driver.findElement(By.id("s_value")).sendKeys("굳");
		driver.findElement(By.cssSelector("em")).click();
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit();
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
