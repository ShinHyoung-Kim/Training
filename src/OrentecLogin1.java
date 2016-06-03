import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

import com.thoughtworks.selenium.SeleneseTestCase;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriverBackedSelenium;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import java.util.regex.Pattern;




public class OrentecLogin1  {
	DefaultSelenium selenium;
  @Before

  public void setUp() throws Exception {
	  selenium = new DefaultSelenium("localhost", 5555, "*iexplore", "http://orentec.co.kr");
	  selenium.start();
	  selenium.setTimeout("3000");
	  //String baseUrl = "http://orentec.co.kr";
	  /*WebDriver driver = new FirefoxDriver();

  

   selenium = new WebDriverBackedSelenium(driver, baseUrl);
*/
  }




  @Test

  public void testOrentecLogin1() throws Exception {

   selenium.open("");

   selenium.type("name=id", "lopi113");

   selenium.type("name=pwd", "sd1216");

   selenium.click("css=input[type=\"image\"]");

   //  assertTrue(selenium.isTextPresent("김산"));

   selenium.waitForPageToLoad("50000");

  // assertEquals("====== 오렌지 미디어 ======", selenium.getTitle());

   selenium.click("//tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/a/img");

   selenium.waitForPageToLoad("30000");

   selenium.click("//a[3]/img");

   selenium.waitForPageToLoad("30000");

   selenium.click("//tr[3]/td[2]/a/font");

   selenium.waitForPageToLoad("30000");

 //  assertTrue(selenium.isTextPresent("운영자"));

  

  }




  @After

  public void tearDown() throws Exception {

   selenium.stop();

  }

}