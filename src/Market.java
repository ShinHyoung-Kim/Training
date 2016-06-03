import java.awt.RadialGradientPaint;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.jetty.html.Input;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Market {
	private static WebDriver driver;
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
	

	
	@Before
	public static void setUp() throws Exception{ 
	 
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
	public void testMarket() throws Exception {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("top");
		driver.findElement(By.xpath(".//*[@id='gnb']/ul/li[8]/a")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		System.out.println(1);
		
		//driver.findElement(By.className("searchBox")).isSelected();
		//System.out.println(2);
		
		Select select = new Select(driver.findElement(By.id("s_prod_type")));
		select.selectByValue("1");
		
	
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
