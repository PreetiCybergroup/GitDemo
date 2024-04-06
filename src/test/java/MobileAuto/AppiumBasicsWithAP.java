package MobileAuto;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class AppiumBasicsWithAP extends BaseClass {
	@Test
	public void appiumTest() throws MalformedURLException, InterruptedException
	{
		driver.executeScript("mobile:startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		Thread.sleep(3000);
		/*driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();	
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']")).click();
		String wifiSettingText = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(wifiSettingText, "WiFi settings");
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("jio 5g");
		driver.findElement(By.id("android:id/button1")).click();*/
		//service.stop();
		
	}

}
