package cucumber.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.base.CucumberBaseClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberHooks extends CucumberBaseClass {
	
	@Before
	public void launchApp() throws IOException, AWTException
	{
		if (browser.equalsIgnoreCase("Chrome"))
		  {
			  WebDriverManager.chromedriver().setup();
			  chromeOptions = new ChromeOptions();
			  chromeOptions.addArguments("--disable-notifications");
			  driver = new ChromeDriver(chromeOptions);
		  }
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	}
	
	@After
	public void closeBrowser()
	{
		driver.close();
	}
	
}
