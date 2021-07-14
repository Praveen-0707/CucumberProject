package cucumber.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import cucumber.base.CucumberBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomeLoanPage extends CucumberBaseClass {
	
//	public HomeLoanPage(Properties prop)
//	{
//		this.prop = prop;
//	}
	
	public void initProperty() throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
		prop = new Properties();
		prop.load(fis);
	}
	
	@Given("launch homeloan calculation tool")
	public void launcApp() throws IOException
	{
		initProperty();
		driver.get(prop.getProperty("url"));
	}
	
}
