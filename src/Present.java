import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
//import java.util.Date;
//import java.text.SimpleDateFormat;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.openqa.selenium.support.ui.Select;

public class Present {
	private static WebDriver driver;
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();

	//String sDate = null;
	
	@BeforeClass
	public static void setUp() throws Exception{
		/*System.setProperty("webdriver.chrome.driver", "C://Selenium/chromedriver.exe");
		driver = new ChromeDriver();*/
		driver = new FirefoxDriver();
		//driver = new InternetExplorerDriver();
		baseUrl = "http://twww.palaoo.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  /*
	  driver.get(baseUrl);
	  driver.findElement(By.linkText("로그인")).click();
	  driver.findElement(By.id("emailName")).sendKeys("testqa07");
	  driver.findElement(By.id("email_domain")).sendKeys("infraware.co.kr");
	  driver.findElement(By.id("passwd")).sendKeys("infra12");
	  driver.findElement(By.id("joinBtn")).click();
	  sleep(2);
	  */
	}
	
	@Test
	public void testPresentBookEmail() throws Exception {
		/*
		//선물 보내기
		driver.get("http://tkids.palaoo.com/pkm/goods/kidsDetail.jsp?contID=PP12070405");
		sleep(1);
		driver.findElement(By.cssSelector("img[alt=\"선물하기\"]")).click();
		sleep(2);
		Select select = new Select(driver.findElement(By.className("jquery-selectbox-iptL-currentItem")));
		select.selectByVisibleText("email");
		sleep(2);
		driver.findElement(By.id("receiveEmail1")).sendKeys("web0test0qa");
		driver.findElement(By.id("receiveEmail2")).sendKeys("gmail.com");
		driver.findElement(By.id("receiveName")).sendKeys("테스트");
		driver.findElement(By.id("sendSubject")).sendKeys("제목");
		driver.findElement(By.id("sendContent")).sendKeys("메세지내용");
		sleep(1);
		driver.findElement(By.cssSelector("img[alt=\"주문하기\"]")).click();
		sleep(2);
		driver.findElement(By.cssSelector("input[name=\"cashAllUse\"]")).click();
		driver.findElement(By.cssSelector("span.mark.jquery-checkbox-hover > img")).click();
		sleep(2);
		driver.findElement(By.cssSelector("img[alt=\"결제하기\"]")).click();
		sleep(2);
		driver.switchTo().alert().accept();
		*/
		
		
		//메일 확인
		driver.get("http://www.gmail.com");
		sleep(1);		
		driver.findElement(By.id("Email")).sendKeys("web0test0qa");
		driver.findElement(By.id("Passwd")).sendKeys("sano1202");
		driver.findElement(By.id("signIn")).click();
		sleep(3);
		driver.findElement(By.xpath(".//*[@id=':ov']/span")).click();
		sleep(3);
		
		System.out.println("0.Test.............");
		driver.findElement(By.cssSelector("img[alt=\"선물받기\"]")).click();
		System.out.println("1.Test.............");
		String currentHandle = driver.getWindowHandle();		
		Set<String> handles = driver.getWindowHandles();
		handles.remove(currentHandle);
		
		if(handles.size() > 0)
		driver.switchTo().window(handles.iterator().next());
		
		sleep(2);
		System.out.println("Test.............");
		
		driver.findElement(By.xpath(".//*[@id='contents']/div[4]/div[1]/div[2]/div[2]/a/img")).click();
		sleep(2);
		driver.findElement(By.id("emailName")).sendKeys("testqa07");
		driver.findElement(By.id("email_domain")).sendKeys("infraware.co.kr");
		driver.findElement(By.id("passwd")).sendKeys("infra12");
		driver.findElement(By.id("joinBtn")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath(".//*[@id='contents']/div[4]/div/div[2]/a/img")).click();
		driver.switchTo().alert().accept();
		sleep(2);
		
		
	}
		
		/*
		//driver.get("http://www.gmail.com");
		sDate = driver.findElement(By.id(":op")).getText();
		System.out.println(sDate);
		
		Date now = new Date(); 
	    SimpleDateFormat nowDate = new SimpleDateFormat("MM월 dd일"); 
	    System.out.println(nowDate.format(now)); 
		
	    	if (sDate == nowDate.format(now)){
	    		System.out.println("같음");
	    	}
	   	}
	   	*/

	
	@After
	public void tearDown() throws Exception {
		driver.quit();
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