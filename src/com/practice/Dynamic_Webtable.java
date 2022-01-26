
package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Webtable {

	static int indexOfTotalCases, indexOfTotalRecovered , indexOfActiveCases;
	static String country = "USA";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asus\\eclipse-workspace_Practice\\SeleniumPractice\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.worldometers.info/coronavirus/");

		driver.manage().window().maximize();

		// Iterate all headers
		List<WebElement> allheaders = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']//thead/tr/th"));

		for (int i = 0; i < allheaders.size(); i++) {

			String text = allheaders.get(i).getText();
			// System.out.println(text);

			// replace newline to space
			String headers = text.replaceAll("\n", " ");
			// System.out.println(headers);

			if (headers.equalsIgnoreCase("Total Cases")) {

				indexOfTotalCases = i;
				System.out.println("IndexOfTotalCases :"+i);
			} 
			else if (headers.equalsIgnoreCase("Total Recovered")) {

				indexOfTotalRecovered = i;
				System.out.println("IndexOfTotalRecovered :"+i);
			} 
			else if (headers.equalsIgnoreCase("Active Cases")) {

				indexOfActiveCases = i;
				System.out.println("IndexOfActiveCases :"+i);
			}
		}
		
		//traverse into body
		List<WebElement> allRows = driver.findElements(By.xpath("//table/tbody[1]/tr"));
		
		//Iterate row
		for (int i = 0; i < allRows.size(); i++) {
			
			List<WebElement> allData = allRows.get(i).findElements(By.tagName("td"));
			
			//Iterate column
			for (int j = 0; j < allData.size(); j++) {
				
				if (allData.get(j).getText().equalsIgnoreCase(country)) {
					
					System.out.println("Total cases is India :"+allData.get(indexOfTotalCases).getText());
					
					System.out.println("Total recovered  cases in India :"+allData.get(indexOfTotalRecovered).getText());
					
					System.out.println("Total active cases is India :"+allData.get(indexOfActiveCases).getText());
				}
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
