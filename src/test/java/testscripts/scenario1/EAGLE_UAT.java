package testscripts.scenario1;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.ocwen.framework.IterationOptions;
import com.ocwen.framework.WordDocumentManager;
import com.ocwen.framework.selenium.Browser;

import supportlibraries.DriverScript;
import supportlibraries.TestCase;

public class EAGLE_UAT extends TestCase
{
	@Test
	public void runTC1() throws InvalidFormatException
	{
		testParameters.setCurrentTestDescription("Sanity Testing of EAGLE UAT Aapplication");
		testParameters.setIterationMode(IterationOptions.RunAllIterations);
		testParameters.setBrowser(Browser.Edge);
		driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
		
				
	} 

}