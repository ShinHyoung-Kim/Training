
import java.util.concurrent.TimeUnit;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class AdminSelectTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception{
		driver = new InternetExplorerDriver();
		baseUrl = "http://tadmin.palaoo.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test
	public void testAdminSelectTest() throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.xpath(".//*[@id='uid']")).clear();
		driver.findElement(By.xpath(".//*[@id='uid']")).sendKeys("admin");
		driver.findElement(By.id("upass")).clear();
		driver.findElement(By.id("upass")).sendKeys("vkffkdn12!");
		driver.findElement(By.xpath(".//*[@id='admin_form']/dl/dd[3]/a/img")).click();
		sleep(2);
	/*	driver.switchTo().frame("menu");
		driver.findElement(By.xpath(".//*[@id='s4']/li/a")).click();
		sleep(2);*/	
		driver.switchTo().defaultContent();
		driver.switchTo().frame("top");
		driver.findElement(By.xpath(".//*[@id='gnb']/ul/li[4]/a")).click(); //사이트관리
		sleep(2);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
	//	sleep(2);
		
		//xpath 선택 
		driver.findElement(By.xpath("(//input[@id='s_beopen'])[3]")).click();
		driver.findElement(By.xpath("(//input[@value = 'N'])")).submit();
		
		Select sel = new Select(driver.findElement(By.tagName(".//*[@id='s_beopen']")));
		sel.selectByIndex(3);
		
		
		
		
		
		//dropdown 선택 
		Select select = new Select(driver.findElement(By.className("clfix contact")));
		select.selectByVisibleText("내용");
		WebElement s_value = driver.findElement(By.name("s_value"));
		s_value.clear();
		s_value.sendKeys("굳");
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
	
		driver.findElement(By.id("s_value")).sendKeys("굳");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		String boardlist = driver.findElement(By.xpath(".//*[@id='notice_table']/tbody/tr[1]/td[3]")).getText();
		System.out.println(boardlist);
		
		driver.findElement(By.cssSelector("em")).submit();
		System.out.println("테스트");
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
	public void tearDown() throws Exception{
//		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if(!"".equals(verificationErrorString)){
			fail(verificationErrorString);
		}
	}
	private boolean isElementPresent(By by){
	 try{
		driver.findElement(by);
		return true;
	 }catch (NoSuchElementException e){
		 return false;
	 }
	}
}
