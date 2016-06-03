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
		
		//���� ���� ���� ����
		id = "testqa05";
		idDomain = "infraware.co.kr";
		pw = "infra12";
		
		//Email ���� ����
		eId = "waresys";
		eDomain = "gmail.com";
		
		//���� ID ����
		sBookId = "PB12039160";
				
		driver = new FirefoxDriver();
		//driver = new InternetExplorerDriver();
		
		//�ȶ�� ���� �� ������ ����
		baseUrl = "http://twww.palaoo.com/pgm/goods/productDetail.jsp?contID=";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

	}
		
		
	@Test
	public void testPresentBookEmail() throws Exception {
		
		//�ȶ�� �α���
		driver.get("Http://twww.palaoo.com");
		driver.findElement(By.linkText("�α���")).click();
		driver.findElement(By.id("emailName")).sendKeys(id);
		driver.findElement(By.id("email_domain")).sendKeys(idDomain);
		driver.findElement(By.id("passwd")).sendKeys(pw);
		driver.findElement(By.id("joinBtn")).click();
		
		//�α��� �˾� ���â ����
		driver.switchTo().alert().accept();
		sleep(2);
		
		

		//���� ���� ����(���� �� ������ ����)
		driver.get(baseUrl + sBookId);
		sleep(1);

		//���� �� ������ �����ϱ� ����
		driver.findElement(By.cssSelector("img[alt=\"�����ϱ�\"]")).click();
		sleep(2);
		
		//Select �ڽ����� �̸��� ����
		driver.findElement(By.cssSelector("span.jquery-selectbox-iptL-currentItem")).click();
		driver.findElement(By.xpath("//div[@id='contents']/div[2]/div[3]/div/table[2]/tbody/tr/td/ul/li/div/div[2]/span[2]")).click();
		sleep(1);
		
		//���� ������ ���� �Է�
		driver.findElement(By.id("receiveEmail1")).sendKeys(eId);
		driver.findElement(By.id("receiveEmail2")).sendKeys(eDomain);
		driver.findElement(By.id("receiveName")).sendKeys("�׽�Ʈ");
		driver.findElement(By.id("sendSubject")).sendKeys("����");
		driver.findElement(By.id("sendContent")).sendKeys("�޼�������");
		sleep(1);
		
		//�ֹ��ϱ� ����
		driver.findElement(By.cssSelector("img[alt=\"�ֹ��ϱ�\"]")).click();
		sleep(2);
		
		//���� ��� �Է� �� ����(ĳ�����)
		driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div[3]/div/div[2]/div[2]/div[1]/dl/dd/span/span/img")).click();
		sleep(2);
		
		//�����ϱ� ����
		driver.findElement(By.cssSelector("img[alt=\"�����ϱ�\"]")).click();
		sleep(2);
		
		
		//�˾� ���â ����
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