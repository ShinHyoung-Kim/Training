
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminLogin2 {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		  driver = new FirefoxDriver();
		  baseUrl = "http://tadmin.palaoo.com/";
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  driver.get(baseUrl);
		  
		  driver.findElement(By.id("uid")).click();
		  driver.findElement(By.id("uid")).clear();
		  driver.findElement(By.id("uid")).sendKeys("admin");
		  driver.findElement(By.id("upass")).click();
		  driver.findElement(By.id("upass")).clear();
		  driver.findElement(By.id("upass")).sendKeys("vkffkdn12!");
		  
		  driver.findElement(By.className("btn")).click();
		  sleep(2);	  
		}


	@Test
	public void testAdminLogin2() throws Exception {

	//	driver.switchTo().frame("top");
		driver.findElement(By.linkText("사이트관리")).click();
		driver.switchTo().frame("menu");
		driver.findElement(By.xpath(".//*[@id='s9']/li[2]/a")).click();
		driver.switchTo().frame("");
		driver.switchTo().frame("main");
		driver.findElement(By.id("s_value")).clear();
		driver.findElement(By.id("s_value")).sendKeys("오픈");
		driver.findElement(By.xpath(".//*[@id='header']/div/a[1]/img")).click();
	}

	
	@After
	public void tearDown() throws Exception {
	//	driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

private static void sleep(int sec) {
	try {
		Thread.sleep(sec*1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
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
