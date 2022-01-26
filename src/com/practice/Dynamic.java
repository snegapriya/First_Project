package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic {

 static	int indexOfTotal , indexOfRecovered , indexOfActive;
 
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asus\\eclipse-workspace_Practice\\SeleniumPractice\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.worldometers.info/coronavirus/");

		driver.manage().window().maximize();
		
		List<WebElement> allheaders = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/thead/tr/th"));
		
		for (int i = 0; i < allheaders.size(); i++) {
			
			String text = allheaders.get(i).getText();
		//	System.out.println(text);
			
			String head = text.replaceAll("\n", " ");
		//	System.out.println(head);
			if (head.equalsIgnoreCase("Total Cases")) {
				
				indexOfTotal = i;
				System.out.println("index of total cases :"+i);
			}
			else if (head.equalsIgnoreCase("Total Recovered")) {
				
				indexOfRecovered = i ;
				System.out.println("index of recovered :"+i);
			}
			else if (head.equalsIgnoreCase("Active Cases")) {
				
				indexOfActive = i;
				System.out.println("index of active :"+i);
			}
		}
		
		List<WebElement> allrow = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr"));
		
		for (int i = 0; i < allrow.size(); i++) {
			
			List<WebElement> alldata = allrow.get(i).findElements(By.tagName("td"));
			
			for (int j = 0; j < alldata.size(); j++) {
				
				if (alldata.get(j).getText().equalsIgnoreCase("India")) {
					
				
				System.out.println(alldata.get(indexOfTotal).getText());
				System.out.println(alldata.get(indexOfRecovered).getText());
				System.out.println(alldata.get(indexOfActive).getText());
				}
			}
		}
		
		
		
		
		
		
		
		
	}
}
