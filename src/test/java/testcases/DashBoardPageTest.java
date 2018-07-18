package testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ComplianceConsolePage;
import pages.DashboardPage;
import pages.InitiateServerInspectionPage;
import pages.LoginPage;
import pages.ManageEnforcementModePage;
import pages.MyRequestsPage;
import pages.MyTasksPage;
import pages.PolicyManagementPage;
import pages.ServerOverridesPage;
import testbase.TestBase;

public class DashBoardPageTest extends TestBase{
	LoginPage loginPgae;
	 DashboardPage dashboardpage;
	 PolicyManagementPage policyManagementPage;
	 ComplianceConsolePage complianceConsolePage;
	 MyTasksPage myTasksPage;
	 MyRequestsPage myRequestsPage;
	 ManageEnforcementModePage  manageEnforcementModePage;
	 InitiateServerInspectionPage initiateServerInspectionPage;
	 ServerOverridesPage  serverOverridesPage;
	
	public DashBoardPageTest()
	{
		super();
	}
	
	@BeforeSuite
	public void BeforeSuite()
	{
		log.info("****Dashboard Page BeforeSuite() Test****");
	}
	
	@AfterSuite
	public void AfterSuite()
	{
		log.info("****Dashboard Page AfterSuite() Test****");
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		log.info("****Dashboard Page BeforeTest() Test****");
	}
	
	@AfterTest
	public void AfterTest()
	{
		log.info("****Dashboard Page AfterTest() Test****");
	}
	@BeforeMethod
	public void setUp()
	{
		log.info("****Dashboard Page BeforeMethod()****");
		initialize();
		loginPgae=new LoginPage();
		dashboardpage=loginPgae.login();		
	}
	
	
    @AfterMethod
    public void tearDown()
    {
    	log.info("****Dashboard Page AfterMethod()****");
	  driver.quit();
    }
    
    
    @Test(priority=1,groups={"Regression"})
    public void verifyDashboardPage()
    {
    	log.info("On Dashborad Page");
     //Assert.assertEquals(dashboardpage.getDashBoardLabel(), "Dashboard", "Not On DashBoard Page");
     //Assert.assertEquals(dashboardpage.getDashBoardLabel(), "DashBoard");
    }
    
    @Test(priority=2,groups={"Sanity"})
    public void Test2()
    {
    	throw new SkipException(" Test2() method is skipped");
    	//log.info("On Dashborad Page:Test2()");
     //Assert.assertEquals(dashboardpage.getDashBoardLabel(), "Dashboard", "Not On DashBoard Page");
     //Assert.assertEquals(dashboardpage.getDashBoardLabel(), "DashBoard");
    }
    
    @Test(priority=3,groups={"Regression"})
    public void Test3()
    {
    	log.info("On Dashborad Page:Test3()");
     //Assert.assertEquals(dashboardpage.getDashBoardLabel(), "Dashboard", "Not On DashBoard Page");
     //Assert.assertEquals(dashboardpage.getDashBoardLabel(), "DashBoard");
    }
 }
 
 
