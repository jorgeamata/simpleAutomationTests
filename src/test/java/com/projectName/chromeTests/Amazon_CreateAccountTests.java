package com.projectName.chromeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_CreateAccountTests {

	private WebDriver driver;

	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-lang= sl");
		driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//input[@data-action-type='DISMISS']")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'Hola,')]")).click();
	}

	@Test
	public void createInvalidAccount() {
		System.out.println("You are on : " + driver.getTitle() + ", page");
		driver.findElement(By.id("createAccountSubmit")).click();
		System.out.println("You are on : " + driver.getTitle() + ", page");
		driver.findElement(By.id("continue")).click();
		String actualLabel = driver.findElement(By.xpath("//div[contains(text(), '6 caracteres')]")).getText();
		String expectedLabel = "Se requiere un mínimo de 6 caracteres";

		System.out.println("Actual label should be: " + actualLabel);
		Assert.assertEquals(actualLabel, expectedLabel);
	}

	@Test
	public void createValidAccount() {

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
