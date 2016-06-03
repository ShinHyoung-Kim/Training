import java.net.BindException;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import java.net.ServerSocket;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.thoughtworks.selenium.*;

public class GoogleTest extends SeleneseTestBase {

	public static SeleniumServer server;

	@BeforeSuite
	public void setUp() throws Exception {
		startSeleniumServer();
		setUp("http://www.google.com/", "*chrome");
	}
	
	@DataProvider(name = "test1")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "ColdPlay", "coldplay" },
	   { "Oasis", "oasis"},
	   { "Adele", "adele" }
	 };
	}

	@Test(dataProvider = "test1")
	public void searchQueryTest(String b1, String b2) {
	  System.out.println(b1 + " - " + b2);
	  selenium.setTimeout("5000");
	  selenium.open("/");
	  selenium.type("q", b2);
	  selenium.click("btnG");
	  //selenium.waitForPageToLoad("3000");
	  try {
		Thread.sleep(2000);
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
	  assertTrue( selenium.isTextPresent("About * results") );
	}
	
	@Test(dataProvider = "test1")
	public void searchQueryFail(String b1, String b2) {
	  System.out.println(b1 + " - " + b2);
	  selenium.setTimeout("5000");
	  selenium.open("/");
	  selenium.type("q", "-" + b2);
	  selenium.click("btnG");
	  //selenium.waitForPageToLoad("3000");
	  try {
		Thread.sleep(2000);
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
	  assertTrue( selenium.isTextPresent("did not match") );
	}

	@AfterSuite
	public void tearDown() throws Exception {
		stopSeleniumServer();
		System.out.println("End of tests");
	}


	public void startSeleniumServer() throws Exception {
		try {
			ServerSocket serverSocket = new ServerSocket(RemoteControlConfiguration.DEFAULT_PORT);
			serverSocket.close();
			try { //Server not up, start it
				RemoteControlConfiguration rcc = new RemoteControlConfiguration();
				rcc.setPort(RemoteControlConfiguration.DEFAULT_PORT);
				server = new SeleniumServer(false, rcc);
			} catch (Exception e) {
				System.err.println("Could not create Selenium Server because of: " + e.getMessage());
				e.printStackTrace();
			}
			try {
				server.start();
				System.out.println("Server started");
			} catch (Exception e) {
				System.err.println("Could not start Selenium Server because of: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (BindException e) {
			System.out.println("Selenium server already up, will reuse...");
		}
	}

	public void stopSeleniumServer() {
		selenium.stop();
		if (server != null)
		{
			try	{
				selenium.shutDownSeleniumServer();
				server.stop();
				server = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}