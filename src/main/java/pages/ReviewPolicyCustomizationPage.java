package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utils.TestUtils;

public class ReviewPolicyCustomizationPage extends TestBase{
	
	
	public ReviewPolicyCustomizationPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}

	
    @FindBy(xpath="//div[@class='ibm-right ibm-padding-content']/button")
    WebElement submitBtn;

    @FindBy(xpath="//button[@id='ibm-pagetitle-h1' and contains(text(),'Review Policy Customization')]")
    WebElement ReviewPolCustomizeLabel;
    
	public void verifyPolicyCustomizationPage()
	{
		
	}
	
	public String getReviewPolCustomizeLabel()
	{
		return ReviewPolCustomizeLabel.getText();
	}
	public void clickSubmitBtn()
	{
		TestUtils.moveToElement(submitBtn);
		submitBtn.click();
	}
}
