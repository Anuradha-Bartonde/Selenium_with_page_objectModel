package pages;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import testbase.TestBase;
import utils.TestUtils;

public class PolicyManagementPage extends TestBase {
	Alert alert;
	public PolicyManagementPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="initiate_policy_customization_button")
	WebElement InitiatePolicyCustomizationBtn;
	
	@FindBy(id="add_new_environment_button")
	WebElement AddNewEnvironmentBtn;
	
	@FindBy(xpath="//input[@name='env_name']")
	WebElement EnvTextBox;
	
	@FindBy(xpath="//select[@id='environmentReleaseNumber']")
	WebElement EnvReleaseDropDown;
	

	@FindBy(xpath="//button[@id='addBundle']")
	WebElement AddToBundleBtn;
	
	@FindBy(xpath="//button[@id='submit_bundle_action']")
	WebElement SubmitBundleBtn;
	
	
	//@FindBy(xpath="//button[@id='NS_okCancelOKButtonn']")
	@FindBy(xpath="//div[@id='ibm-overlaywidget-NS_OKCancelOverlay' and @role='dialog']/descendant::button[@id='NS_okCancelOKButton']")
	WebElement OkBtnOnSubmitBundleDialog;
	
    @FindBy(xpath="//div[@id='ibm-overlaywidget-NS_OKCancelOverlay' and @role='dialog']/descendant::button[@id='NS_okCancelCancelButton']")
	//@FindBy(xpath="//button[@id='NS_okCancelCancelButton']")
	WebElement CancelBtnOnSubmitBundleDialog;
   
	
	//@FindBy(xpath="//p[@id='NS_okCancelDialogMessage']")
	WebElement SubmitBundleDialogMessageBox;
	
	@FindBy(xpath="//div[@id='ibm-overlaywidget-NS_OKCancelOverlay' and @role='dialog']")
	WebElement Dialog;
	
	@FindBy(xpath="//div[@class='bundle-request']/descendant::li/b[contains(text(),'Request')]")
	WebElement bundleContentRequestId;
	
	//@FindBy(xpath="//table[@id='cc-environment-summary-table']")
	
	@FindBy(xpath="//select[@id='environmentPageSizeSelect']")
	WebElement showEntriesDropDown;
	
	@FindBy(xpath="//ul[@id='ember1900']/li/following-sibling::li/a")
	WebElement PaginationBtns;
	
	@FindBy(xpath="//table[@id='cc-environment-summary-table']/following-sibling::ul/li/following-sibling::li[contains(@class,'next')]")
	WebElement NextPgnBtn;
	
	public void clickOnInitiatePolicyCustomizationBtn()
	{
		InitiatePolicyCustomizationBtn.click();
	}

	public void clickOnAddNewEnvironmentBtn()
	{
		AddNewEnvironmentBtn.click();
	}
	
	public void enterEnvName(String envName)
	{
		EnvTextBox.sendKeys(envName);
	}
	
	public void selectEnvReleaseNumber(String Releasenumber)
	{
		Select select=new Select(EnvReleaseDropDown);
		select.selectByVisibleText(Releasenumber);
		
	}
	
	public void clickOnAddToBundleBtn()
	{
		AddToBundleBtn.click();
	}
	
	public void clickOnSubmitBundleBtn()
	{
		SubmitBundleBtn.click();
	}
	
	public void clickOkOnSubmitBundleConfirmationDialog()
	
	{
		wait.until(ExpectedConditions.elementToBeClickable(OkBtnOnSubmitBundleDialog));
		OkBtnOnSubmitBundleDialog.click();
		
	}
	
	public void clickCancelOnSubmitBundleConfirmationDialog()
	{
		 
		wait.until(ExpectedConditions.visibilityOf(OkBtnOnSubmitBundleDialog));
		System.out.println("Cancel button display: "+OkBtnOnSubmitBundleDialog.isDisplayed());	
	    TestUtils.moveToElement(OkBtnOnSubmitBundleDialog);
		
		OkBtnOnSubmitBundleDialog.click();
		
	}
	
	public String getSubmitBundleDialogMessage()
	{
		return SubmitBundleDialogMessageBox.getText();
	}
	
	public void scrollToAddToBundleBtn()
	{
		TestUtils.scrollToElement(AddToBundleBtn);
	}
	
	public boolean getEnv(String env_name)
	{
		int totalNoOfPages=getNumberOfPages();
	     int currentPage=1;
			
		while(totalNoOfPages!=0)
		{
		 System.out.println("In Outer while");
		List<WebElement> env_list=driver.findElements(By.xpath("//table[@id='cc-environment-summary-table']/tbody/descendant::tr/td[2]/a"));
		System.out.println("Number of elements on page "+currentPage+" is"+env_list.size());
		Iterator<WebElement> itr=env_list.iterator();
		while(itr.hasNext())
		{
			WebElement env=itr.next();
			String e=env.getText();
			System.out.println("Env Name: "+e);
			if(e.equals(env_name))
			{
				System.out.println("Env found on page: "+currentPage);
				return true;
			}
		 }		
		System.out.println("Env not found on page "+currentPage);
		currentPage++;
		totalNoOfPages--;
		clickOnNextPaginationLink();
		
		} 
		
		return false;
	}
	public String getRequsetId()
	{
		String requestId=bundleContentRequestId.getText();
		requestId=requestId.trim();
		String str=requestId.substring(requestId.indexOf(" "));
		str=str.trim();
		return str;
	}
	public void selectEntriesInDropDown(String count)
	{
		Select select=new Select(showEntriesDropDown);
		select.selectByVisibleText(count);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnPaginationBtns(int pageNumber)
	
	{
		System.out.println("In clickOnPaginationBtns() "+"Page number: "+pageNumber);
		List<WebElement> paginationBtnCount=driver.findElements(By.xpath("//ul[@id='ember1900']/li/following-sibling::li/a"));
		Iterator<WebElement> itr=paginationBtnCount.iterator();
		while(itr.hasNext())
		{
		 WebElement PageLink=itr.next();
		 String pageNo=Integer.toString(pageNumber);
		 if(PageLink.getText().trim()==pageNo)
		 {
		   TestUtils.scrollToElement(PageLink);
		   PageLink.click();
		   try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		   break;
		 }
		 
		}
	}
	public int getNumberOfPages()
	{
		int noOfPages=0;
		try {
			Thread.sleep(4000);			
			TestUtils.scrollToBottom();
			List<WebElement> paginationBtnCount=driver.findElements(By.xpath("//table[@id='cc-environment-summary-table']/following-sibling::ul/descendant::li/a"));
			   System.out.println("Before pagination number: "+paginationBtnCount.size());
				WebElement paginationBtn=paginationBtnCount.get(paginationBtnCount.size()-2);
				noOfPages=Integer.parseInt(paginationBtn.getText().trim());
				System.out.println("Number of pages: "+noOfPages);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		return noOfPages;
	}
	
 public void clickOnNextPaginationLink()
 {
     try {
		 Thread.sleep(4000);
		 wait.until(ExpectedConditions.visibilityOf(NextPgnBtn));
		 TestUtils.moveToElement(NextPgnBtn);	 
		 String href=NextPgnBtn.getAttribute("href");
		 NextPgnBtn=NextPgnBtn.findElement(By.linkText("Next"));
		 NextPgnBtn.click(); 
		 Thread.sleep(6000);
		 
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
 }
}
