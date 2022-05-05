package com.projectName.chromeTests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	
	private WebDriver driver;

	@BeforeMethod
	public void init() {
		System.out.println("Initializing driver...");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en-US");
		driver = new ChromeDriver(options);
		System.out.println("Launching google.com");
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void search() {
		WebElement searchBox = driver.findElement(By.name("q"));
		WebElement searchBtn = driver.findElement(By.xpath("//input[@role='button' and @type='submit']"));
		
		searchBox.sendKeys("maven");
		searchBtn.submit();
		
		WebElement myDynamicElement = (new WebDriverWait(driver, Duration.ofSeconds(10)))
	              .until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));

	    List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='yuRUbf']//a/h3"));
	    		//driver.findElements(By.xpath("//div[@class='yuRUbf']"));
	    
	 // this are all the links you like to visit
	    for (WebElement webElement : findElements)
	    {
	        System.out.println(webElement.getText());
	    }
	}

}
