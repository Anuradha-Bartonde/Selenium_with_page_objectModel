package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyRequestsPage;
import pages.MyTasksPage;
import pages.PolicyManagementPage;
import pages.ReviewPolicyCustomizationPage;
import testbase.TestBase;

public class PolicyManagementPageTest extends TestBase{
	
	LoginPage loginPgae;
	DashboardPage dashboardpage;
	PolicyManagementPage policyManagementPage;
	MyTasksPage myTasksPage;
	MyRequestsPage myRequestsPage;
	ReviewPolicyCustomizationPage reviewPolicyCustomizationPage;
	//Logger log=Logger.getLogger(PolicyManagementPageTest.class);

	
	public PolicyManagementPageTest()
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
		//clickOnMyTasksLink
		//PropertyConfigurator.configure("D:/Selenium_own_practice/ibm/src/main/resources/log4j.properties");
		
	}
	
	
    @AfterMethod
    public void tearDown()
    {
	  //driver.quit();
    }
    
    @Test(groups={"Sanity"})

    public void createNewEnvironment()
    {
    	//log.info("****************Start of createNewEnvironment() method *****************");
    	
    	try {
    		policyManagementPage.clickOnInitiatePolicyCustomizationBtn();
        	policyManagementPage.getEnv("Env1");
        	policyManagementPage.clickOnAddNewEnvironmentBtn();
        	policyManagementPage.enterEnvName("Env1");
        	policyManagementPage.selectEnvReleaseNumber("20.6.0");
        	policyManagementPage.scrollToAddToBundleBtn();
			Thread.sleep(1000);
			policyManagementPage.clickOnAddToBundleBtn();
			Thread.sleep(1000);
			String requestId=policyManagementPage.getRequsetId();
			System.out.println("Request Id captured while submitting bundle: "+requestId);
			Thread.sleep(2000);
			policyManagementPage.clickOnSubmitBundleBtn();
			Thread.sleep(5000);
	    	policyManagementPage.clickCancelOnSubmitBundleConfirmationDialog();
	    	myTasksPage=dashboardpage.clickOnMyTasksLink();
	    	reviewPolicyCustomizationPage=myTasksPage.clickOnBundleId(requestId);
	    	Thread.sleep(5000);
	    	reviewPolicyCustomizationPage.clickSubmitBtn();
	    	Thread.sleep(5000);
	    	myRequestsPage=dashboardpage.clickOnMyRequestsLink();
	    	String status=myRequestsPage.getStatusOfRequestIdExecution(requestId);
	    	
	    	Assert.assertEquals(status, "Execution Successful", "Create new environment execution Failed");
	    	
	    	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//log.info("****************End of createNewEnvironment() method *****************");
    	
    }
    
    @DataProvider(name="passEnvData")
    public void  passEnvData() throws IOException
    {
    	Workbook book;
    	Sheet sheet;
    	String fileName="D:/Selenium_own_practice/ibm/src/main/java/testdata/Env_data.xlsx";
    	String exten=fileName.substring(fileName.indexOf("."));
    	System.out.println("File Extension: "+exten);
  
    	try {
			FileInputStream fis=new FileInputStream(fileName);
			if(exten.equalsIgnoreCase(".xls"))
			{
				book=new HSSFWorkbook(fis);
			}
			else if(exten.equalsIgnoreCase(".xlsx"))
			{
				book=new HSSFWorkbook(fis);
				
			}
			else
			{
				book=new HSSFWorkbook(fis);	
			}
			
			sheet=book.getSheet("Sheet1");
			int totalRow=sheet.getLastRowNum();
			for(int i=1;i<totalRow;i++)	
			{
				int totalCells=sheet.getRow(i).getLastCellNum();
				for(int j=0;j<totalCells;j++)
				{
				String env_name=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println("Env Name: "+env_name);
				String releasenumber=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println("Release number:" +releasenumber);
				}
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
    }
    	
    
    
}
