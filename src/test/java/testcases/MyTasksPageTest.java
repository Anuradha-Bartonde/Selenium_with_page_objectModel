package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.DashboardPage;
import pages.LoginPage;
import pages.PolicyManagementPage;
import testbase.TestBase;

public class MyTasksPageTest extends TestBase{
	LoginPage loginPgae;
	DashboardPage dashboardpage;
	PolicyManagementPage policyManagementPage;
	public MyTasksPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialize();
		loginPgae=new LoginPage();
		dashboardpage=loginPgae.login();
		dashboardpage.clickOnContinuousComplianceLink();
		policyManagementPage=dashboardpage.clickOnPolicyManagementLink();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
