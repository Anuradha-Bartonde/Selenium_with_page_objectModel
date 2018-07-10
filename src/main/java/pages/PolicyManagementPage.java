package pages;

import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class PolicyManagementPage extends TestBase {
	public PolicyManagementPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	

}
