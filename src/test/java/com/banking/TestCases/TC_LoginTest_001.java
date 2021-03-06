package com.banking.TestCases;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.banking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {

		driver.get(baseURL);
		logger.info("Open Base Url");

		LoginPage lp = new LoginPage(driver);

		lp.setuserName(username);
		logger.info("Entered User Name");

		lp.setPassword(password);
		logger.info("Entered Password");

		lp.clickSubmit();
		logger.info("Click on the Submit button");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage1")) {

			AssertJUnit.assertTrue(true);

			logger.info("Login Test Pass Successfully");

		} else {

			captureScreen(driver, "loginTest");

			AssertJUnit.assertTrue(false);

			logger.info("Login Test Failed!");
		}

	}

}
