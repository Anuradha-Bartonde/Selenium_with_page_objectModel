package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utils.TestUtils;

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
		js.executeScript("arguments[0].click();",signInBtn);
		System.out.println(js.executeScript("window.frames.length;"));
		//js.executeScript("window.scrollBy(0,200);");
		//js.executeScript("window.scrollBy(0,-200);");
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		TestUtils.scrollToBottom();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUtils.scrollToUp();
		//js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
		//js.executeScript("window.scrollBy(300,0);");
		//signInBtn.click();
		return new DashboardPage();
	}
	
	

}
