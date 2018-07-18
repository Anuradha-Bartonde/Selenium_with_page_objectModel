package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import testbase.TestBase;

public class TestUtils extends TestBase {
	public TestUtils()
	{
		super();
	}

	public static void takesScreenshot(String name)
	{
		System.out.println("In takescreenshot");
	 TakesScreenshot takeScreenshot=((TakesScreenshot)driver);
	 File srcFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
	 File destFile=new File(System.getProperty("user.dir")+"//screenshots//"+name+"_"+System.currentTimeMillis()+".png");
	 try {
		FileUtils.copyFile(srcFile,destFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public static void scrollToElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void scrollToBottom()
	{
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		
	}
	
	public static void scrollToUp()
	{
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
	}
	
	public static void scrollHorizontalToRight()
	{
		js.executeScript("window.scrollTo(document.body.scrollHeight,0);", "");
	}

	public static void scrollHorizontalToLeft()
	{
		js.executeScript("window.scrollTo(-document.body.scrollHeight,0);", "");
	}
	
	public static void scrollDownByPixels(int x)
	{
		js.executeScript("window.scrollBy(0,x);", "");
	}
	public static void scrollUpByPixels(int x)
	{
		js.executeScript("window.scrollBy(0,-x);", "");
		
	}
	public static void scrollRightByPixels(int x)
	{
		js.executeScript("windows.scrollBy(x,0);", "");
	}
	
	public static void scrollLeftByPixels(int x)
	{
		js.executeScript("windows.scrollBy(-x,0);", "");
	}
	
	public static void  moveToElement(WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
		
	}
	public boolean IsAnyFramePresent()
	{  
	  if(driver.getPageSource().contains("ifame"))
	   {
		return true;
	    }
	   else
		return false;
    }
}
