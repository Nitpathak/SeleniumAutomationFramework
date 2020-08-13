package com.banking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.PageObjects.LoginPage;
import com.banking.utilities.XLSUtilies;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		
		
		driver.get(baseURL);
		logger.info("Open Base Url");
		LoginPage lp = new LoginPage(driver);
		lp.setuserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.warn("Login passed"); //passed // failed
		} else {
			Assert.assertTrue(false);
			logger.info("Login failed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlertPresent() // user defined method created to check alert is presetn or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}
	
	///Users/nitin/Documents/Automation/SDET_BankingProject/src/test/java/com/banking/TestData/LoginData.xlsx

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/banking/testData/LoginData.xlsx";

		int rownum = XLSUtilies.getRowCount(path, "Sheet1");
		int colcount = XLSUtilies.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLSUtilies.getCellData(path, "Sheet1", i, j);// 1 0
			}

		}
		return logindata;
	}

}
