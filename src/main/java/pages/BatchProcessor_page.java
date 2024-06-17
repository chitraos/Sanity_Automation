package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocwen.framework.Status;

import businesscomponents.CommonFunctions;
import supportlibraries.ScriptHelper;

public class BatchProcessor_page extends MasterPage {

	 private static WebElement element = null;
	  CommonFunctions CF = new CommonFunctions(scriptHelper);
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(5));

  public BatchProcessor_page(ScriptHelper scriptHelper)
	{

	  
	  super(scriptHelper);
		
	}
	
  
 public static By Cancel =By.xpath(".//*[starts-with(@id,'_FOpt1:')][contains(@id,'tt1:cancel')]");
 public static By Submit =By.xpath(".//*[starts-with(@id,'_FOpt1')][contains(@id,'tt1:submit')]");
 public static By yes_dialogue=By.xpath(".//*[starts-with(@id,'_FOpt1:')][contains(@id,':tt1:okWarningDialog')]");
 
 
 public static By BatchProc_home = By.xpath("/html/body/app-root/app-left-menu-list/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[1]/div");
 public static By BatchProc_admin = By.xpath("//*[@id='mat-expansion-panel-header-0']/span[1]/mat-panel-title");	
 
 public static By BatchProc_approval = By.xpath("//*[@id=\"cdk-accordion-child-0\"]/div/a[1]/div");	
 public static By BatchProc_maintenance = By.xpath("//*[@id=\"cdk-accordion-child-0\"]/div/a[2]/div");	

 public static By BatchProc_reports = By.xpath("/html/body/app-root/app-left-menu-list/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[2]/div");	
 public static By BatchProc_about = By.xpath("/html/body/app-root/app-left-menu-list/mat-sidenav-container/mat-sidenav/div/mat-nav-list/a[3]/div");
 
 
 public BatchProcessor_page BatchProcessor_validate() throws InterruptedException
 {
		 
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BatchProc_home)));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BatchProc_admin)));
		CF.clickOnElement(BatchProc_admin, "Admin", "Link","Pass");
		Thread.sleep(8000);
		report.updateTestLog("Admin", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Admin","Admin has been verified", Status.PASS);
	 
	
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BatchProc_approval)));
		CF.clickOnElement(BatchProc_approval, "Approval Delegation", "Link","Pass");
		Thread.sleep(6000);
		report.updateTestLog("Approval Delegation", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Approval Delegation","Approval Delegation has been verified", Status.PASS);
	 
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BatchProc_maintenance)));
		CF.clickOnElement(BatchProc_maintenance, "Maintenance", "Link","Pass");
		Thread.sleep(6000);
		report.updateTestLog("Maintenance", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Maintenance","Maintenance screen has been verified", Status.PASS);
	 
	 
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BatchProc_reports)));
		CF.clickOnElement(BatchProc_reports, "Reports", "Link","Pass");
		Thread.sleep(6000);
		report.updateTestLog("Reports", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Reports","Reports screen has been verified", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BatchProc_about)));
		CF.clickOnElement(BatchProc_about, "About", "Link","Pass");
		Thread.sleep(6000);
		report.updateTestLog("About", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("About","Reports screen has been verified", Status.PASS);
		
		report.consolidateScreenshotsInWordDoc();
		
		Thread.sleep(500);
	    return new BatchProcessor_page(scriptHelper);
 }
}
