package pages;

import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class InitiateServerInspectionPage extends TestBase{
	public InitiateServerInspectionPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}

}
