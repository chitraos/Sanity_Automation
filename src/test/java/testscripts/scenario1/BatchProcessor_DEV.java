package testscripts.scenario1;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.ocwen.framework.IterationOptions;
import com.ocwen.framework.WordDocumentManager;
import com.ocwen.framework.selenium.Browser;

import supportlibraries.DriverScript;
import supportlibraries.TestCase;

public class BatchProcessor_DEV extends TestCase
{
	@Test
	public void runTC1() throws InvalidFormatException
	{
		testParameters.setCurrentTestDescription("Sanity Testing of BatchProcessor DEV Aapplication");
		testParameters.setIterationMode(IterationOptions.RunAllIterations);
		testParameters.setBrowser(Browser.Chrome);
		driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
		
				
	} 

}