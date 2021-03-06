package testcases;

import java.io.IOException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginPgae;
	DashboardPage dashboardpage;
	//WebDriver driver;
	
	public LoginPageTest() {
		super();
	}

	@Test(groups={"Sanity"})
	public void login() throws InterruptedException
	{
		dashboardpage=loginPgae.login();
		System.out.println("log object: "+log);
		String username=dashboardpage.getLoggedinUser();
		log.info("Logged In user: "+username);
		Assert.assertEquals(username, prop.getProperty("user"),"LoginFailed");
		//log.info("User: "+username+" is logged Successfully");
		
	}
	
	
	@BeforeMethod
	public void setUp( )
	{
		initialize();
		loginPgae=new LoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
