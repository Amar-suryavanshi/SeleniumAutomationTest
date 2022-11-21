package com.PracticeMavenProjects.Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.beust.jcommander.JCommander.Builder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTranslate {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://translate.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='aCQag']//c-wiz//div[@class='zXU7Rb']//c-wiz//div//button[@aria-label='More source languages']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='Llmcnf'][normalize-space()='English'])[1]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='zXU7Rb']//c-wiz//div[@class='akczyd']//button[@aria-label='More target languages']")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		
	    Thread.sleep(2000);
		
		driver.findElement(By.xpath("//c-wiz[@class='bvzp8c DlHcnf']//div[@class='ykTHSe']//div[@class='F29iQc']//div[@class='Llmcnf'][normalize-space()='Hindi']")).click();
		
		driver.findElement(By.cssSelector("textarea[aria-label='Source text']")).sendKeys("Amar");
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@class='lRu31']")).getText());
		
		Thread.sleep(3000);
	}

}
