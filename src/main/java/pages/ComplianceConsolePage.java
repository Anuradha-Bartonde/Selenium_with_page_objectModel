package pages;

import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class ComplianceConsolePage extends TestBase{
	public ComplianceConsolePage()
	{
		super();
		PageFactory.initElements(driver, this);
	}

}
