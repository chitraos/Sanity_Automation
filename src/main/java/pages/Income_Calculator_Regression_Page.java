package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocwen.framework.Status;

import businesscomponents.CommonFunctions;
import supportlibraries.ScriptHelper;

public class Income_Calculator_Regression_Page extends MasterPage{
	
	private static WebElement element = null;
	CommonFunctions CF = new CommonFunctions(scriptHelper);
   
    //WebDriverWait wait = new WebDriverWait(driver, 50);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(5));
    public Income_Calculator_Regression_Page(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		
		
	}
	// Below are the declarations  of xpath	of SSRS application
	public static By ssrs_qa_reports_enhancement = By.xpath("//*[@id='main']/div/div/section[2]/tiles-view/section/div/div/div/ul/li[2]/folder-tile/rs-tile/a[1]/span[2]/span/span");
	public static By ssrs_completed_review	= By.xpath("//*[@id=\"main\"]/div/div/section[2]/tiles-view/section/div/div/div/ul/li[12]/report-tile/rs-tile/a[1]/span[2]/span/span");
	public static By ssrs_bussiness_unit	= By.xpath("//*[@id='ParametersGridReportViewerControl_ctl04']/tbody/tr[1]/td[1]/label/span");
	public static By ssrs_bussiness_unit_dropdown = By.xpath("//*[@id=\"ReportViewerControl_ctl04_ctl03_txtValue\"]");
	public static  By ssrs_iframe = By.xpath("//*[@id='main']/div/paginated-report-viewer/div/div/div[1]/iframe");
	
	// Below are the declarations  of xpath	of Qa Web application
	public static By incal_home = By.xpath("//*[contains(text(), 'Ocwen Income Calculator')]");
	public static By home_page = By.xpath("//*[@id=\"masterdiv\"]/table/tbody/tr[1]/td/div/span");
	public static By incal_calculation = By.xpath("//*[contains(text(), 'Calculation')]");
	public static By calculation_search = By.xpath("//*[@id='navbar-main']/ul/li[2]/ul/li[1]/a");
	public static By calculation_new = By.xpath("//*[@id='navbar-main']/ul/li[2]/ul/li[2]/a");
	public static By loannumber_textbox = By.xpath("/html/body/div[2]/ui-view/div/div[10]/form/div/input");
	public static By loannumber_txtbox = By.xpath("/html/body/div[2]/ui-view/div/div[9]/div/div[2]/div/div/div[2]/form/div/input");
	
	public static By ok_button = By.xpath("/html/body/div[2]/ui-view/div/div[9]/div/div[2]/div/div/div[2]/form/div/span/button");
	public static By other_Income = By.xpath("//*[contains(text(), 'Other Income')]");
	public static By loannumber_textbox_srch = By.xpath("/html/body/div[2]/ui-view/div/div[10]/form/div/input");
	public static By search_btn = By.xpath("(//*[contains(text(), 'Search')])[2]");
	public static By search_results_link = By.xpath("//*[contains(text(), ' Shantanoo Chitrao ')]");
	public static By other_income_srch = By.xpath("(//*[contains(text(), 'Other Income')])[2]");
	public static By Borrower_textbox = By.xpath("/html/body/div[2]/ui-view/div/div[10]/div[1]/div[2]/div/div/div/div/div/input");
	public static By Income_Type_dropdown = By.xpath("//*[@id='calcList']/div[1]/span");
	public static By Other_income = By.xpath("//*[@id='ui-select-choices-row-0-7']/a/div");
	public static By plus_sign = By.xpath("//*[@id='addValueDropdown']/span/button");
	public static By pay_frequency = By.xpath("//*[@id='payFrequency']");
	public static By pay_frequency_monthly = By.xpath("//*[@id='payFrequency']/option[4]");
	public static By type_radio = By.xpath("//*[@id='adjustments2']");
	public static By other_income_amount = By.xpath("//*[@id='amount']");
	public static By calculate_button = By.xpath("/html/body/div[1]/div/div/div/form/div[1]/div[6]/div[3]/button");
	public static By save_button = By.xpath("/html/body/div[1]/div/div/div/form/div[2]/button[1]");
	public static By submit_button = By.xpath("//*[@id='btnSaveSubmit']/button[2]");
	public static By other_income_amount_srch = By.xpath("(//*[contains(text(), '15,000.00')])[1]");
	public static By income_details_srch = By.xpath("//*[contains(text(), 'Income Details')]");

	
	
	public Income_Calculator_Regression_Page income_calculator_validation() throws InterruptedException, InvalidFormatException
	{					
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(incal_home)));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(incal_calculation)));
		CF.clickOnElement(incal_calculation, "Click on Calculation", "Link", "Pass");
		Thread.sleep(500);
		report.updateTestLog("Calculation Link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Calculation", "Calculation link has been verfied", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(calculation_new)));
		CF.clickOnElement(calculation_new, "Clicked on New Option", "Dropdown", "Pass");
		Thread.sleep(500);
		report.updateTestLog("New", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("New", "Search has been verfied", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loannumber_txtbox)));
		String loannumber = dataTable.getData("General_Data", "Loan Number");
		driver.findElement(loannumber_txtbox).sendKeys(loannumber);
		report.updateTestLog("Loan Number", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Loan Number", "Loan Number Entered", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ok_button)));
		CF.clickOnElement(ok_button, "Click on OK", "Button", "Pass");
		Thread.sleep(5000);
		report.updateTestLog("OK Button", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Ok Button", "Clicked on OK Button", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Borrower_textbox)));
		CF.clickOnElement(Borrower_textbox, "Click on Borrower Textbox", "Textbox", "Pass");
		driver.findElement(Borrower_textbox).sendKeys("Testing");
		report.updateTestLog("Borrower Textbox", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Borrower Textbox", "Borrower Name Updated", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Income_Type_dropdown)));
		CF.clickOnElement(Income_Type_dropdown, "Click on Income Type Dropdown", "Dropdown", "Pass");
		report.updateTestLog("Income Type Dropdown", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Income Type Dropdown", "Clicked on Income Type Dropdown", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Other_income)));
		CF.clickOnElement(Other_income, "Select Othe Income", "Dropdown", "Pass");
		report.updateTestLog("Othe Income Dropdown", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Othe Income Dropdown", "Othe Income Selected", Status.PASS);		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(plus_sign)));
		CF.clickOnElement(plus_sign, "Click on + sign", "Button", "Pass");
		report.updateTestLog("+ sign", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("+ sign", "Clicked on + sign", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(pay_frequency)));
		CF.clickOnElement(pay_frequency, "Click on Pay Frequency", "Dropdown", "Pass");
		report.updateTestLog("Pay Frequency", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Pay Frequency", "Clicked on Pay Frequency Dropdown", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(pay_frequency_monthly)));
		CF.clickOnElement(pay_frequency_monthly, "Click on Monthly", "Button", "Pass");
		report.updateTestLog("Pay Frequency Monthly", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Pay Frequency Monthly", "Month Seleted", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(type_radio)));
		CF.clickOnElement(type_radio, "Click on Taxable", "Radio Button", "Pass");
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(other_income_amount)));
		CF.clickOnElement(other_income_amount, "Click on Other Income Amount", "Textbox", "Pass");
		driver.findElement(other_income_amount).sendKeys("15000");
		report.updateTestLog("Other Income Amount", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Other Income Amount", "Other Income Amount Updated", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(calculate_button)));
		CF.clickOnElement(calculate_button, "Click on Calculate", "Button", "Pass");
		Thread.sleep(8000);
		report.updateTestLog("Calculate Income Amount", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Calculate Income Amount", "Calculated Income Amount", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(save_button)));
		CF.clickOnElement(save_button, "Click on Save", "Button", "Pass");
		Thread.sleep(8000);
		report.updateTestLog("Income Amount Saved", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Income Amount", "Income Amount Saved", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submit_button)));
		CF.clickOnElement(submit_button, "Click on Calculate", "Button", "Pass");
		Thread.sleep(1000);			
		driver.switchTo().alert().accept();
		Thread.sleep(10000);
		report.updateTestLog("Income Submitted", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Income Amount", "Income Amount Submitted", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(incal_calculation)));
		CF.clickOnElement(incal_calculation, "Click on Calculation", "Link", "Pass");
		Thread.sleep(8000);
				
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(calculation_search)));
		CF.clickOnElement(calculation_search, "Clicked on Search Option", "Dropdown", "Pass");
		Thread.sleep(500);
		report.updateTestLog("Search", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Search", "Search has been verfied", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loannumber_textbox_srch)));
		String loannumber1 = dataTable.getData("General_Data", "Loan Number");
		driver.findElement(loannumber_textbox).sendKeys(loannumber1);
		report.updateTestLog("Loan Number", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Loan Number", "Loan Number Entered", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(search_btn)));
		CF.clickOnElement(search_btn, "Click on Search", "Button", "Pass");
		Thread.sleep(8000);
		report.updateTestLog("Loan Number Search", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Loan Number Search", "Loan Number Search has been verfied", Status.PASS);
		
		java.util.List<WebElement> elements = driver.findElements(search_results_link);
		int count = elements.size();
		
		By search_results_link1 = By.xpath("(//*[contains(text(), ' Shantanoo Chitrao ')])["+count+"]");
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(search_results_link1)));
		CF.clickOnElement(search_results_link1, "Click on Latest Search Results", "Link", "Pass");
		Thread.sleep(8000);
		report.updateTestLog("Search Results", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Search Results", "Latest Search Results", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(income_details_srch)));
		CF.clickOnElement(income_details_srch, "Click on Income Details", "Link", "Pass");
		Thread.sleep(8000);
		report.updateTestLog("Income Details", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Income Details", "Income Details", Status.PASS);
				
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(other_income_amount_srch)));		
		report.updateTestLog("Other Income", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Other Income", "Other Income is verified", Status.PASS);
			
		report.consolidateScreenshotsInWordDoc();
		
		return new Income_Calculator_Regression_Page(scriptHelper);
	
	}
}