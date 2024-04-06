package EcommerceApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecommerce_tc_1 extends BaseClass {
	@Test(priority=1, enabled=false)
	public void fillform() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Preeti Gupta");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button")).click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=0, enabled=false)
	public void showToastMessage() throws InterruptedException
	{
		Thread.sleep(3000);
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button")).click();
		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
	}
	@Test
	public void addItemToCart() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Preeti Gupta");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		Thread.sleep(1000);
		int productCount = driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]")).size();
		System.out.println("Product Count = "+productCount);
		for(int i=0;i<productCount;i++)
		{
			String productName = driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]")).get(i).getText(); 
			System.out.println("Product Name = "+productName);
			if( productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
			   driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			   
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		String checkOutProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals("Jordan 6 Rings", checkOutProduct);
		//String itemCount = driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText();
		//Assert.assertEquals(itemCount, "1");
	}

}
