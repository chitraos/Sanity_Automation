package testscripts.scenario1;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.ocwen.framework.IterationOptions;
import com.ocwen.framework.WordDocumentManager;
import com.ocwen.framework.selenium.Browser;

import supportlibraries.DriverScript;
import supportlibraries.TestCase;

public class QA_SSRS_DEV extends TestCase
{
	@Test
	public void runTC2() throws InvalidFormatException
	{
		testParameters.setCurrentTestDescription("Sanity Testing of QA SSRS application");
		testParameters.setIterationMode(IterationOptions.RunAllIterations);
		testParameters.setBrowser(Browser.Chrome);
		driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
				
	} 

}
