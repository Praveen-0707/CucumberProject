package cucumber.base;

import java.util.Properties;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class CucumberBaseClass extends AbstractTestNGCucumberTests {
	
	public static RemoteWebDriver driver;
	public ChromeOptions chromeOptions;
	public FirefoxOptions firefoxOptions;
	public static WebDriverWait wait;
	public String browser = "chrome";
	public Properties prop;
	
	public void solidWait(Integer sec)
	{
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
