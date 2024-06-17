package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocwen.framework.Status;

import businesscomponents.CommonFunctions;
import supportlibraries.ScriptHelper;

public class Investor_Rules_Manager_Page extends MasterPage{
	
	private static WebElement element = null;
    CommonFunctions CF = new CommonFunctions(scriptHelper);
   
    //WebDriverWait wait = new WebDriverWait(driver, 50);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
    
    public Investor_Rules_Manager_Page(ScriptHelper scriptHelper)
	{
		super(scriptHelper);			
	}
  
	// Below are the declarations  of xpath	of SSRS application
	public static By irmmsp_search = By.xpath("(//*[contains(text(), 'Search')])[1]");
	public static By irmmsp_searchtype_drpdwn	= By.xpath("//*[@id='searchType']");
	public static By irmmsp_investorid_drpdwn	= By.xpath("//*[@id='searchType']/option[2]");
	public static By irmmsp_search_txtbox	= By.xpath("//*[@id='asyncSelected']");
	public static By irmmsp_go_button	= By.xpath("//*[@class='btn btn-primary']");
	public static By irmmsp_srchresults = By.xpath("//*[contains(text(), 'Investor Rules MSP Update Utility')]");
	public static By irmmsp_globalrule_link	= By.xpath("//*[contains(text(), 'Global Rules')]");
	public static By irmmsp_modificationrule_link	= By.xpath("//*[contains(text(), 'Modification Rules')]");
	public static By irmmsp_deedinlieu_link = By.xpath("//*[contains(text(), 'Deed-In-Lieu-Rules')]");
	public static By irmmsp_forbearancerules_link	= By.xpath("//*[contains(text(), 'Forbearance Rules')]");
	public static By irmmsp_shortsalerule_link = By.xpath("//*[contains(text(), 'Short Sale Rules')]");
	
	public Investor_Rules_Manager_Page irmmsp_validate() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(irmmsp_search)));
		report.updateTestLog("Home Page", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Home Page", "Home Page", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(irmmsp_searchtype_drpdwn)));
		CF.clickOnElement(irmmsp_searchtype_drpdwn, "Click on Search Dropdwn", "Link", "Pass");
		report.updateTestLog("Search Dropdwn", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Search Dropdwn", "Search Dropdwn", Status.PASS);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(irmmsp_investorid_drpdwn)));
		CF.clickOnElement(irmmsp_investorid_drpdwn, "Select Investor Id", "Link", "Pass");
		report.updateTestLog("Select Investor Id", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Select Investor Id", "Investor Id Selected", Status.PASS);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(irmmsp_search_txtbox)));
		CF.clickOnElement(irmmsp_search_txtbox, "Click on Fraud", "Link", "Pass");
		String investor_id = dataTable.getData("General_Data", "Investor_id");
		driver.findElement(irmmsp_search_txtbox).sendKeys(investor_id);
		report.updateTestLog("Investor Id Updated", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Investor Id Updated", "1,FNMA Option Selected", Status.PASS);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(irmmsp_go_button)));
		CF.clickOnElement(irmmsp_go_button, "Click on Search", "Link", "Pass");
		report.updateTestLog("Go Button", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Go Button", "Click on Go Button", Status.PASS);
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(irmmsp_srchresults)));
		report.updateTestLog("Investor Rules MSP Search Results", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FInvestor Rules MSP Search Results", "Investor Rules MSP Results", Status.PASS);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(irmmsp_globalrule_link)));
		CF.clickOnElement(irmmsp_globalrule_link, "Click on Global Rules", "Link", "Pass");
		report.updateTestLog("Global Rules Link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Global Rules Link", "Click on Global Rules Link", Status.PASS);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(irmmsp_modificationrule_link)));
		CF.clickOnElement(irmmsp_modificationrule_link, "Click on Modification Rules", "Link", "Pass");
		report.updateTestLog("Modification Rules Link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Modification Rules Link", "Click on Modification Rules Link", Status.PASS);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(irmmsp_deedinlieu_link)));
		CF.clickOnElement(irmmsp_deedinlieu_link, "Click on Deed-In-Lieu-Rules", "Link", "Pass");
		report.updateTestLog("Deed-In-Lieu-Rules Link ", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Deed-In-Lieu-Rules Link", "Click on Deed-In-Lieu-Rules Link", Status.PASS);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(irmmsp_forbearancerules_link)));
		CF.clickOnElement(irmmsp_forbearancerules_link, "Click on Forbearance Rules", "Link", "Pass");
		report.updateTestLog("Forbearance Rules Link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Forbearance Rules Link", "Click on Forbearance Rules Link", Status.PASS);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(irmmsp_shortsalerule_link)));
		CF.clickOnElement(irmmsp_shortsalerule_link, "Click on Short Sale Rules", "Link", "Pass");
		report.updateTestLog("Short Sale Rules Link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Short Sale Rules Link", "Short Sale Search Results", Status.PASS);
		
		report.consolidateScreenshotsInWordDoc();
		
		return new Investor_Rules_Manager_Page(scriptHelper);
	
	}

}
