package pages;

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
	
	public void getEnv(String env_name)
	{
		List<WebElement> env_list=driver.findElements(By.xpath("//table[@class='ibm-data-table environment-list']/tbody/tr/following-sibling::tr"));
		System.out.println("Environment List: "+env_list.size());
	}
	public String getRequsetId()
	{
		String requestId=bundleContentRequestId.getText();
		requestId=requestId.trim();
		String str=requestId.substring(requestId.indexOf(" "));
		str=str.trim();
		return str;
	}
}
