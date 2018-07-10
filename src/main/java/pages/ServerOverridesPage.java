package pages;

import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class ServerOverridesPage extends TestBase{
	public ServerOverridesPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	

}
