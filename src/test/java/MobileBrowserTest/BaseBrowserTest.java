package MobileBrowserTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseBrowserTest {
	
	AndroidDriver driver;
	@BeforeClass
	public void configureApp() throws MalformedURLException
	{
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("Android Phone");
	    options.setChromedriverExecutable("C:\\Users\\SAJAL  GUPTA\\.appium\\node_modules\\appium-uiautomator2-driver\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
