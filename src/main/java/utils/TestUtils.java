package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testbase.TestBase;

public class TestUtils extends TestBase {
	public TestUtils()
	{
		super();
	}

	public static void takesScreenshot()
	{
		System.out.println("In takescreenshot");
	 TakesScreenshot takeScreenshot=((TakesScreenshot)driver);
	 File srcFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
	 File destFile=new File(System.getProperty("user.dir")+"//screenshots//"+System.currentTimeMillis()+".png");
	 try {
		FileUtils.copyFile(srcFile,destFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
}
