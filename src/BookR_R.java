import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.lang.String;


import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import static org.junit.Assert.*;


public class BookR_R{
	
	private static WebDriver driver;
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	/*
	 * �� �׸� �Է°�*/
	String sBookName; //��ǰ��
	String sBookSubName; // ������
	String sBookType[] = { "0001", "0002", "0003", "0004", "0005", "0006" }; //�������� { 01-Text / 02-Premium / 03-Image / 04-Comics / 05-Flash / 06-��Ÿ }
	String sSellState[] = { "01", "02", "03", "04", "05", "06", "07" }; //�Ǹű��� { 01-�ǸŴ�� / 02-�Ǹ��� / 03-�Ǹ����� /04-��ุ�� / 05-���� / 06-��Ʈ / 07-�̺�Ʈ }
	String sAlliMember; //����/�������
	
	String sPaperBookIsbn01, sPaperBookIsbn02; //����å ISBN
	String sPaperBookRels; //����å ��������
	String sPaperBookPrice; //����å ����
	String sEBookIsbn01, sEBookIsbn02; //����å ISBN
	String sEBookRels; //����å ��������
	String sEBookPrice; //����å ����
	
	String sPriceApplyDate; //���ݰ��� - ����������
	String sPriceSaleAmount; //���ݰ��� - �ǸŰ���
	String sPriceOriAmount; //���ݰ��� - ����������
	
	String sSeriseName; //�Ѽ���(�ø����)
	String sSeriseNo; //�Ѽ���ȣ(�ø����ȣ)
	
	String sExSeriseNo; //�����ø�� �߰� - �ø����ȣ
	String sExSeriseName; //�����ø�� �߰� - �ø����
	
	String sBookIntro; //å�Ұ�
	String sBoorWriter01, sBoorWriter02; //����
	String sBookTranslator01, sBookTranslator02; //����
	String sBookEditor01, sBookEditor02; //����
	String sBookIllustrator01, sBookIllustrator02; //�׸�
	String sBookCompile01, sBookCompile02; //����
	String sBookSupervise01, sBookSupervise02; //����
	
	String sBookContList; //����
	
	String sBookInside; //å������
	
	String sBookPublReview; //���ǻ缭��
	
	String sB2CSaleStartDate; //�ܱ��Ǹ� ������
	String sB2CSaleEndDate; //�ܱ��Ǹ� ������
	String sB2CSaleB2CPer; //�ܱ��Ǹ� B2C �ۼ�Ʈ
	String sB2CSaleB2BPer; //�ܱ��Ǹ� B2B �ۼ�Ʈ
	String sB2CSaleRePer; //�ܱ��Ǹ� ���Ǹ� �ۼ�Ʈ
	String sB2CMemo; //�ܱ��Ǹ� �޸�
	
	String sMallType[] = {"mall_type1", "mall_type2", "mall_type3"}; //�Ǹ�ó���� { �ȶ���̺�, �ȶ��Ű��, KINDER }

	@BeforeClass
	public static void setUp() throws Exception
	{ 
	driver = new FirefoxDriver();
	baseUrl = "http://tadmin.palaoo.com/";
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void regBook() throws Exception
	{	
	driver.get(baseUrl);
	
	//�α���
	driver.findElement(By.id("uid")).click();
	driver.findElement(By.id("uid")).sendKeys("admin");
	driver.findElement(By.id("upass")).click();
	driver.findElement(By.id("upass")).sendKeys("vkffkdn12!");
		  
	driver.findElement(By.className("btn")).submit();
	sleep(1);
	
	//���� ��� �޴� �̵�
	driver.switchTo().defaultContent();
	driver.switchTo().frame("top");
	driver.findElement(By.xpath("//div[@id='gnb']/ul/li[2]/a")).click(); //���/���������� ����
	sleep(1);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("menu");
	driver.findElement(By.xpath("//*[@id='s3']/li[3]/a")).click(); //�������� ����
	sleep(1);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("main");
	driver.findElement(By.xpath("//div[@id='container']/div/div[2]/a[2]/span/em")).click();; //�űԵ�� ����
	sleep(1);
	
	//���� Data �Է�
	driver.switchTo().defaultContent();
	driver.switchTo().frame("main");
	sleep(1);
	
	driver.findElement(By.cssSelector("em")).click(); //������ ã�� ����
	
	//������ ã�� ��â ���� ����
	Set <String> handles =driver.getWindowHandles();
	Iterator<String> it = handles.iterator();
        
	while (it.hasNext())
		{
		String parent = it.next();
		String newwin = it.next();
		driver.switchTo().window(newwin);
		
		 new Select(driver.findElement(By.id("s_kind"))).selectByVisibleText("�������ڵ�");
    	driver.findElement(By.id("s_value")).sendKeys("0063");
    	driver.findElement(By.cssSelector("em")).click();
    	driver.findElement(By.id("yn")).click();
    	driver.findElement(By.xpath("//div[2]/a/span/em")).click();
		//driver.close();
		driver.switchTo().window(parent);
		}
	//������ ã�� ��â ���� ����
	
	driver.switchTo().defaultContent();
	driver.switchTo().frame("main");
		
	driver.findElement(By.id("paper_amt")).sendKeys("12000"); //����å ���� �Է�
	driver.findElement(By.id("cont_sing_nm")).sendKeys("�׽�Ʈ�ø���"); //�Ѽ���(�ø����)�Է�
	
	driver.findElement(By.xpath(".//*[@id='seri_yn'][1]")).click();
	sleep(5);
	//driver.findElement(By.xpath(".//*[@id='seri_yn'][2]")).click();
	//driver.findElement(By.xpath(".//*[@id='seri_new_old'][1]")).click();
	
	
	//�̹��� ���ε� - Ebook1
	driver.findElement(By.xpath(".//*[@id='goodsForm']/div/p[34]/a[1]/span/em")).click();
		//��â ���� ����
		Set <String> ImgUphandles =driver.getWindowHandles();
		Iterator<String> it1 = ImgUphandles.iterator();
	        while (it1.hasNext())
			{
			String iparent = it1.next();
			String nuwin = it1.next();
			driver.switchTo().window(nuwin);
			driver.findElement(By.name("fileup")).sendKeys("C:\\SeleniumPalaoo\\Image\\Sample_E_1.jpg");
			driver.findElement(By.cssSelector("span")).click();
			driver.switchTo().window(iparent);
			}
	    //��â ���� ����
	//�̹��� ���ε� ����   
	
    driver.switchTo().defaultContent();
    driver.switchTo().frame("main");

	driver.findElement(By.id("mall_type1")).click(); //üũ�ڽ� ����
	
	new Select(driver.findElement(By.id("gds_llf"))).selectByValue("0003"); //���� ���� ���װ� ����
	
	
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