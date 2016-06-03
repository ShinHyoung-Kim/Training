import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;
 
public class GoogleSearch extends SeleneseTestCase{
 
// @SuppressWarnings("deprecation")
 @Before
 public void setUp() throws Exception {
  WebDriver driver;	 
  String baseUrl = "http://zum.com";
  //Make up DefaultSelenium
  driver = new FirefoxDriver();
//  selenium = new WebDriverBackedSelenium(driver, baseUrl);
  //selenium = new DefaultSelenium("localhost", 4444, "*firefox", baseUrl);
  //Selenium Control window is opened
  selenium.start();
 }
 
 @After
 public void tearDown() throws Exception {
  //Browser is cloesed
 // selenium.close();
  //Selenium Control window is closed
 // selenium.stop();
 }
 
 @SuppressWarnings("deprecation")
 @Test
 public void testGoogleSearch() throws InterruptedException {
  //URL is opened 
  selenium.open("http://www.google.com");
  //Thread waits loading
  for (int second = 0;; second++) {
   if (second >= 60) fail("timeout");
   try { if (selenium.isVisible("xpath=//form[@id='gbqf']/fieldset/div/div/div/table//input")) break; } catch (Exception e) {}
   //Thread pauses 1000ms
   Thread.sleep(1000);
  }
  //Keyword is entered in search box
  selenium.type("xpath=//form[@id='gbqf']/fieldset/div/div/div/table//input", "È£¶ûÀÌ±â¿î");
  //Enter key is pressed
  selenium.keyPress("xpath=//form[@id='gbqf']/fieldset/div/div/div/table//input", "\\13");
  //Thread waits loading
  for (int second = 0;; second++) {
   if (second >= 60) fail("timeout");
   try { 
    if (selenium.isVisible("xpath=//div[@id='main']//div[@id='search']/div/ol/li/div/h3")) {
     break; 
    }
   }catch (Exception e) {}
   //Thread pauses 1000ms
   Thread.sleep(1000);
  }
  //Number of searching results is stored at variable
  int  num = selenium.getXpathCount("//div[@id='main']//div[@id='search']/div/ol/li/div/h3").intValue();
  //Title of results show
  for(int i = 1;num > 0 ; i++){
   try{
   System.out.println(i + "__" + selenium.getText("xpath=//div[@id='main']//div[@id='search']/div/ol/li[" + i + "]/div/h3"));
   num--;
   }catch(Exception e){    
   }
  }
 }
 
}
