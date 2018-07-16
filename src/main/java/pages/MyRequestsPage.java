package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class MyRequestsPage extends TestBase {
	public MyRequestsPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}

	
   public boolean verifyRequestIdPresent(String bundleId)
   {
	List<WebElement> requestIds=driver.findElements(By.xpath("//table[@id='cc-my-request-table']/tbody/descendant::tr//td/a"));
	for(int i=0;i<requestIds.size();i++)
	{
		String id=requestIds.get(i).getText();
		System.out.println("Bundleid: "+id);
		id=id.trim();
		System.out.println("id: "+id);
		System.out.println("Equlas: "+bundleId.equalsIgnoreCase(id));
		if(bundleId.equalsIgnoreCase(id))
		{
			//requestIds.get(i).click();
			System.out.println("Request id: "+bundleId+ " Present");
			return true;			
		}
      }
	return false;
   }
   
   public String getStatusOfRequestIdExecution(String bundleId)
   {
	   List<WebElement> requestIds=driver.findElements(By.xpath("//table[@id='cc-my-request-table']/tbody/descendant::tr"));
		for(int i=0;i<requestIds.size();i++)
		{
			verifyRequestIdPresent(bundleId);
		
			//table[@id='cc-my-request-table']/tbody/descendant::tr/td[5]
			String status=requestIds.get(i).findElement(By.xpath("//td[5]")).getText();
			System.out.println("Status: "+status);
			status=status.trim();		
		    return status;
	   }
		return null;
}
}
