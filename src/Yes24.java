import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.LALOAD;
import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.fail;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.selenesedriver.SendKeys;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

public class Yes24 {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	String[] str = new String[5000];

	@Before
	public void setUp() throws Exception{
		FileReader fr = null;
		Scanner sc = new Scanner(new File("pid5000.txt"));
		while(sc.hasNextLine()){
			for(int i=0;i< str.length; ++i){
				str[i] = sc.nextLine();
				System.out.println("str["+ i+"] :"+ str[i]);
			}
		}
	   
 // System.setProperty("webdriver.chorme.driver", "C://Selenium/chromedriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://twww.palaoo.com/pgm/goods/productDetail.jsp?contID=";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
 
 

	@Test
	public void testPointWeb1() throws IOException {	 

		String jekong;  
		driver.get("http://twww.palaoo.com");
	/*	driver.findElement(By.linkText("·Î±×ÀÎ")).click();
		driver.findElement(By.id("emailName")).clear();
		driver.findElement(By.id("emailName")).sendKeys("testqa02");
		driver.findElement(By.id("email_domain")).clear();
		driver.findElement(By.id("email_domain")).sendKeys("infraware.co.kr");
		driver.findElement(By.id("passwd")).clear();
		driver.findElement(By.id("passwd")).sendKeys("bookspalaoo");
		driver.findElement(By.cssSelector("img.ml5.vm")).click();
*/
		sleep(2);
  

  
		for(int i=0;i<str.length; ++i){
			driver.get(baseUrl+ str[i]);
			sleep(2);
			captureScreen();
			sleep(2);
			jekong=driver.findElement(By.xpath(".//*[@id='contents']/div/div[2]/div[1]/div[1]")).getText();
			System.out.println((i+1)+" : " + jekong);
			writen(str.length+jekong);
			jekong = null;
			sleep(2);	   
			}
   		}
   
	private void writen(String reMgs) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Result.txt", true));
		bw.write(reMgs + "\r\n");
		bw.close();
		
		}

	private void sleep(int sec) {
     try {
         Thread.sleep(sec*1000);
     } catch (InterruptedException e) {
         e.printStackTrace();
       }
   }
	
	public void captureScreen(){
		String path;
		
		try {
	//		WebDriver agumentedDriver = new Augmenter().augment(driver);
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			path = "D:/Download/screenShots/" + source.getName() ;
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {

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
