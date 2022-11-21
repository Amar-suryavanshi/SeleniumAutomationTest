package com.PracticeMavenProjects.Projects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandlings {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		//SelectMonthAndDate(driver);
		
		CalendarHandlings obj = new CalendarHandlings();
		obj.SelectDateUsingStream(driver);
		
		
	}
	
	public static void SelectMonthAndDate(WebDriver driver) throws InterruptedException
	{
			driver.get("https://phptravels.net/");
			//select December 2023 from the calendar
		
			driver.findElement(By.xpath("//input[@id='checkin']")).click();
			
			while(!driver.findElement(By.cssSelector("[class=' table-condensed'] th[class='switch']")).getText().contains("December 2023"))
			{
				driver.findElement(By.cssSelector("[class=' table-condensed'] th[class='next']")).click();
			}
			
			//Select checkin Date and checkout date

			List<WebElement> allDates = driver.findElements(By.className("day"));
			
			for(int i=0; i< allDates.size();i++)
			{
				String date = driver.findElements(By.className("day")).get(i).getText();
				
				if(date.equalsIgnoreCase("10"))
				{
					driver.findElements(By.className("day")).get(i).click();
					break;
				}
			}
			Thread.sleep(3000);
		
	}
	
	public  void SelectDateUsingStream(WebDriver driver) throws InterruptedException
	{
		//Implemented Date Selection Using Java Streams
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		List<WebElement> dates = driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		dates.stream().filter(s->s.getText().contains("31")).forEach(s->s.click());
		Thread.sleep(3000);
	}
	
	
}















