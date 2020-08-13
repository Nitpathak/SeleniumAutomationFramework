package com.banking.TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);

			System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());

			driver = new ChromeDriver(options);
			
			logger.info("Chrome Browser is in Use!");
		}

		else if (br.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxpath());

			driver = new FirefoxDriver();
			
			logger.info("Firefox Browser is in Use!");
		}

		else if (br.equals("IE")) {

			System.setProperty("webdriver.ie.driver", readConfig.getIEbrowserpath());

			driver = new FirefoxDriver();
			
			logger.info("IE Browser is in Use!");
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
