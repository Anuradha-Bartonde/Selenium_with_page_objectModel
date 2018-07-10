package pages;

import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class MyTasksPage extends TestBase {
	public MyTasksPage()
	{
		super();
		PageFactory.initElements(driver, this);
		
	}
	

}
