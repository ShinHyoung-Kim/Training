import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;


public class Screenshot {
	private WebDriver driver;
	
	public void captureScreen(String filename){
		String path;
		
		try {
			WebDriver agumentedDriver = new Augmenter().augment(driver);
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			path = "D:/Download/screenShots/" + filename + ".png" ;
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
