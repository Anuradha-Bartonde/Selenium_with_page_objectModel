package pages;

import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class MyRequestsPage extends TestBase {
	public MyRequestsPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}

}
