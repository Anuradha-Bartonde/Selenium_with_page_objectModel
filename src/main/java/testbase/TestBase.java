package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import listeners.WebEventHandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public  static Properties prop;
	public  static WebDriver driver;
	public static WebDriverWait wait;
public TestBase()
 {
	FileInputStream fis;
	try {
		fis = new FileInputStream("D:\\Selenium_own_practice\\ibm\\src\\main\\java\\config\\config.properties");
	 prop=new Properties();
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
public void  initialize()
{
	String browseName=prop.getProperty("browser");
	
	if(browseName.equalsIgnoreCase("firefox"))
	 {
		System.out.println( System.getProperty("user.dir"));
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver.exe");
		
		driver=new FirefoxDriver();
	 }
	else if(browseName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browseName.equalsIgnoreCase("IE"))
	{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	}
	
	//Register for handling webEventListener
	EventFiringWebDriver eventDriver=new EventFiringWebDriver(driver);
	WebEventHandler handler=new WebEventHandler();
	eventDriver.register(handler);
	driver=eventDriver;
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wait= new WebDriverWait(driver,30);
	driver.get(prop.getProperty("url1"));
	
}

}
