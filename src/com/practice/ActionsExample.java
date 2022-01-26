package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/buttons");
		
		driver.manage().window().maximize();
		
		//click
		WebElement button1 = driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		Actions ac = new Actions(driver);
		ac.click(button1).build().perform();
		
		//right click - contextClick
		WebElement button2 = driver.findElement(By.id("rightClickBtn"));
		ac.contextClick(button2).build().perform();
		
		//double click
		WebElement button3 = driver.findElement(By.id("doubleClickBtn"));
		ac.doubleClick(button3).build().perform();
		
		//moveToElement
		driver.navigate().to("https://www.amazon.in/");
		
		Thread.sleep(1000);
		
		WebElement biotique = driver.findElement(By.xpath("(//img[contains(@alt,'Biotique')])[1]"));
		ac.moveToElement(biotique).build().perform();
		
		ac.click(biotique).build().perform();
		
		//dragAndDrop
		driver.navigate().to("http://www.leafground.com/pages/drop.html");
		
		WebElement drag = driver.findElement(By.id("draggable"));
		
		WebElement drop = driver.findElement(By.id("droppable"));
		ac.dragAndDrop(drag, drop).build().perform();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
