package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;

import utils.TestUtils;

public class WebEventHandlerListener implements WebDriverEventListener{

	public void afterAlertAccept(WebDriver arg0) {
		System.out.println("Alert Accepted");
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		System.out.println("Alert Dismissed");
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1,
			CharSequence[] arg2) {
		System.out.println();	
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		//System.out.println("Element is clicked");			
	}

	public void afterFindBy(By by, WebElement element, WebDriver arg2) {
		//System.out.println("Found Element: ");
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		System.out.println();	
	}

	public void afterNavigateForward(WebDriver arg0) {
		System.out.println();
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		System.out.println();
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		System.out.println();
		
	}

	public void afterScript(String arg0, WebDriver arg1) {
		System.out.println();
		
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println();
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		System.out.println();
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		System.out.println();
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1,
			CharSequence[] arg2) {
		System.out.println();
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println();
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println();
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		System.out.println();
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		System.out.println();
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		System.out.println();
		
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		System.out.println();
		
	}

	public void beforeScript(String arg0, WebDriver driver) {
		System.out.println();
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver driver) {
		System.out.println();
		
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Error: "+error.getStackTrace());
		
	}

}
