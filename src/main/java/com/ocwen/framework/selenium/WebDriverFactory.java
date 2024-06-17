package com.ocwen.framework.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
//import org.openqa.selenium.firefox.internal.ProfilesIni;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.ocwen.framework.FrameworkException;
import com.ocwen.framework.Settings;

public class WebDriverFactory {
	private static Properties properties;
	static String projectDirectory = System.getProperty("user.dir");
	public static WebDriver getDriver(Browser browser)
	{
		WebDriver driver = null;
		properties = Settings.getInstance();
		boolean proxyRequired = 
				Boolean.parseBoolean(properties.getProperty("ProxyRequired"));
		switch (browser)
		{

		case Chrome:
			properties.setProperty("ChromeDriverPath", projectDirectory + File.separator + "\\Driver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",properties.getProperty("ChromeDriverPath")); 
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.addArguments("--no-sandbox");
			//options.addArguments("--headless", "--remote-allow-origins=*", "--start-maximized");
			// chromeOptions.addArguments("--headless");  // Run Chrome in headless mode
			// chromeOptions.addArguments("--disable-gpu");  // Disable GPU acceleration (may be required in some CI environments)
			// chromeOptions.addArguments("--no-sandbox");  // Disable sandboxing (useful in some CI environments)
			// chromeOptions.addArguments("--disable-software-rasterizer");  // Disable the software rasterizer
			// chromeOptions.addArguments("--disable-dev-shm-usage");  // Disable the use of /dev/shm for shared memory

			driver = new ChromeDriver(chromeOptions);
			break;
		case Firefox:
			properties.setProperty("FireFoxDriverPath", projectDirectory + File.separator + "\\Driver\\geckodriver.exe");
			System.setProperty("webdriver.firefox.driver",properties.getProperty("FireFoxDriverPath")); 
			driver = new FirefoxDriver();
			/*
			 * Changes made to enable firefox window pop up haldles 
			 */
			/* rvk recent change
			 * System.setProperty("webdriver.firefox.profile", "MySeleniumProfile");
			 * DesiredCapabilities desiredCapabilities1 = new DesiredCapabilities("firefox",
			 * "", Platform.ANY); FirefoxProfile profile1 = new
			 * ProfilesIni().getProfile("MySeleniumProfile");
			 * desiredCapabilities1.setCapability("firefox_profile", profile1);
			 */
			//WebDriver webdriver = new RemoteWebDriver(desiredCapabilities1);
			/*FirefoxProfile profile = new FirefoxProfile();
			      profile.setAcceptUntrustedCertificates( true );
			      profile.setPreference( "security.enable_java", true ); 
			      profile.setPreference("plugin.state.java", 2);
			// driver = new FirefoxDriver(profile1);
			//driver = new FirefoxDriver(desiredCapabilities1);
			break;
		case HtmlUnit:
			/* driver = new HtmlUnitDriver();

			      if (!(proxyRequired)) break ;
			      //label266
			      boolean proxyAuthenticationRequired = 
			        Boolean.parseBoolean(properties.getProperty("ProxyAuthenticationRequired"));
			      if (proxyAuthenticationRequired)
			      {
			        driver = new HtmlUnitDriver()
			        {
			          protected WebClient modifyWebClient(WebClient client) {
			            DefaultCredentialsProvider credentialsProvider = new DefaultCredentialsProvider();
			            credentialsProvider.addNTLMCredentials(WebDriverFactory.properties.getProperty("Username"), 
			              WebDriverFactory.properties.getProperty("Password"), 
			              WebDriverFactory.properties.getProperty("ProxyHost"), 
			              Integer.parseInt(WebDriverFactory.properties.getProperty("ProxyPort")), 
			              "", WebDriverFactory.properties.getProperty("Domain"));
			            client.setCredentialsProvider(credentialsProvider);
			            return client;
			          }
			        };
			      }

			      ((HtmlUnitDriver)driver).setProxy(properties.getProperty("ProxyHost"), 
			        Integer.parseInt(properties.getProperty("ProxyPort")));
			 */
			break;
		case InternetExplorer:
			properties.setProperty("InternetExplorerDriverPath", projectDirectory + File.separator + "\\driver\\internetexplorer.exe");
			System.setProperty("webdriver.ie.driver", 
					properties.getProperty("InternetExplorerDriverPath"));
			driver = new InternetExplorerDriver();
			break;

		case Edge:
			properties.setProperty("EdgeDriverPath", projectDirectory + File.separator + "\\driver\\msedgedriver.exe");
			System.setProperty("webdriver.edge.driver", 
					properties.getProperty("EdgeDriverPath"));
			EdgeOptions edgeOptions = new EdgeOptions();
			String username = System.getProperty("user.name");
			edgeOptions.addArguments("user-data-dir=C://Users//"+username+"//AppData//Local//Microsoft//Edge//User Data");
			edgeOptions.addArguments("profile-directory=Default");
			//edgeOptions.addArguments("--start-maximized");
			//edgeOptions.addArguments("disable-infobars"); // disabling infobars
			//edgeOptions.addArguments("--disable-extensions"); // disabling extensions
			//edgeOptions.addArguments("--disable-gpu"); // applicable to windows os only
			edgeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			edgeOptions.addArguments("--no-sandbox"); // Bypass OS security model
			driver = new EdgeDriver(edgeOptions); 
			break;
		case Safari:
			driver = new SafariDriver();
			break;
		default:
			throw new FrameworkException("Unhandled browser!");
		}
		return driver;
	}

	private static DesiredCapabilities getProxyCapabilities() {
		Proxy proxy = new Proxy();
		proxy.setProxyType(Proxy.ProxyType.MANUAL);

		properties = Settings.getInstance();
		String proxyUrl = properties.getProperty("ProxyHost") + ":" + properties.getProperty("ProxyPort");

		proxy.setHttpProxy(proxyUrl);
		proxy.setFtpProxy(proxyUrl);
		proxy.setSslProxy(proxyUrl);
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("proxy", proxy);

		return desiredCapabilities;
	}

	public static WebDriver getDriver(Browser browser, String remoteUrl) {
		return getDriver(browser, null, null, remoteUrl);
	}

	public static WebDriver getDriver(Browser browser, String browserVersion, Platform platform, String remoteUrl) {
		properties = Settings.getInstance();
		boolean proxyRequired = Boolean.parseBoolean(properties.getProperty("ProxyRequired"));

		DesiredCapabilities desiredCapabilities = null;
		if ((((browser.equals(Browser.HtmlUnit)) || (browser.equals(Browser.Opera)))) && (proxyRequired))
			desiredCapabilities = getProxyCapabilities();
		else {
			desiredCapabilities = new DesiredCapabilities();
		}

		desiredCapabilities.setBrowserName(browser.getValue());

		if (browserVersion != null) {
			desiredCapabilities.setVersion(browserVersion);
		}
		if (platform != null) {
			desiredCapabilities.setPlatform(platform);
		}

		//desiredCapabilities.setJavascriptEnabled(true);
		URL url;
		try {
			url = new URL(remoteUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new FrameworkException("The specified remote URL is malformed");
		}
		return new RemoteWebDriver(url, desiredCapabilities);
	}
}
