import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.LALOAD;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.selenesedriver.SendKeys;
import org.openqa.selenium.support.ui.Select;

public class PointWeb1 {
 private WebDriver driver;
 private String baseUrl;
 private StringBuffer verificationErrors = new StringBuffer();


 @Before
public void setUp() throws Exception{
 // System.setProperty("webdriver.chorme.driver", "C://Selenium/chromedriver.exe");
  driver = new InternetExplorerDriver();
  baseUrl = "http://twww.palaoo.com/pgm/goods/productDetail.jsp?contID=";
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
 
 

 @Test
 public void testPointWeb1() throws IOException {
  
  driver.get("http://twww.palaoo.com" + "/pkm/index.jsp");
  driver.findElement(By.linkText("로그인")).click();
  driver.findElement(By.id("emailName")).clear();
  driver.findElement(By.id("emailName")).sendKeys("testqa09");
  driver.findElement(By.id("email_domain")).clear();
  driver.findElement(By.id("email_domain")).sendKeys("infraware.co.kr");
  driver.findElement(By.id("passwd")).clear();
  driver.findElement(By.id("passwd")).sendKeys("infra12");
  driver.findElement(By.cssSelector("img.ml5.vm")).click();
  driver.findElement(By.linkText("이북몰")).click(); 
  
  FileReader fr = null;
  String[] str = new String[5];
  Scanner sc = new Scanner(new File("pid.txt"));
  
   while(sc.hasNextLine()){
   for(int i=0;i< str.length; ++i){
    str[i] = sc.nextLine();
    System.out.println("str["+ i+"] :"+ str[i]);
   }
   
  
   for(int i=0;i<str.length; ++i){
	   
       String bookTitle_01 = null, bookTitle_02=null;
   	   driver.get(baseUrl+ str[0]);
	   sleep(2);
	   bookTitle_01=driver.findElement(By.cssSelector("h2.booktitle")).getText().trim();
	   System.out.println(bookTitle_01);
	   sleep(1);
	   driver.findElement(By.cssSelector("img[alt=\"바로구매\"]")).click();
	   sleep(1);
	   driver.findElement(By.name("cashAllUse"));
	   driver.findElement(By.cssSelector("span.jquery-checkbox")).click();
	   sleep(1);
	   driver.findElement(By.cssSelector("img[alt=\"결제하기\"]")).click();
	   sleep(1);
	   driver.switchTo().alert().accept();
	   sleep(1);
	   driver.findElement(By.cssSelector("img[alt=\"내서재 바로가기\"]")).click();
	   driver.findElement(By.id("bookListBody")); //grab table
	   bookTitle_02=driver.findElement(By.xpath("//tr[1]/td[3]")).getText();
	   System.out.println(bookTitle_02);
	   //System.out.println(bookTitle_01.getBytes());
	   //System.out.println(bookTitle_02.getBytes());
	  /* bookTitle_01 = bookTitle_01.trim();
	   bookTitle_02 = bookTitle_02.trim();*/
	   if (bookTitle_01.trim().equals(bookTitle_02.trim())){
	   System.out.println("검색결과가 동일합니다.");
	   } else {
		   System.out.println("검색결과가 다릅니다.");
	   }
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
   /*String verificationErrorString = verificationErrors.toString();
   if (!"".equals(verificationErrorString)) {
     fail(verificationErrorString);
   }*/
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
