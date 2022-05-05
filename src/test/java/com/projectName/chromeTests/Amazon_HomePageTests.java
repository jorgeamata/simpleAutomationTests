package com.projectName.chromeTests;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_HomePageTests {
	
	private WebDriver driver;
	
	
	@BeforeMethod
	public void init() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//input[@data-action-type='DISMISS']")).click();
	}
	
	//@Test
	public void validateTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.com. Gasta menos. Sonríe más.";
		
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
		
	}
	
	//@Test
	public void printCarouselOptions() {
		List<WebElement> elements = driver.findElements(By.xpath("//li[@class='a-carousel-card']//img"));
		
		for(WebElement element : elements) {
			System.out.println(element.getAttribute("alt"));
		}
	}
	
	//@Test
	public void clickOnComputersCarousel() {
		WebElement carouselOption = driver.findElement(By.xpath("//li[@class='a-carousel-card']//img[contains(@alt, 'computers')]"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(carouselOption)).click();
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Amazon.com: Computadoras", "Title does not match");
	}
	
	//@Test
	public void clickOnVideogamesCarousel() {
		WebElement carouselOption = driver.findElement(By.xpath("//li[@class='a-carousel-card']//img[contains(@alt, 'Gamer')]"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(carouselOption)).click();
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Amazon.com: Essentials for Gamers", "Title does not match");
	}
	
	//@Test
	public void searchForAnyProduct(){
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 13");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button' and @type='submit']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Amazon.com : Iphone 13");
	}
	
	//@Test
	public void validateFilterFunctionality() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 13");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button' and @type='submit']")).click();
	}
	
	@Test
	public void openLoginPage() {
		driver.findElement(By.xpath("//span[contains(text(), 'Hola,')]")).click();
		String expectedResult = "Amazon Iniciar sesión";
		String actualResult = driver.getTitle();
		
		Assert.assertEquals(expectedResult, actualResult, "Title does not match");
		System.out.println("Title is: " + actualResult);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
