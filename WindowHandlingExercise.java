package com.PracticeMavenProjects.Projects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingExercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://the-internet.herokuapp.com");
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();	
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		
		String parentWindowId = it.next();
		
		driver.switchTo().window(it.next());
		System.out.println(driver.findElement(By.xpath("//h3")).getText());
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.findElement(By.xpath("//h3")).getText());
		
		Thread.sleep(3000);
		

	}

}
