package com.PracticeMavenProjects.Projects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeysControlAndWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Limiting WebDriver Scope First to footer id and then one column in the footer
		WebElement footerLink = driver.findElement(By.id("gf-BIG"));
		WebElement footerColumns = footerLink.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		int linkcount = footerColumns.findElements(By.tagName("a")).size();
		
		for(int i=1 ; i<linkcount ; i++)
		{
			String openInNewTabKeys = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerLink.findElements(By.tagName("a")).get(i).sendKeys(openInNewTabKeys);

		}
		Thread.sleep(3000);
		Set<String> windowCount = driver.getWindowHandles();
		Iterator<String> it = windowCount.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
	}
	
}