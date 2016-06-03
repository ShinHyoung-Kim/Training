import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import java.util.regex.Pattern;

public class Login_RC {
	DefaultSelenium selenium ;
	private void captureScreenshot(Throwable t) throws Throwable{
		if(selenium != null){
			String filename = this.getClass().getName() + ".png";
			
			try
			{
				selenium.captureScreenshot(filename);
			
			System.out.println("Savee screenshot" + filename + "for" + t.toString());
			}catch(Exception e){
				System.err.println("Savee screenshot" + filename + "for"
						+ t.toString()+ ":"+ e.toString());
				e.printStackTrace();
			}
			throw t;
		}
	}
	@Before
	public void setUp() throws Exception {
		
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.palaoo.com/");
		selenium.start();
	}

	@Test
	public void testLogin_RC() throws Exception {
		selenium.open("/pkm/index.jsp");
		selenium.click("link=로그인");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=emailName", "testqa06");
		selenium.type("id=email_domain", "infraware.co.kr");
		selenium.type("id=passwd", "infra12");
		selenium.click("css=img.ml5.vm");
		
		assertTrue(selenium.isTextPresent("방가 방가"));
		selenium.waitForPageToLoad("30000");
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}

	@Test
	public void testLogin_RCOnErrSaveScreen() throws Throwable {
		try{
		this.testLogin_RC();
		}catch(Throwable t){
			this.captureScreenshot(t);
		}
	}
}
