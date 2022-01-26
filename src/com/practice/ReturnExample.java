package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReturnExample {
	
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asus\\eclipse-workspace_Practice\\SeleniumPractice\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.worldometers.info/coronavirus/");

		driver.manage().window().maximize();
		
		List<WebElement> headers = driver.findElements(By.tagName("th"));
		
		
		for (int i = 0; i < headers.size(); i++) {
			
			String text = headers.get(i).getText();
			System.out.println(text);
			
			
			
		}
}
	
	
	
	
	
}
