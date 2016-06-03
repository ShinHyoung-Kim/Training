import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AdminTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception{
		driver = new FirefoxDriver();
		baseUrl = "http://tadmin.palaoo.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test
	public void testAdminTest() throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.xpath(".//*[@id='uid']")).clear();
		driver.findElement(By.xpath(".//*[@id='uid']")).sendKeys("admin");
		driver.findElement(By.id("upass")).clear();
		driver.findElement(By.id("upass")).sendKeys("vkffkdn12!");
		driver.findElement(By.xpath(".//*[@id='admin_form']/dl/dd[3]/a/img")).click();
		sleep(2);
		driver.switchTo().frame("menu");
		driver.findElement(By.xpath(".//*[@id='s4']/li/a")).click();
		sleep(2);	
		driver.switchTo().defaultContent();
		driver.switchTo().frame("top");
		driver.findElement(By.xpath(".//*[@id='gnb']/ul/li[4]/a")).click(); //사이트관리
		sleep(2);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menu");
		driver.findElement(By.linkText("- FAQ")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
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
		driver.quit();
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
