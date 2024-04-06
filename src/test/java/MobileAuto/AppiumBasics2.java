package MobileAuto;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class AppiumBasics2 extends BaseClass {
	@Test
	public void appiumTest() throws MalformedURLException, InterruptedException
	{
		/*
		 How to find Package and activity name
		//adb devices
		//adb shell
		//dumpsys window displays | grep -E "mCurrentFocus"
		 
		 */
		
		//AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\SAJAL  GUPTA\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js")).withIPAddress("http://127.0.0.1").usingPort(4723).build();
		//AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		//service.start();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();	
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']")).click();
		String wifiSettingText = driver.findElement(By.id("android:id/alertTitle")).getText();
		
	    Thread.sleep(3000);
		//Assert.assertEquals(wifiSettingText, "WiFi settings");
		
		driver.setClipboardText("jio 5g");
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.pressKey(new KeyEvent(AndroidKey.HOME));
		//service.stop();
		
	}

}
