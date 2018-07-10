package pages;

import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class ManageEnforcementModePage extends TestBase{
	public ManageEnforcementModePage()
	{
		super();
		PageFactory.initElements(driver, this);
	}

}
