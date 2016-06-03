
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RadioBtnSelect {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://tadmin.palaoo.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testRadioBtnSelect() throws Exception {
		driver.get(baseUrl + "/_aocstp/frame_set.jsp?");
		
		driver.findElement(By.xpath("(//input[@id='s_beopen'])[3]")).click();
		new Select(driver.findElement(By.id("s_kind"))).selectByVisibleText("Á¦¸ñ + ³»¿ë");
		driver.findElement(By.id("s_value")).clear();
		driver.findElement(By.id("s_value")).sendKeys("±»");
		driver.findElement(By.cssSelector("em")).click();
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
