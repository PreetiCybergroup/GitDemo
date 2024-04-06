package EcommerceApp;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
	AndroidDriver driver;
	@BeforeClass
	public void configureApp() throws MalformedURLException
	{
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("Android Phone");
	    options.setApp("D:\\Automation\\App\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		//options.setChromedriverExecutable("C:\\Users\\SAJAL  GUPTA\\.appium\\node_modules\\appium-uiautomator2-driver\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4788"), options);

	}
	
	public void longPressEvent(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId()),
				"duration",2000);
	}
	
	public void scrollBarActions() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		boolean canScrollMore;
		
		do
		{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
			
		} while(canScrollMore);
		
		Thread.sleep(2000);
		
	}
	
	public void swipeActions(WebElement firstImage)
	{
		((JavascriptExecutor)driver).executeScript("mobile:swipeGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)(firstImage)).getId(),
				"direction", "left",
				"percent", 0.25));
	}
	
	public void dragNDropActions(WebElement dragElement)
	{
		driver.executeScript("mobile:dragGesture", ImmutableMap.of("elementId", ((RemoteWebElement)(dragElement)).getId(),
                "endX", 616,
                "endY", 587));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}



