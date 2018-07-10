package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	int count=0;
	int retryLimit=3;
	public boolean retry(ITestResult result) {
		System.out.println("In retry");
		if(count<retryLimit)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
