//package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Login2 {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.palaoo.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testLogin2() throws Exception {
		driver.get(baseUrl + "/pkm/index.jsp");
		//for(int i=0;i<10;i++){
		driver.findElement(By.linkText("로그인")).click();
		driver.findElement(By.id("emailName")).clear();
		driver.findElement(By.id("emailName")).sendKeys("testqa06");
		driver.findElement(By.id("email_domain")).clear();
		driver.findElement(By.id("email_domain")).sendKeys("infraware.co.kr");
		driver.findElement(By.id("passwd")).clear();
		driver.findElement(By.id("passwd")).sendKeys("infra12");
		driver.findElement(By.id("joinBtn")).click();
	//	driver.wait();
		driver.findElement(By.linkText("로그아웃")).click();
	//	}
	}

	@After
	public void tearDown() throws Exception {
	//	driver.quit();
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
