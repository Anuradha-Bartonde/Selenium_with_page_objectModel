package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.TestBase;

public class DashboardPage extends TestBase{
	LoginPage loginpage;
	
	public DashboardPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//li[@class='userInformation']/a/child::span")
public WebElement loggedUserName;

@FindBy(xpath="//a[@id='continuous_compliance']")
public WebElement continuous_ComplianceLink;

 @FindBy(xpath="//a[@id='nav_cc_policyManagement']")
//@FindBy(xpath="//ul[@class='cc-group menu-group']/descendant::a[@id='nav_cc_policyManagement']")
public WebElement policyManagementLink;


@FindBy(xpath="//a[@id='nav_cc_serverComplianceCheck']")
public WebElement InitiateServerInspectionLink;

@FindBy(xpath="//a[@id='nav_cc_ManageComplianceMode']")
public WebElement ManageEnforcementModeLink;

@FindBy(xpath="//a[@id='nav_cc_requests']")
public WebElement MyRequestsLink;

@FindBy(xpath="//a[@id='nav_cc_tasks']")
public WebElement MyTasksLink;

@FindBy(xpath="//a[@id='nav_cc_serverOverrides']")
public WebElement ServerOverridesLink;

@FindBy(xpath="//a[@id='nav_dashboard' and contains(text(),'Dashboard']")
public WebElement DashBoardLabel;

@FindBy(xpath="//iframe[contains(@id,'LOTCCFrame')]")
WebElement frame;


public String getLoggedinUser()
{
	return loggedUserName.getText();
}

public void clickOnContinuousComplianceLink()

{
	continuous_ComplianceLink.click();
	
}

public PolicyManagementPage clickOnPolicyManagementLink()

{
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='nav_cc_policyManagement']")));
	wait.until(ExpectedConditions.visibilityOf(policyManagementLink));
	policyManagementLink.click();
	return new PolicyManagementPage();
}

public ServerOverridesPage clickOnServerOverridesLink()
{
	wait.until(ExpectedConditions.visibilityOf(ServerOverridesLink));
	ServerOverridesLink.click();
	return new ServerOverridesPage();
}

public InitiateServerInspectionPage clickOnInitiateServerInspectionLink()
{
	wait.until(ExpectedConditions.visibilityOf(InitiateServerInspectionLink));
	InitiateServerInspectionLink.click();
	return new InitiateServerInspectionPage();
}

public ManageEnforcementModePage clickOnManageEnforcementModeLink()
{
	wait.until(ExpectedConditions.visibilityOf(ManageEnforcementModeLink));
	ManageEnforcementModeLink.click();
	return new ManageEnforcementModePage();
}
public MyRequestsPage clickOnMyRequestsLink()
{
	wait.until(ExpectedConditions.visibilityOf(MyRequestsLink));
	MyRequestsLink.click();
	return new MyRequestsPage();
	
}

public MyTasksPage clickOnMyTasksLink()
{
	wait.until(ExpectedConditions.visibilityOf(MyTasksLink));
	MyTasksLink.click();
	return new MyTasksPage();
}

public ComplianceConsolePage clickOnComplianceConsoleLink()
{
	wait.until(ExpectedConditions.visibilityOf(continuous_ComplianceLink));
	continuous_ComplianceLink.click();
	return new ComplianceConsolePage();
}
public String getDashBoardLabel()
{
	 driver.switchTo().frame(frame);
	return DashBoardLabel.getText();
}
}
