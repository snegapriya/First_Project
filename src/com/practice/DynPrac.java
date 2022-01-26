package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.dynamic.scaffold.InstrumentedType.Frozen;

public class DynPrac {

	static int indexoftotal , indexofrecovered , indexofactive;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asus\\eclipse-workspace_Practice\\SeleniumPractice\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.worldometers.info/coronavirus/");

		driver.manage().window().maximize();
		
		List<WebElement> headers = driver.findElements(By.tagName("th"));
		
		
		for (int i = 0; i < headers.size(); i++) {
		
			String text = headers.get(i).getText();
		//	System.out.println(text);
			
			String head = text.replaceAll("\n", " ");
			
		//	System.out.println(head);
			
			if (head.equalsIgnoreCase("Total Cases")) {
				
				indexoftotal = i;
				System.out.println("Index of total cases :"+indexoftotal);
			}
			else if (head.equalsIgnoreCase("Total Recovered")) {
				
				indexofrecovered = i;
				System.out.println("Index of recovered :"+indexofrecovered);
			}
			
			else if (head.equalsIgnoreCase("Active Cases")) {
				
				indexofactive = i;
				System.out.println("Index of active cases :"+indexofactive);
				
			}
		}
			
			List<WebElement> allrow = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr"));
			
			for (int i = 0; i < allrow.size(); i++) {
				
				List<WebElement> alldata = allrow.get(i).findElements(By.tagName("td"));
				
				for (int j = 0; j <alldata.size(); j++) {
					
					if (alldata.get(j).getText().equalsIgnoreCase("USA")) {
						
						System.out.println("Total Cases :"+alldata.get(indexoftotal).getText());
						System.out.println("Recovered cases :"+alldata.get(indexofrecovered).getText());
						System.out.println("ACtive cases :"+alldata.get(indexofactive).getText());
					}
					
					
				}
				
			
			
			
			
			
			
			
	
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
