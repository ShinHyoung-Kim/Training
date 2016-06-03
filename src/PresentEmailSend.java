import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class PresentEmailSend {
	private  WebDriver driver;
	private String baseUrl;
	private  StringBuffer verificationErrors = new StringBuffer();
	String id, idDomain, pw;
	String eId, eDomain;
	String sBookId;
	
	
	@Before
	public void setUp() throws Exception{
		
		//선물 보낼 계정 정보
		id = "testqa05";
		idDomain = "infraware.co.kr";
		pw = "infra12";
		
		//Email 수신 정보
		eId = "waresys";
		eDomain = "gmail.com";
		
		//도서 ID 정보
		sBookId = "PB12039160";
				
		driver = new FirefoxDriver();
		//driver = new InternetExplorerDriver();
		
		//팔라우 도서 상세 페이지 접근
		baseUrl = "http://twww.palaoo.com/pgm/goods/productDetail.jsp?contID=";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

	}
		
		
	@Test
	public void testPresentBookEmail() throws Exception {
		
		//팔라우 로그인
		driver.get("Http://twww.palaoo.com");
		driver.findElement(By.linkText("로그인")).click();
		driver.findElement(By.id("emailName")).sendKeys(id);
		driver.findElement(By.id("email_domain")).sendKeys(idDomain);
		driver.findElement(By.id("passwd")).sendKeys(pw);
		driver.findElement(By.id("joinBtn")).click();
		
		//로그인 팝업 경고창 진행
		driver.switchTo().alert().accept();
		sleep(2);
		
		

		//선물 도서 선택(도서 상세 페이지 진입)
		driver.get(baseUrl + sBookId);
		sleep(1);

		//도서 상세 페이지 선물하기 선택
		driver.findElement(By.cssSelector("img[alt=\"선물하기\"]")).click();
		sleep(2);
		
		//Select 박스에서 이메일 선택
		driver.findElement(By.cssSelector("span.jquery-selectbox-iptL-currentItem")).click();
		driver.findElement(By.xpath("//div[@id='contents']/div[2]/div[3]/div/table[2]/tbody/tr/td/ul/li/div/div[2]/span[2]")).click();
		sleep(1);
		
		//선물 수령자 정보 입력
		driver.findElement(By.id("receiveEmail1")).sendKeys(eId);
		driver.findElement(By.id("receiveEmail2")).sendKeys(eDomain);
		driver.findElement(By.id("receiveName")).sendKeys("테스트");
		driver.findElement(By.id("sendSubject")).sendKeys("제목");
		driver.findElement(By.id("sendContent")).sendKeys("메세지내용");
		sleep(1);
		
		//주문하기 선택
		driver.findElement(By.cssSelector("img[alt=\"주문하기\"]")).click();
		sleep(2);
		
		//결제 방식 입력 후 진행(캐쉬사용)
		driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[3]/div/div[2]/div[2]/div[1]/dl/dd/span/span/img")).click();
		sleep(2);
		
		//결제하기 선택
		driver.findElement(By.cssSelector("img[alt=\"결제하기\"]")).click();
		sleep(2);
		
		
		//팝업 경고창 진행
		driver.switchTo().alert().accept();
		
		System.out.println("End!!");
	}
	
	
	private static void sleep(int sec) {
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