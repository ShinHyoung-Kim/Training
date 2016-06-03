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
	 * 각 항목별 입력값*/
	String sBookName; //상품명
	String sBookSubName; // 부제목
	String sBookType[] = { "0001", "0002", "0003", "0004", "0005", "0006" }; //제작형태 { 01-Text / 02-Premium / 03-Image / 04-Comics / 05-Flash / 06-기타 }
	String sSellState[] = { "01", "02", "03", "04", "05", "06", "07" }; //판매구분 { 01-판매대기 / 02-판매중 / 03-판매중지 /04-계약만료 / 05-보류 / 06-세트 / 07-이벤트 }
	String sAlliMember; //제휴/수집담당
	
	String sPaperBookIsbn01, sPaperBookIsbn02; //종이책 ISBN
	String sPaperBookRels; //종이책 출판일자
	String sPaperBookPrice; //종이책 가격
	String sEBookIsbn01, sEBookIsbn02; //전자책 ISBN
	String sEBookRels; //전자책 출판일자
	String sEBookPrice; //종이책 가격
	
	String sPriceApplyDate; //가격관리 - 가격적용일
	String sPriceSaleAmount; //가격관리 - 판매가격
	String sPriceOriAmount; //가격관리 - 할인전가격
	
	String sSeriseName; //총서명(시리즈명)
	String sSeriseNo; //총서번호(시리즈번호)
	
	String sExSeriseNo; //기존시리즈에 추가 - 시리즈번호
	String sExSeriseName; //기존시리즈에 추가 - 시리즈명
	
	String sBookIntro; //책소개
	String sBoorWriter01, sBoorWriter02; //저자
	String sBookTranslator01, sBookTranslator02; //역자
	String sBookEditor01, sBookEditor02; //편집
	String sBookIllustrator01, sBookIllustrator02; //그림
	String sBookCompile01, sBookCompile02; //편저
	String sBookSupervise01, sBookSupervise02; //감수
	
	String sBookContList; //목차
	
	String sBookInside; //책속으로
	
	String sBookPublReview; //출판사서평
	
	String sB2CSaleStartDate; //단권판매 시작일
	String sB2CSaleEndDate; //단권판매 종료일
	String sB2CSaleB2CPer; //단권판매 B2C 퍼센트
	String sB2CSaleB2BPer; //단권판매 B2B 퍼센트
	String sB2CSaleRePer; //단권판매 재판매 퍼센트
	String sB2CMemo; //단권판매 메모
	
	String sMallType[] = {"mall_type1", "mall_type2", "mall_type3"}; //판매처구분 { 팔라우이북, 팔라우키즈, KINDER }

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
	
	//로그인
	driver.findElement(By.id("uid")).click();
	driver.findElement(By.id("uid")).sendKeys("admin");
	driver.findElement(By.id("upass")).click();
	driver.findElement(By.id("upass")).sendKeys("vkffkdn12!");
		  
	driver.findElement(By.className("btn")).submit();
	sleep(1);
	
	//도서 등록 메뉴 이동
	driver.switchTo().defaultContent();
	driver.switchTo().frame("top");
	driver.findElement(By.xpath("//div[@id='gnb']/ul/li[2]/a")).click(); //계약/컨덴츠관리 선택
	sleep(1);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("menu");
	driver.findElement(By.xpath("//*[@id='s3']/li[3]/a")).click(); //도서관리 선택
	sleep(1);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("main");
	driver.findElement(By.xpath("//div[@id='container']/div/div[2]/a[2]/span/em")).click();; //신규등록 선택
	sleep(1);
	
	//도서 Data 입력
	driver.switchTo().defaultContent();
	driver.switchTo().frame("main");
	sleep(1);
	
	driver.findElement(By.cssSelector("em")).click(); //계약권자 찾기 선택
	
	//계약권자 찾기 새창 제어 시작
	Set <String> handles =driver.getWindowHandles();
	Iterator<String> it = handles.iterator();
        
	while (it.hasNext())
		{
		String parent = it.next();
		String newwin = it.next();
		driver.switchTo().window(newwin);
		
		 new Select(driver.findElement(By.id("s_kind"))).selectByVisibleText("계약권자코드");
    	driver.findElement(By.id("s_value")).sendKeys("0063");
    	driver.findElement(By.cssSelector("em")).click();
    	driver.findElement(By.id("yn")).click();
    	driver.findElement(By.xpath("//div[2]/a/span/em")).click();
		//driver.close();
		driver.switchTo().window(parent);
		}
	//계약권자 찾기 새창 제어 종료
	
	driver.switchTo().defaultContent();
	driver.switchTo().frame("main");
		
	driver.findElement(By.id("paper_amt")).sendKeys("12000"); //종이책 가격 입력
	driver.findElement(By.id("cont_sing_nm")).sendKeys("테스트시리즈"); //총서명(시리즈명)입력
	
	driver.findElement(By.xpath(".//*[@id='seri_yn'][1]")).click();
	sleep(5);
	//driver.findElement(By.xpath(".//*[@id='seri_yn'][2]")).click();
	//driver.findElement(By.xpath(".//*[@id='seri_new_old'][1]")).click();
	
	
	//이미지 업로드 - Ebook1
	driver.findElement(By.xpath(".//*[@id='goodsForm']/div/p[34]/a[1]/span/em")).click();
		//새창 제어 시작
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
	    //새창 제어 종료
	//이미지 업로드 종료   
	
    driver.switchTo().defaultContent();
    driver.switchTo().frame("main");

	driver.findElement(By.id("mall_type1")).click(); //체크박스 선택
	
	new Select(driver.findElement(By.id("gds_llf"))).selectByValue("0003"); //도서 메인 가테고리 선택
	
	
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