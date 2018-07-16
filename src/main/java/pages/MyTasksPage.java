package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class MyTasksPage extends TestBase {
	public MyTasksPage()
	{
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public ReviewPolicyCustomizationPage clickOnBundleId(String bundleId)
	{
		List<WebElement> requestIds=driver.findElements(By.xpath("//table[@id='serverDataList']/tbody/descendant::tr//td/a"));
		for(int i=0;i<requestIds.size();i++)
		{
			String id=requestIds.get(i).getText();
			System.out.println("Bundleid: "+id);
			id=id.trim();
			System.out.println("id: "+id);
			System.out.println("Equlas: "+bundleId.equalsIgnoreCase(id));
			if(bundleId.equalsIgnoreCase(id))
			{
				requestIds.get(i).click();
				System.out.println("Clicked button");
				return new ReviewPolicyCustomizationPage();
				
			}
		}
		
		return new ReviewPolicyCustomizationPage();
	}

}
