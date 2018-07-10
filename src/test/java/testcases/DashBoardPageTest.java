package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

	@BeforeMethod
	public void setUp()
	{
		initialize();
		loginPgae=new LoginPage();
		dashboardpage=loginPgae.login();		
	}
	
	
    @AfterMethod
    public void tearDown()
    {
	  //driver.quit();
    }
    
    
    @Test
    public void verifyDashboardPage()
    {
     Assert.assertEquals(dashboardpage.getDashBoardLabel(), "Dashboard", "Not On DashBoard Page");
     //Assert.assertEquals(dashboardpage.getDashBoardLabel(), "DashBoard");
    }
    
 }
 
