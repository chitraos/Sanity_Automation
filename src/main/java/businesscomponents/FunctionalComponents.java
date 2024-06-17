package businesscomponents;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocwen.framework.Status;
import com.ocwen.framework.selenium.WebDriverUtil;

import pages.BatchProcessor_page;
import pages.CMS_Page;
import pages.DDS_Page;
import pages.DMS_Page;
import pages.Eagle_Page;
import pages.FCCMS_Page;
import pages.InQ_Research_Page;
import pages.QA_Page;
import pages.Send_email;
import pages.Tmonitor_Page;
import pages.UAM_Page;
import pages.Vision_Page;
import pages.Income_Calculator_Page;
import pages.Investor_Rules_Manager_Page;
//import bsh.util.Util;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import businesscomponents.CommonFunctions;


/**
 * Functional Components class
 * @author LT TCS
 */
public class FunctionalComponents extends ReusableLibrary
{
	private WebDriverUtil driverUtil;
	CommonFunctions CF = new CommonFunctions(scriptHelper);
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	public FunctionalComponents(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		driverUtil = new WebDriverUtil(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	public String errorMessage;
	public String strMessage;
	public String strCode;
	public String strAppend;
	public String strBatchName;
	public String InvoiceNum;

	
	public void invokeApplication() throws InterruptedException
	{	  	
		String strUrl = dataTable.getData("General_Data", "URL");
		driver.get(strUrl);
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		
		//Send_email SEPG= new Send_email(scriptHelper);
		//SEPG.email();
	
	}
	
	public QA_Page qa_ssrs_application() throws InterruptedException, InvalidFormatException
	{
		QA_Page QAPG= new QA_Page(scriptHelper);
		QAPG.QA_validate_ssrs();
		
		return new QA_Page(scriptHelper);
	}
	
	public DMS_Page dms_application() throws InterruptedException, InvalidFormatException
	{	
		Thread.sleep(7000);
		DMS_Page DMSPG= new DMS_Page(scriptHelper);
		DMSPG.dms_validate();
		
		return new DMS_Page(scriptHelper);
	}
	
	public Eagle_Page eagle_application() throws InterruptedException, InvalidFormatException
	{	
		Thread.sleep(7000);
		Eagle_Page EGLPG= new Eagle_Page(scriptHelper);
		EGLPG.eagle_validate();
		
		return new Eagle_Page(scriptHelper);
	}
	
	public DDS_Page dds_application() throws InterruptedException, InvalidFormatException
	{
		Thread.sleep(7000);
		DDS_Page DDSPG= new DDS_Page(scriptHelper);
		DDSPG.dds_validate();
		
		return new DDS_Page(scriptHelper);
	}
	
	
	public Income_Calculator_Page income_calculator_application() throws InterruptedException, InvalidFormatException
	{
		Thread.sleep(8000);
		Income_Calculator_Page INCAPG= new Income_Calculator_Page(scriptHelper);
		INCAPG.income_calculator_validation();
		
		return new Income_Calculator_Page(scriptHelper);
	}
	
	public Tmonitor_Page tmonitor_application() throws InterruptedException, InvalidFormatException
	{
		Thread.sleep(8000);
		Tmonitor_Page TMONPG = new Tmonitor_Page(scriptHelper);
		TMONPG.tmongen_validate();
		
		return new Tmonitor_Page(scriptHelper);
	}
	
	public Vision_Page vision_application() throws InterruptedException, InvalidFormatException
	{
		Thread.sleep(1000);
		Vision_Page VIPG= new Vision_Page(scriptHelper);
		VIPG.Vision_validate();
		
		return new Vision_Page(scriptHelper);
	}
	
	public BatchProcessor_page batchProcessor_application() throws InterruptedException, InvalidFormatException
	{
		Thread.sleep(7000);
		BatchProcessor_page BPPG= new BatchProcessor_page(scriptHelper);
		BPPG.BatchProcessor_validate();
		
		return new BatchProcessor_page(scriptHelper);
	}
	
	public Investor_Rules_Manager_Page investorrulesmanager_application() throws InterruptedException, InvalidFormatException
	{
		Thread.sleep(7000);
		Investor_Rules_Manager_Page irmmsp = new Investor_Rules_Manager_Page(scriptHelper);
		irmmsp.irmmsp_validate();
		
		return new Investor_Rules_Manager_Page(scriptHelper);
	}
	
	public QA_Page qa_web_application() throws InterruptedException, InvalidFormatException
	{
		
		QA_Page QAPG= new QA_Page(scriptHelper);
		QAPG.QA_validate_web();
		
		return new QA_Page(scriptHelper);
	}
	
	public Send_email email_send ()
	{
		Send_email SEPG= new Send_email(scriptHelper);
		SEPG.email();
		
		return new Send_email(scriptHelper);
		
	}
	
	
	public CMS_Page cms_application() throws InterruptedException, InvalidFormatException, IOException
	{
		CMS_Page CMSPG= new CMS_Page(scriptHelper);
		CMSPG.Login();
		
		return new CMS_Page(scriptHelper);
	}
	
	public UAM_Page uam_application() throws InterruptedException, InvalidFormatException, IOException
	{
		Thread.sleep(3000);
		
		UAM_Page UAMPG= new UAM_Page(scriptHelper);		
		UAMPG.UAM_Validation();
		
		return new UAM_Page(scriptHelper);
	}
	
	
	public FCCMS_Page fccms_application() throws InterruptedException, InvalidFormatException, IOException
	{
		Thread.sleep(10000);
		
		FCCMS_Page FCCMSPG= new FCCMS_Page(scriptHelper);		
		FCCMSPG.FCCMS_validate();
		
		return new FCCMS_Page(scriptHelper);
	}
		
	public InQ_Research_Page inQ_Research_application() throws InterruptedException, InvalidFormatException, IOException
	{
		InQ_Research_Page InQPG= new InQ_Research_Page(scriptHelper);
		InQPG.inQ_Research_application();
		
		return new InQ_Research_Page(scriptHelper);
	}
	
	
	
/*
		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("onetrust-accept-btn-handler"))));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("onetrust-accept-btn-handler"))));
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
			
		}
		catch(Exception e) {
			System.out.println("");
		}
*/
	
	
	public void loginError() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String error = CF.getText(By.id("login-error-header"));
		dataTable.putData("General_Data", "Error", error);
	}
	




}