package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import supportlibraries.*;
import com.ocwen.framework.Status;

import businesscomponents.CommonFunctions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

    public class Vision_Page extends MasterPage{
        private static WebElement element = null;
        CommonFunctions CF = new CommonFunctions(scriptHelper);
       
        public Vision_Page(ScriptHelper scriptHelper)
    	{
    		super(scriptHelper);
    		
    		
    	}
      //declaring fluent wait with time out of 30 seconds and frequency is set to 5 seconds  		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(5));

        /*
         * 1. Define UI elements 
         */
        
    private static By home_Icon = By.id("pt1:_UIShome::icon");
    public static By navigator_Icon = By.id("pt1:_UISmmLink::icon");
    
    
    
    public static By userid_label = By.xpath("//*[@id='ctl00_ViewNav_new_logonVisionPortal_lblUserName']/b");
    public static By userid_textbox = By.xpath("//*[@id=\"ctl00_ViewNav_new_logonVisionPortal_UserName\"]");
    public static By password_label = By.xpath("//*[@id=\"ctl00_ViewNav_new_logonVisionPortal_lblPassword\"]/b");
    public static By password_textbox = By.xpath("//*[@id=\"ctl00_ViewNav_new_logonVisionPortal_Password\"]");
    public static By login_btn = By.xpath("//*[@id=\"ctl00_ViewNav_new_logonVisionPortal_btnLogin\"]");
 
    public static By drop_down = By.xpath("//*[@id=\"ctl00_ViewNav1_ddlSearchType\"]");
    public static By dropdown_textbox = By.xpath("//*[@id=\"ctl00_ViewNav1_ddlSearchType\"]");
    public static By search_btn = By.xpath("//*[@id=\"ctl00_ViewNav1_btnSearch\"]");
    public static By rfmsi_hyperlink = By.xpath("//*[contains(text(),'RFMSI (S & SA Series)')]");
    public static By rfmsi_analytics = By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ShelfOverviewContainer1_OverviewInfoLinks1_OverviewLinks1_DataList1\"]/tbody/tr/td/a");
    public static By advance_button = By.xpath("//*[@id=\"details-button\"]");
    public static By procedd_link = By.xpath("//*[@id=\"proceed-link\"]");
  
  
    /*
     * Define functions 
     */
    

    public Vision_Page Vision_validate() throws InterruptedException 
    {   
    	try {
    		
    		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(advance_button)));
    		driver.findElement(advance_button).click();
    		
    		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(procedd_link)));
    		driver.findElement(procedd_link).click();
    		System.out.println("not secure");
    	}
    	catch (Exception e){   		
    	}
    	
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(userid_label)));    	    	
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(userid_textbox)));
    	report.updateTestLog("Vision Login Page", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Vision Login Page", "Vision Login Page", Status.PASS);
    	
    	CF.clickOnElement(userid_textbox, "Click on User_textbox", "Textbox","Pass");
    	String user_id = dataTable.getData("General_Data", "Username");    	
    	driver.findElement(userid_textbox).sendKeys(user_id);
    	
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(password_label)));
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(password_textbox)));    	
    	CF.clickOnElement(password_textbox, "Click on password_textbox", "Textbox","Pass");
    	String pwd = dataTable.getData("General_Data", "Password");    	
    	driver.findElement(password_textbox).sendKeys(pwd);
    	report.updateTestLog("Login Details Updated", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Login", "Login Details Updated", Status.PASS);    	
    	
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(login_btn)));
    	CF.clickOnElement(login_btn, "Click on Login button", "Button","Pass");
    	Thread.sleep(5000);
    	report.updateTestLog("Login Succesful", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Login Succesful", "Login Succesful", Status.PASS); 
    	
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(rfmsi_hyperlink)));
    	Actions action = new Actions(driver); 
    	element = driver.findElement(rfmsi_hyperlink);
    	action.moveToElement(element).click();
    	action.moveToElement(element).clickAndHold();
    	action.moveToElement(element).click();
    	CF.clickOnElement(rfmsi_hyperlink, "Click on hyperlink", "hyperlink","Pass");
    	report.updateTestLog("RFMSI Page", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("RFMSI Page", "Login Succesful", Status.PASS); 
    	//CF.clickOnElement(rfmsi_hyperlink, "Click on hyperlink", "hyperlink","Pass");
    	//CF.clickOnElement(rfmsi_hyperlink, "Click on hyperlink", "hyperlink","Pass");
        //CF.clickOnElement(rfmsi_hyperlink, "Click on hyperlink", "hyperlink","Pass");
    	
		report.consolidateScreenshotsInWordDoc();
    	Thread.sleep(600);
    
    	
    	return new Vision_Page(scriptHelper);
    	
    }
    }