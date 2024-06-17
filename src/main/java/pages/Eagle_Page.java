package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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

public class Eagle_Page extends MasterPage{
    private static WebElement element = null;
    CommonFunctions CF = new CommonFunctions(scriptHelper);
   
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    
    public Eagle_Page(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		
		
	}
 
    // Below are the declarations  of xpath	of Home, Navigator and Directory page
	public static By eagle_tilte = By.xpath("/html/body/table/tbody/tr/td[2]/font");
	public static By loan_textbox	= By.xpath("//*[@id='AssetID']");
	public static By go_button	= By.xpath("/html/body/table/tbody/tr[3]/td[2]/img");	
	public static By Loan_lookup	= By.xpath("//*[@id='menu']/div/table[2]/tbody/tr[1]/td/a");
	public static By Loan_Lookup_check	= By.xpath("/html/body/table[1]/tbody/tr/td[1]/div");
	public static By export_claims	= By.xpath("//*[@id='menu']/div/table[2]/tbody/tr[3]/td/a");
	public static By export_claims_check	= By.xpath("/html/body/table/tbody/tr/td[1]/div");
	public static By input_mi	= By.xpath("//*[@id='menu']/div/table[2]/tbody/tr[5]/td/a");
	public static By input_mi_check	= By.xpath("/html/body/table[1]/tbody/tr/td[1]/div");
	
	public Eagle_Page eagle_validate() throws InterruptedException
		{
					
			driver.switchTo().frame("data_header");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(eagle_tilte)));
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("adframe");
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loan_textbox)));
			report.updateTestLog("Eagle Home Page", "Screenshot Capture", Status.SCREENSHOT);
			
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame("navctl");
			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Loan_lookup)));				
			CF.clickOnElement(Loan_lookup, "Click on Loan Lookup", "Link","Pass");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("data_contents");		
			Thread.sleep(1000);			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Loan_Lookup_check)));
			report.updateTestLog("Loan Lookup Page", "Screenshot Capture", Status.SCREENSHOT);
			
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame("navctl");
			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(export_claims)));				
			CF.clickOnElement(export_claims, "Click on Lookup", "Link","Pass");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("data_contents");
			Thread.sleep(1000);				
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(export_claims_check)));
			report.updateTestLog("Export Claims Page", "Screenshot Capture", Status.SCREENSHOT);
			
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame("navctl");
			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(input_mi)));				
			CF.clickOnElement(input_mi, "Click on Lookup", "Link","Pass");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("data_contents");
			Thread.sleep(1000);				
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(input_mi_check)));
			report.updateTestLog("Input MI Page", "Screenshot Capture", Status.SCREENSHOT);
			
			//CF.clickOnElement(loan_textbox, "Click on Loan Textbox", "Textbox","Pass");
			//String loan_number = dataTable.getData("General_Data", "Loan Number");
			//driver.findElement(loan_textbox).sendKeys(loan_number);
			//report.updateTestLog("Update Loan Number", "Loan Number Entered", Status.PASS);
			//report.updateTestLog("Loan Number Updated", "Screenshot Capture", Status.SCREENSHOT);
			
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(go_button)));
			//CF.clickOnElement(go_button, "Click on Go Buton", "Button", "Pass");
			//Thread.sleep(50000);
					
			
			//report.updateTestLog("Directory", "Select Directory", Status.PASS);
			
			//wait.until(ExpectedConditions.titleContains("Directory - Directory - Oracle Applications"));
					
			//String title1 = driver.getTitle();
			//System.out.print(title1);
			report.consolidateScreenshotsInWordDoc();
			
			return new Eagle_Page(scriptHelper);
		
		}

}


