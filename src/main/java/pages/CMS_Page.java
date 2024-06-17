package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocwen.framework.Status;

import businesscomponents.CommonFunctions;
import supportlibraries.ScriptHelper;

public class CMS_Page extends MasterPage{
    private static WebElement element = null;
    CommonFunctions CF = new CommonFunctions(scriptHelper);
   
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    
    public CMS_Page(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		
		
	}
  //declaring fluent wait with time out of 30 seconds and frequency is set to 5 seconds  		
	//Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)							
	//.withTimeout(30, TimeUnit.SECONDS) 			
	//.pollingEvery(5, TimeUnit.SECONDS) 			
	//.ignoring(NoSuchElementException.class);

	// Below are the declarations  of xpath	of Home, Navigator and Directory page
	
	public static By account	= By.xpath("//*[@id='addUserTable']/tbody/tr[2]/td[1]");
	public static By loannumber	= By.xpath("//*[@id='loanNumber']");
	public static By checkbox	= By.xpath("//*[@id='readonly']");
	public static By launch	= By.xpath("//*[@id='saveButton']");
	public static By person	= By.xpath("//*[@id='BTN_Next_btn_0']");
	public static By speak = By.xpath("//*[@id='start']/table/tbody/tr[2]/td[1]");
	
	File textf = new File("Output\\");
	String textfile = textf.getAbsolutePath();
	
		
	public CMS_Page Login() throws InterruptedException, IOException
	{
		String loan_number = dataTable.getData("General_Data", "Loan_Number");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(account)));		
		CF.enterValuesInTextBox(loannumber, "Enter the Loannumber", loan_number, "Pass");
	    
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(checkbox)));
	    CF.clickOnElement(checkbox, "Click on Checkbox", "Checkbox", "Pass");
		Thread.sleep(200);
		
		String parenthandle = driver.getWindowHandle();
	    
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(launch)));
		CF.clickOnElement(launch, "Click on Lanuch", "Button", "Pass");
		Thread.sleep(5000);
		
		Set<String> handles = driver.getWindowHandles();
		Thread.sleep(2000);

		for (String handle : handles)

		{
			System.out.println(handle);
			
			if (!handle.equals(parenthandle))

			{
				driver.switchTo().window(handle);
				System.out.println(handle);
				String title = driver.getTitle();
				System.out.println(title);
				driver.manage().window().maximize();
				break;
				
			}
		
		}
		
		driver.switchTo().frame("main");
				
		Thread.sleep(1000);
		driver.switchTo().frame("scriptContentIframe");
		Thread.sleep(3000);
			
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(person)));			
		
		String speak_text = driver.findElement(speak).getText();
		System.out.println(speak_text);
			
		return new CMS_Page(scriptHelper);
	}
}



