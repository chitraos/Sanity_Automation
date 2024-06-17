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

    public class Tmonitor_Page extends MasterPage{
        private static WebElement element = null;
        CommonFunctions CF = new CommonFunctions(scriptHelper);
       
        public Tmonitor_Page(ScriptHelper scriptHelper)
    	{
    		super(scriptHelper);
    		
    		
    	}
      //declaring fluent wait with time out of 30 seconds and frequency is set to 5 seconds  		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(5));

        /*
         * 1. Define UI elements 
         */

    public static By tmonitor_label = By.xpath("(//*[contains(text(),'T-Monitor')])[2]");
    public static By total_inventory_label = By.xpath("//*[contains(text(),' Total Inventory ')]");
    public static By option = By.xpath("/html/body/app-root/app-top-menus/mat-sidenav-container/mat-sidenav-content/mat-toolbar/button/span[1]/mat-icon");
    public static By user_profile_label = By.xpath("//*[contains(text(),'User Profile')]");
    public static By assigner_label = By.xpath("(//*[contains(text(),'Assigner')])[3]");
 
    public static By upload_inventory_link = By.xpath("//*[contains(text(),'Upload Inventory')]");
    public static By upload_inventory_label = By.xpath("(//*[contains(text(),'Upload Inventory')])[3]");
    public static By dashboard_link = By.xpath("//*[contains(text(),'Dashboard')]");
    public static By team_lead_label = By.xpath("//*[contains(text(),'Team Leads')]");
    public static By workboard_link = By.xpath("(//*[contains(text(),'Workboard')])[1]");
    public static By loan_number_label = By.xpath("//*[contains(text(),'Loan Number')]");
    public static By report_link = By.xpath("(//*[contains(text(),'Reports')])[1]");
    public static By location_label = By.xpath("(//*[contains(text(),'Location')])[2]");


    public Tmonitor_Page tmongen_validate() throws InterruptedException 
    {   
    	   	
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(tmonitor_label)));    	    	
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(total_inventory_label)));
    	report.updateTestLog("T-Monitor Home Page", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("T-Monitor Home Page", "T-Monitor Home Page Displayed", Status.PASS);
    	
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(option)));
    	CF.clickOnElement(option, "Click on Menu", "Button","Pass");
    	report.updateTestLog("Menu", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Menu", "Menu Displayed", Status.PASS);
		
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(user_profile_label)));
    	CF.clickOnElement(user_profile_label, "Click on User Profile", "Link","Pass"); 
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(assigner_label)));
    	report.updateTestLog("User Profile", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("User Profile", "User Profile Displayed", Status.PASS); 
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(option)));
    	CF.clickOnElement(option, "Click on Menu", "Button","Pass");
    	report.updateTestLog("Menu", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Menu", "Menu Displayed", Status.PASS);
    	
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(upload_inventory_link)));
    	CF.clickOnElement(upload_inventory_link, "Click on Upload Inventory", "Link","Pass");  
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(upload_inventory_label)));
    	report.updateTestLog("Upload Inventory", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Upload Inventory", "Upload Inventory Displayed", Status.PASS); 
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(option)));
    	CF.clickOnElement(option, "Click on Menu", "Button","Pass");
    	report.updateTestLog("Menu", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Menu", "Menu Displayed", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(dashboard_link)));
    	CF.clickOnElement(dashboard_link, "Click on Dashboard", "Link","Pass");    
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(team_lead_label)));
    	report.updateTestLog("Dashboard", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Dashboard", "Dashboard Displayed", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(option)));
    	CF.clickOnElement(option, "Click on Menu", "Button","Pass");
    	report.updateTestLog("Menu", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Menu", "Menu Displayed", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(workboard_link)));
    	CF.clickOnElement(workboard_link, "Click on Workboard", "Link","Pass"); 
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loan_number_label)));
    	report.updateTestLog("Workboard", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Workboard", "Workboard Displayed", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(option)));
    	CF.clickOnElement(option, "Click on Menu", "Button","Pass");
    	report.updateTestLog("Menu", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Menu", "Menu Displayed", Status.PASS);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(report_link)));
    	CF.clickOnElement(report_link, "Click on Reports", "Link","Pass"); 
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(location_label)));
    	report.updateTestLog("Reports", "Screenshot Capture", Status.SCREENSHOT);
		report.updateTestLog("Reports", "Reports Displayed", Status.PASS);
		
		report.consolidateScreenshotsInWordDoc();
    	Thread.sleep(600);
    
    	
    	return new Tmonitor_Page(scriptHelper);
    	
    }
    }