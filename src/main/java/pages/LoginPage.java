package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class LoginPage extends TestBase{
	DashboardPage dashboardPage;

	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="continuebutton")
	public WebElement continueBtn;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(how=How.ID, using="signinbutton")
	public WebElement signInBtn;
	
	@FindBy(xpath="//a[@href='slaui']")
	public WebElement ExternalUiLink;
	
	public DashboardPage login()
	{
		
		System.out.println("In login function");
		ExternalUiLink.click();
		username.sendKeys(prop.getProperty("username"));
		continueBtn.click();
		password.sendKeys(prop.getProperty("password"));
		signInBtn.click();
		return new DashboardPage();
	}
	
	

}
