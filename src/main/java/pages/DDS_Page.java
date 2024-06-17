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

public class DDS_Page extends MasterPage{
    private static WebElement element = null;
    CommonFunctions CF = new CommonFunctions(scriptHelper);
   
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    
    public DDS_Page(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		
		
	}
 
    // Below are the declarations  of xpath	of Home, Navigator and Directory page
	public static By dds_tilte = By.xpath("/html/body/table/tbody/tr/td[2]/span/font/strong/small");
	public static By loan_textbox	= By.xpath("//*[@id='AssetSeqID']");
	public static By go_button	= By.xpath("/html/body/table/tbody/tr[3]/td[2]/img");
	
	public DDS_Page dds_validate() throws InterruptedException
		{
			driver.switchTo().frame("data_contents");		
			Thread.sleep(1000);
			driver.switchTo().frame("data_header");
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(dds_tilte)));
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("quick");
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loan_textbox)));
			report.updateTestLog("DDS Home Page", "Screenshot Capture", Status.SCREENSHOT);
			
			CF.clickOnElement(loan_textbox, "Click on Loan Textbox", "Textbox","Pass");
			String loan_number = dataTable.getData("General_Data", "Loan Number");
			driver.findElement(loan_textbox).sendKeys(loan_number);
			report.updateTestLog("Update Loan Number", "Loan Number Entered", Status.PASS);
			report.updateTestLog("Loan Number Updated", "Screenshot Capture", Status.SCREENSHOT);
			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(go_button)));
			CF.clickOnElement(go_button, "Click on Go Buton", "Button", "Pass");
			//Thread.sleep(50000);
					
			
			//report.updateTestLog("Directory", "Select Directory", Status.PASS);
			
			//wait.until(ExpectedConditions.titleContains("Directory - Directory - Oracle Applications"));
					
			//String title1 = driver.getTitle();
			//System.out.print(title1);
			report.consolidateScreenshotsInWordDoc();
			
			return new DDS_Page(scriptHelper);
		
		}

}


