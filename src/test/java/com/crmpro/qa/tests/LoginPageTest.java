package com.crmpro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crmpro.qa.base.TestBase;
import com.crmpro.qa.pages.HomePage;
import com.crmpro.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();  //It will call TestBase constructor automatically to initialize the properties
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage();		
	}
	
	@Test(priority=1)
	public void loginPageTitleValidate() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void crmLogoTest() {
		boolean flag = loginPage.validateCrmImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterClass
	public void closeAll() {
		driver.quit();
	}
}
