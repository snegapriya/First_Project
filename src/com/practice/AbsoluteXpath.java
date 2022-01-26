package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbsoluteXpath {
	
	public static int total_Cases_Index, country_Index;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asus\\eclipse-workspace_Practice\\SeleniumPractice\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.worldometers.info/coronavirus/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> headers = driver.findElements(By.xpath("//table/thead/tr/th"));
		
		for (int i = 0; i < headers.size(); i++) {
			
			String head = headers.get(i).getText().replaceAll("\n", " ");	
			
			System.out.println(head);
			
			if (headers.get(i).getText().equalsIgnoreCase("Total Cases")) {
			
				total_Cases_Index  = i;
				
				
			}
			
			else if (headers.get(i).getText().contains("Country")) {
				
				country_Index = i;
				
			}
			
			
			
			
		}
		
		
		
		
	}
}
