package MobileAuto;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollBarClass extends BaseClass {

	@Test
	public void scrollBarActions(String text) throws InterruptedException
	{
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Seek Bar\"));"));
	
	scrollBarActions();
	
	
	}
	
	

}
