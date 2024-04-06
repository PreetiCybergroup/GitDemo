package EcommerceApp;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecommerce_tc_4 extends BaseClass {
	@Test
	public void checkProductAmountDuringCheckout() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Preeti Gupta");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(500);
		//Product Page
		driver.findElements(By.xpath("//android.widget.TextView[@text ='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text ='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Checkout Page
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
        List<WebElement> productList = driver.findElements(By.xpath("//android.widget.TextView[@resource-id = 'com.androidsample.generalstore:id/productPrice']"));
        int productCount = productList.size();
        
        System.out.println("Product count: "+productCount);
        double total_price = 0.0;
        for(int i = 0; i<productCount; i++)
		{
        	 String productPrice = productList.get(i).getText();
        	 Double price = Double.parseDouble(productPrice.substring(1));
		     total_price = total_price + price;
		     System.out.print("Total price: "+total_price);
		}
        String formatedPrice = String.format("$ %.2f", total_price);
        System.out.print("Actual Price :"+formatedPrice);
        String displayedPrice =  driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Assert.assertEquals(formatedPrice, displayedPrice);
        
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressEvent(ele);
        
        String terms_Condition = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
        Assert.assertEquals(terms_Condition, "Terms Of Conditions");
        
        driver.findElement(By.id("android:id/button1")).click();
        
        driver.findElement(By.xpath("//android.widget.CheckBox")).click();
        
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(3000);
        
       Set<String> contexts = driver.getContextHandles();
       for(String context : contexts)
       {
    	   System.out.println(context);
       }
       driver.context("WEBVIEW_com.androidsample.generalstore");
       Thread.sleep(3000);
       driver.findElement(By.name("q")).sendKeys("Automation");
       Thread.sleep(3000);
       driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
       driver.pressKey(new KeyEvent(AndroidKey.BACK));
       driver.context("NATIVE_APP");
	}

}
