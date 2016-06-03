
import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.LALOAD;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.selenesedriver.SendKeys;
import org.openqa.selenium.support.ui.Select;

public class EkpcBookBuy {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new InternetExplorerDriver();
		baseUrl = "http://twww.palaoo.com/pgm/goods/productDetail.jsp?contID=";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		

	@Test
	public void testEkpcBookBuy() throws IOException {
		
		driver.get("http://twww.palaoo.com" + "/pkm/index.jsp");
		driver.findElement(By.linkText("로그인")).click();
		driver.findElement(By.id("emailName")).clear();
		driver.findElement(By.id("emailName")).sendKeys("testqa06");
		driver.findElement(By.id("email_domain")).clear();
		driver.findElement(By.id("email_domain")).sendKeys("infraware.co.kr");
		driver.findElement(By.id("passwd")).clear();
		driver.findElement(By.id("passwd")).sendKeys("infra12");
		driver.findElement(By.cssSelector("img.ml5.vm")).click();
		driver.findElement(By.linkText("이북몰")).click();	
		
		FileReader fr = null;
		String[] str = new String[5424];
		Scanner sc = new Scanner(new File("pid.txt"));
			while(sc.hasNextLine()){
			for(int i=0;i< str.length; ++i){
				str[i] = sc.nextLine();
			//	System.out.println("str["+ i+"] :"+ str[i]);
			}
			
	
		for(int i=0;i<str.length; ++i){
			
			driver.get(baseUrl+ str[i]);
			sleep(2);
			driver.findElement(By.cssSelector("img[alt=\"바로구매\"]")).click();
			driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[3]/div/div[2]/div[2]/div[1]/dl/dd/span/span/img")).click();
			driver.findElement(By.cssSelector("img[alt=\"결제하기\"]")).click();
			sleep(1);
			driver.switchTo().alert().accept();
							
			sleep(3);
		}
				
			}
		
	}
		
			
	private void sleep(int sec) {
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
