package MobileBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BrowserTest extends BaseBrowserTest {
	@Test
	public void openGoogle() throws InterruptedException
	{
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation");
	    Thread.sleep(3000);
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
