
import java.io.File.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

public class AlertTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new InternetExplorerDriver();
		baseUrl = "http://twww.palaoo.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAlertTest() throws Exception {
		
		driver.get(baseUrl + "pkm/index.jsp");
		captureScreen();
		sleep(2);
		/*driver.findElement(By.linkText("로그인")).click();
		driver.findElement(By.id("emailName")).clear();
		driver.findElement(By.id("emailName")).sendKeys("dd");
		driver.findElement(By.id("email_domain")).clear();
		driver.findElement(By.id("email_domain")).sendKeys("ss");
		driver.findElement(By.id("passwd")).clear();
		driver.findElement(By.id("passwd")).sendKeys("fsaf");
		driver.findElement(By.cssSelector("img.ml5.vm")).click();
		String message = driver.switchTo().alert().getText();
		System.out.println("Message is " + message); 
		driver.switchTo().alert().dismiss();*/
		driver.findElement(By.linkText("로그인")).click();
		driver.findElement(By.id("emailName")).clear();
		driver.findElement(By.id("emailName")).sendKeys("testqa07");
		driver.findElement(By.id("email_domain")).clear();
		driver.findElement(By.id("email_domain")).sendKeys("infraware.co.kr");
		driver.findElement(By.id("passwd")).clear();
		driver.findElement(By.id("passwd")).sendKeys("infra12");
		captureScreen();
		sleep(2);
		driver.findElement(By.cssSelector("img.ml5.vm")).click();
		/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:/Download/google.png"));
		Thread.sleep(10000);
		captureScreen();*/
		
	}

	private void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void captureScreen() {
		String path;		
		try {
		//	WebDriver agumentedDriver = new Augmenter().augment(driver);
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			path = "D:/Download/screenShots/" + source.getName();
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		}
		//return path;
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
