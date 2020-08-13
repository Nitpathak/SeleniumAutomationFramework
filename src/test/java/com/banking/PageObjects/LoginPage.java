package com.banking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver Idriver;

	public LoginPage(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//input[@name='uid']")
	WebElement txtUserName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement btnLogin;

	public void setuserName(String uname) throws InterruptedException

	{
		Thread.sleep(3000);
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) throws InterruptedException

	{
		Thread.sleep(3000);
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() throws InterruptedException

	{
		Thread.sleep(2000);
		btnLogin.click();
	}

}
