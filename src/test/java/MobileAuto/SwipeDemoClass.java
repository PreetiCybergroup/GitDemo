package MobileAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeDemoClass extends BaseClass {

	@Test
	public void swipeActions() throws InterruptedException
	{
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
	WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
	Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "true");
	//SwipeActions
	swipeActions(firstImage);
	Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "false");
	
	Thread.sleep(2000);
	
	}
	
}
