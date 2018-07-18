package listeners;

import java.awt.Color;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import utils.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener,ISuiteListener{
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName()+" test is Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
			TestUtils.takesScreenshot(result.getMethod().getMethodName());
		}
		
	}

	public void onTestSkipped(ITestResult result) {
			if(result.getStatus()==ITestResult.SKIP)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName()+" test is Skipped", ExtentColor.LIME));
				test.skip(result.getThrowable());
			}
		
	}

	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+" test is started");
	}

	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName()+" test is Passed", ExtentColor.GREEN));
			
		}
		
	}

	public void onFinish(ISuite suite) {
		reports.flush();
	}

	public void onStart(ISuite suite) {
		
		String suiteName=suite.getName();
		try {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extentReport_1.html");
		htmlReporter.config().setDocumentTitle("SLA UI Test automation Results");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setReportName("SLA UI Test automation Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
		reports.setSystemInfo("User Name", System.getProperty("user.name"));
		reports.setSystemInfo("Environment", "QA");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
				
	}

	

	

}
