

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

public class OldConditionSearch extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new InternetExplorerDriver();
		String baseUrl = "http://tadmin.palaoo.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testOldConditionSearch() throws Exception {
		selenium.open("/_aocstp/index.jsp");
		selenium.type("id=uid", "admin");
		selenium.type("id=upass", "vkffkdn12!");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("top");
		selenium.click("link=����Ʈ����");
		selenium.selectFrame("relative=up");
		selenium.selectFrame("main");
		selenium.click("xpath=(//input[@id='s_beopen'])[3]");
		selenium.select("id=s_kind", "label=����");
		selenium.type("id=s_value", "��");
		selenium.click("css=em");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		//selenium.stop();
	}
}
