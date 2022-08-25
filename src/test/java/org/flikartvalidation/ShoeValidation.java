package org.flikartvalidation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class ShoeValidation {
	
	public static void main(String[]args) throws Throwable {
		//user launch flipkart application
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		
		WebElement element = driver.findElement(By.xpath("//*[text()='✕']"));
		//
		element.click();
		
		WebElement name = driver.findElement(By.xpath("//*[@name='q']"));
		
		name.sendKeys("Mens Shoes",Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement shoes = driver.findElement(By.xpath(("(//a[@class='IRpwTa _2-ICcC'])[2]")));
		
		shoes.click();
		
      String brandname =shoes.getText();
		
		System.out.println(brandname);
		
	
		Set<String> window =driver.getWindowHandles();
		
		List<String> child= new ArrayList<>(window);
		
		driver.switchTo().window(child.get(1));
		
		
		//To webpage  ScrollDwon
		
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	WebElement down =driver.findElement(By.xpath(("//div[text()='Questions and Answers']")));
	 js.executeScript("arguments[0].scrollIntoView(true)",down);
	
	WebElement buy =driver.findElement(By.xpath(("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")));
	buy.click();
	
	  WebElement size = driver.findElement(By.xpath(("(//a[@class='_1fGeJ5 _2UVyXR _31hAvz'])[3]")));
			Thread.sleep(3000);
		    size.click();
		    Thread.sleep(3000);
			
		    WebElement cart =driver.findElement(By.xpath(("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")));
			cart.click();
			
	       Thread.sleep(3000);
//			  
			TakesScreenshot tk=(TakesScreenshot)driver;

	     File src=tk.getScreenshotAs(OutputType.FILE);
			File fetch =new File("C:\\Users\\Indiaseah Quality\\eclipse-workspace\\Jayapalvalidation\\src\\test\\java\\org\\flikartvalidation/SHOES VALIDATION");
			//To Merge the file
			FileUtils.copyFile(src,fetch);// avilable in commons IO files 

	}

}
