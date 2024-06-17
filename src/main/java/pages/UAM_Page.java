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

public class UAM_Page extends MasterPage{
	
	private static WebElement element = null;
	CommonFunctions CF = new CommonFunctions(scriptHelper);
   
    //WebDriverWait wait = new WebDriverWait(driver, 50);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(5));
    public UAM_Page(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		
		
	}
    
 // Below are the declarations  of xpath	of SSRS application
 	public static By search_user = By.xpath("//*[contains(text(), 'Search User')]");
 	public static By search_type	= By.xpath("//*[contains(text(), 'Search Type')]");
 	public static By searchtype_dropdown	= By.xpath("//*[@id='txtSearchType']");
 	public static By searchtype_dropdown_1	= By.xpath("//*[@id='txtSearchType']/option[2]");
 	public static By searchtype_dropdown_2	= By.xpath("//*[@id='txtSearchType']/option[3]");
 	public static By fusionid_txtbox = By.xpath("//*[@id='InputFusionNetworkID']");
 	public static  By viewonline_btn = By.xpath("//*[@id='btnViewOnline']");
 	public static  By employeid_column = By.xpath("//*[@id='jqgh_positionChangeGrdBatches_EMPL_ID']");
 	public static  By fusionid_column = By.xpath("//*[@id='jqgh_terminationGrdBatches_EMPL_ID']");

    
    public UAM_Page UAM_Validation() throws InterruptedException, InvalidFormatException
	{
			
		wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(search_user)));
		report.updateTestLog("Search User link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("earch User link", "Presence of Link", Status.PASS);
		
		CF.clickOnElement(search_user, "Clicked Search User", "Link", "Pass");
		report.updateTestLog("Search User link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Search User link", "Clicked on Link", Status.PASS);
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(search_type)));
		report.updateTestLog("Search Type Label", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Search Type Label", "Presence of Search Type Label", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchtype_dropdown)));
		CF.clickOnElement(searchtype_dropdown, "Search Type Dropdown", "Dropdown", "Pass");
		CF.clickOnElement(searchtype_dropdown_1, "Select Position Dropdown", "Dropdown", "Pass");
		//CF.selectValueFromDropDown(searchtype_dropdown_1, "Position Change", "Dropdown", "Pass");
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(fusionid_txtbox)));
		CF.clickOnElement(fusionid_txtbox, "Clicked on Fusion Id Textbox", "Textbox", "Pass");
		String fusion_id = dataTable.getData("General_Data", "Loan Number");
		driver.findElement(fusionid_txtbox).sendKeys(fusion_id);
		report.updateTestLog("Fusion Id Textbox", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Fusion Id Textbox", "Clicked on Fusion Id Textbox", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(viewonline_btn)));
		CF.clickOnElement(viewonline_btn, "View Online", "Button", "Pass");
		report.updateTestLog("View Online Button", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("View Online Button", "Clicked on Button", Status.PASS);
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(employeid_column)));
		report.updateTestLog("Employee Id Column", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Employee Id Column", "Employee Id Results Displayed", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchtype_dropdown)));
		CF.clickOnElement(searchtype_dropdown, "Search Type Dropdown", "Dropdown", "Pass");
		CF.clickOnElement(searchtype_dropdown_2, "Select Termination Dropdown", "Dropdown", "Pass");
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(fusionid_txtbox)));
		CF.clickOnElement(fusionid_txtbox, "Clicked on Fusion Id Textbox", "Textbox", "Pass");
		String fusion_id1 = dataTable.getData("General_Data", "Loan Number");
		driver.findElement(fusionid_txtbox).sendKeys(fusion_id1);
		report.updateTestLog("Fusion Id Textbox", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Fusion Id Textbox", "Clicked on Fusion Id Textbox", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(viewonline_btn)));
		CF.clickOnElement(viewonline_btn, "View Online", "Button", "Pass");
		report.updateTestLog("View Online Button", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("View Online Button", "Clicked on Button", Status.PASS);
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(fusionid_column)));
		report.updateTestLog("Fusion Id Column", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Fusion Id Column", "Fusion Id Results Displayed", Status.PASS);
		
		report.consolidateScreenshotsInWordDoc();
		
		
		return new UAM_Page(scriptHelper);
	
	}
}