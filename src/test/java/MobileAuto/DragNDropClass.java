package MobileAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragNDropClass extends BaseClass {

	@Test
	public void dragActions() throws InterruptedException
	{
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	WebElement dragElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	dragNDropActions(dragElement);
	String dropText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
	Assert.assertEquals("Dropped!", dropText);
	Thread.sleep(5000);	
	
	}
	
}
