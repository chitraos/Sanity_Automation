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

public class FCCMS_Page extends MasterPage{
	
	private static WebElement element = null;
    CommonFunctions CF = new CommonFunctions(scriptHelper);
   
    //WebDriverWait wait = new WebDriverWait(driver, 50);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
    
    public FCCMS_Page(ScriptHelper scriptHelper)
	{
		super(scriptHelper);			
	}
  //declaring fluent wait with time out of 30 seconds and frequency is set to 5 seconds  		
	//Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)							
	//.withTimeout(30, TimeUnit.SECONDS) 			
	//.pollingEvery(5, TimeUnit.SECONDS) 			
	//.ignoring(NoSuchElementException.class);

	// Below are the declarations  of xpath	of SSRS application
	public static By fccms_homepage = By.xpath("//*[contains(text(), 'Financial Crimes Case Management System')]");
	public static By fccms_referral_link	= By.xpath("(//*[contains(text(), 'Referral')])[1]");
	public static By fccms_referral_srchresults	= By.xpath("(//*[@class='mat-cell cdk-cell cdk-column-ReferralId mat-column-ReferralId ng-star-inserted'])[1]");
	public static By fccms_fraud_link	= By.xpath("(//*[contains(text(), 'Fraud')])[1]");
	public static By fccms_fraud_search	= By.xpath("(//*[contains(text(), 'Search')])[3]");
	public static By fccms_fraud_srchresults = By.xpath("(//*[@class='mat-cell cdk-cell cdk-column-FraudId mat-column-FraudId ng-star-inserted'])[1]");
	public static By fccms_aml_link	= By.xpath("(//*[contains(text(), 'AML')])[1]");
	public static By fccms_aml_search	= By.xpath("(//*[contains(text(), 'Search')])[3]");
	public static By fccms_aml_srchresults = By.xpath("(//*[@class='mat-cell cdk-cell cdk-column-AmlId mat-column-AmlId ng-star-inserted'])[1]");
	public static By fccms_shortsale_link	= By.xpath("(//*[contains(text(), 'Short Sale')])[1]");
	public static By fccms_shortsale_srchresults = By.xpath("(//*[@class='mat-cell cdk-cell cdk-column-ShortSaleId mat-column-ShortSaleId ng-star-inserted'])[1]");
	
	public FCCMS_Page FCCMS_validate() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fccms_homepage)));
		report.updateTestLog("FCCMS Adminstation Page", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS Adminstation Page", "FCCMS Adminstation Page", Status.PASS);
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(fccms_referral_link)));
		Thread.sleep(2000);
		CF.clickOnElement(fccms_referral_link, "Click on Referral", "Link", "Pass");
		report.updateTestLog("FCCMS Referral Page", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS Referral Page", "FCCMS Referral Page", Status.PASS);
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fccms_referral_srchresults)));
		Thread.sleep(2000);
		report.updateTestLog("FCCMS Referral Search Results", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS Referral Search Results", "Referral Search Results", Status.PASS);
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fccms_fraud_link)));
		CF.clickOnElement(fccms_fraud_link, "Click on Fraud", "Link", "Pass");
		report.updateTestLog("FCCMS Fraud Link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS Fraud Link", "Click on Fraud Link", Status.PASS);
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fccms_fraud_search)));
		CF.clickOnElement(fccms_fraud_search, "Click on Search", "Link", "Pass");
		report.updateTestLog("FCCMS Fraud Link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS Fraud Link", "Click on Fraud Search Link", Status.PASS);
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fccms_fraud_srchresults)));
		report.updateTestLog("FCCMS Fraud Search Results", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS Fraud Search Results", "Fraud Search Results", Status.PASS);
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fccms_aml_link)));
		CF.clickOnElement(fccms_aml_link, "Click on Fraud", "Link", "Pass");
		report.updateTestLog("FCCMS AML Link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS AML Link", "Click on AML Link", Status.PASS);
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fccms_fraud_search)));
		CF.clickOnElement(fccms_aml_search, "Click on Search", "Link", "Pass");
		report.updateTestLog("FCCMS AML Search Link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS AML Search Link", "Click on AML Search Link", Status.PASS);
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fccms_aml_srchresults)));
		report.updateTestLog("FCCMS AML Search Results", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS AML Search Results", "AML Search Results", Status.PASS);
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fccms_shortsale_link)));
		CF.clickOnElement(fccms_shortsale_link, "Click on Fraud", "Link", "Pass");
		report.updateTestLog("FCCMS Short Sale Link", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS Short Sale Link", "Click on Short Sale Link", Status.PASS);
		
		Thread.sleep(2000);		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(fccms_shortsale_srchresults)));
		report.updateTestLog("FCCMS Short Sale Search Results", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("FCCMS Short Sale Search Results", "Short Sale Search Results", Status.PASS);
		
		report.consolidateScreenshotsInWordDoc();
		
		return new FCCMS_Page(scriptHelper);
	
	}

}
