package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Absolute {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asus\\eclipse-workspace_Practice\\SeleniumPractice\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://en-gb.facebook.com/");

		driver.manage().window().maximize();

		WebElement email = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div/div/form/div/div/input"));
		email.sendKeys("snega@gmail.com");

		WebElement pass = driver.findElement(
				By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div/div/form/div/div[2]/div/input"));
		pass.sendKeys("abc12345");

		WebElement login = driver
				.findElement(By.xpath("html/body/div/div[2]/div/div/div/div/div[2]/div/div/form/div[2]/button"));
		login.click();

	}
}
