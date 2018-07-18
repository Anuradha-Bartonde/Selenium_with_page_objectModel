package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import listeners.WebEventHandlerListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public  static Properties prop;
	public  static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static Logger log;;
public TestBase()
 {
	FileInputStream fis;
	try {
		fis = new FileInputStream("D:\\Selenium_own_practice\\ibm\\src\\main\\java\\config\\config.properties");
	 prop=new Properties();
		prop.load(fis);
		log=LogManager.getLogger("CCRootLogger");
		PropertyConfigurator.configure("D:\\Selenium_own_practice\\ibm\\src\\main\\resources\\log4j.properties");
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
		//DesiredCapabilities capabilities=new DesiredCapabilities();
		//DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		//capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		//ChromeOptions options=new ChromeOptions();
		//options.merge(capabilities);
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
	js=(JavascriptExecutor)driver;
	WebEventHandlerListener handler=new WebEventHandlerListener();
	eventDriver.register(handler);
	driver=eventDriver;
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wait= new WebDriverWait(driver,50);
	driver.get(prop.getProperty("url1"));
	
}

}
