
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

public class InQ_Research_Page extends MasterPage{
	
	private static WebElement element = null;
	CommonFunctions CF = new CommonFunctions(scriptHelper);
   
    //WebDriverWait wait = new WebDriverWait(driver, 50);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(5));
    public InQ_Research_Page(ScriptHelper scriptHelper)
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
	public static By web_home = By.xpath("//*[@id=\"Form1\"]/table/tbody/tr[1]/td/table/tbody/tr[2]/td[3]/a");
	public static By web_Admin = By.xpath("//*[@id=\"masterdiv\"]/table/tbody/tr[1]/td/div/span");
	public static By web_Employee = By.xpath("//*[contains(text(), 'Employee')]");
	public static By web_QualityAssurance = By.xpath("//*[@id=\"masterdiv\"]/table/tbody/tr[2]/td/div/span");
	public static By web_completed_reviews = By.xpath("//*[@id=\"sub2\"]/div[2]/a");
	public static By web_completed_reviews_title = By.xpath("//*[@id='Form1']/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td");
	
	public static By web_citrix = By.xpath("//*[@id=\"pn_main\"]/table/tbody/tr[3]/td[2]/table/tbody/tr[1]/td[1]");
	public static By web_search_btn = By.xpath("//*[@id=\"btn_emp_search\"]");
	public static By web_search_employee = By.xpath("//*[@id=\"dg_search\"]/tbody/tr[2]/td[1]");
	public static By web_close_btn = By.xpath("//*[@id=\"btn_close\"]");
	public static By web_Bussiness_unit_label = By.xpath("//*[@id=\"Form1\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[1]");
	public static By web_Bussiness_unit_dropdown_select2 = By.xpath("//*[@id='ddl_business_unit']/option[1]");
	public static By web_search_btn1 = By.xpath("//*[@id='btn_search']");
	public static By web_results = By.xpath("//*[@id='dg_search']/tbody/tr[2]/td[2]");
	public static By web_bussiness_unit_dropdown = By.xpath("//*[@id='ddl_business_unit']");
		
	
	public InQ_Research_Page inQ_Research_application() throws InterruptedException, InvalidFormatException
	{
						
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_home)));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_Admin)));
		CF.clickOnElement(web_Admin, "Admin", "Link", "Pass");
		Thread.sleep(500);
		report.updateTestLog("Admin", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Admin", "Admin has been verfied", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_Employee)));
		CF.clickOnElement(web_Employee, "Employee", "Link", "Pass");
		Thread.sleep(500);
		report.updateTestLog("Employee", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Employee", "Employee has been verfied", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_citrix)));
		report.updateTestLog("Citrix", "Citrix has been verfied", Status.PASS);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_search_btn)));
		CF.clickOnElement(web_search_btn, "Employee Search", "Button", "Pass");
		Thread.sleep(500);
		report.updateTestLog("Employee Search", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Employee Search", "Employee Search has been verfied", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_search_employee)));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_close_btn)));
		CF.clickOnElement(web_close_btn, "Close Search Employee", "Button", "Pass");
		Thread.sleep(500);
		report.updateTestLog("Employee Search Closed", "Employee Search Closed", Status.PASS);
				
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_QualityAssurance)));
		CF.clickOnElement(web_QualityAssurance, "Quality Assurance", "Link", "Pass");
		report.updateTestLog("Quality Assurance", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Quality Assurance", "Quality Assurance has been verfied", Status.PASS);
				
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_completed_reviews)));
		CF.clickOnElement(web_completed_reviews, "Completed Reviews", "Link", "Pass");
			
		wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_completed_reviews_title)));	
		report.updateTestLog("Completed Reviews Page", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Completed Reviews Page", "Completed Reviews page has been verfied", Status.PASS);		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_Bussiness_unit_label)));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_bussiness_unit_dropdown)));
		//CF.clickOnElement(web_bussiness_unit_dropdown, "Bussiness Unit", "Dropdown", "Pass");
		
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_Bussiness_unit_dropdown_select2)));
		//CF.clickOnElement(web_Bussiness_unit_dropdown_select2, "Research", "Dropdown", "Pass");
		//Thread.sleep(5000);
		
		report.updateTestLog("Research", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Research", "Research has been verfied", Status.PASS);		
		
		
		wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_search_btn1)));
		Thread.sleep(5000);
		wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(web_results)));
		report.updateTestLog("Research Results Displayed", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Research Offshore Results", "Research Results has been verfied", Status.PASS);
			
		report.consolidateScreenshotsInWordDoc();
		
		return new InQ_Research_Page(scriptHelper);
	
	}
}