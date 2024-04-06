package MobileAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

@Test
public class LongPressClass extends BaseClass {
	public void longPressButton() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		
		longPressEvent(peopleNames);
		String text = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(text, "Sample menu");
		Thread.sleep(2000);
		
		
	}

}
