package testscripts.scenario1;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.ocwen.framework.IterationOptions;
import com.ocwen.framework.WordDocumentManager;
import com.ocwen.framework.selenium.Browser;

import supportlibraries.DriverScript;
import supportlibraries.TestCase;
import com.ocwen.framework.selenium.Browser;

public class DDS_DEV extends TestCase
{
	@Test
	public void runTC4() throws InvalidFormatException
	{
		testParameters.setCurrentTestDescription("Sanity Testing Automation for DDS application");
		testParameters.setIterationMode(IterationOptions.RunAllIterations);
		testParameters.setBrowser(Browser.Edge);
		driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
		
		
		
	}
}

