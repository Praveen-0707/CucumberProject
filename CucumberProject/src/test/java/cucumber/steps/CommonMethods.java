package cucumber.steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.base.CucumberBaseClass;

public class CommonMethods extends CucumberBaseClass {
	
	@Given("Application Type is Single")
	public void application_Type_is() {
	    wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//input[@id='application_type_single']/.."))).click();
	}

	@Given("Applicant has {string} dependants")
	public void applicant_has_dependants(String val) {
	    Select option = new Select(driver.findElementByXPath("//select[@title='Number of dependants']"));
	    option.selectByVisibleText(val);
	}

	@Given("Property to buy is Home to live in")
	public void property_to_buy_is(String string) {
		WebElement ele = driver.findElementByXPath("//input[@id='borrow_type_home']/parent::label");
	    wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	}

	@Given("Applicant has {string} as {string}")
	public void applicant_has_as(String locatorValue, String amount) {
	    WebElement ele = driver.findElementByXPath("//label[contains(text(),'"+locatorValue+"')]/..//input[@type='text']");
	    wait.until(ExpectedConditions.elementToBeClickable(ele)).sendKeys(amount);
	}

	@Then("Click on calculate BorrowEstimate button")
	public void click_on_calculate_BorrowEstimate_button() {
	    driver.findElementById("btnBorrowCalculater").click();
	}
	
	@Then("click on start over button to reset values")
	public void click_on_startOver() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button[@class='start-over']"))).click();
	}
	
	@When("verify if estimate is {string}")
	public void verify_if_estimate_is(String inputVal) {
		WebElement ele = driver.findElementById("borrowResultTextAmount");
		String estimateBorrowAmt = ele.getText();
		String strVal = estimateBorrowAmt.replaceAll("\\D", "");
		if (strVal.contains(inputVal))
		{
			System.out.println("Estimate Matches: "+inputVal);
		}
		else
		{
			System.out.println("Estimate not matched: "+strVal);
		}
	}
	
	@When("verify estimate error response on submit")
	public void verify_estimate_error() {
		WebElement ele = driver.findElementByClassName("borrow__error__text");
		String errMsg = ele.getText();
		if (errMsg.contains("we're unable to give you an estimate"))
		{
			System.out.println("Error Response Validated");
		}
		else
		{
			System.out.println("Unable to validate the Error Response");
		}
	}
}
