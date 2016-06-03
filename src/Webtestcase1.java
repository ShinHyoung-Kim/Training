//package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Webtestcase1 {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://twww.palaoo.com/pgm/goods/productDetail.jsp?contID=";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testWebtestcase1() throws Exception {
		driver.get(baseUrl + "/pkm/index.jsp");
		driver.findElement(By.id("query")).clear();
		driver.findElement(By.id("query")).sendKeys("like");
		driver.findElement(By.cssSelector("div.bnr > a > img")).click();
		driver.findElement(By.linkText("Palaoo logo")).click();
		sleep(2);
		
	}

	private void sleep(int sec) {
		// private void sleep(int sec){
		   try {
			      Thread.sleep(sec*1000);
			   } catch (InterruptedException e) {
			      e.printStackTrace();
			   }
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
