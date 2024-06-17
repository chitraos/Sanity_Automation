package businesscomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ocwen.framework.FrameworkException;
import com.ocwen.framework.Status;
import com.ocwen.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;


/**
 * Verification Components class
 * @author LT TCS
 */
public class VerificationComponents extends ReusableLibrary
{
	private WebDriverUtil driverUtil;
	
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	public VerificationComponents(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		
		driverUtil = new WebDriverUtil(driver);
	}
	


	public static void main(String[] args) {
		
	}
}