package com.PracticeMavenProjects.Projects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ecommerce_TutorialsNinja {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//http://tutorialsninja.com/demo/
		
		/*
		 *Implement the following
		 *
		 *Select currency as US dollar
		 *Add  any 2 products to wishlist
		 *
		 *Click on MP3 Players and get the count of all the tests present under the dropdown
		 *Search with word Mac in the search box and add all 4 items to cart
		 *Proceed to checkout
		 *If products are marked with *** then remove those products from the cart and get the total
		 *cart value
		 *if your total cart value exceeds more than 5000 dollars then testcase fails otherwise pass
		 *
		 */
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		HitURL(driver);
		SelectCurrency(driver,wait);
		
		//Add Items to Wishlist
		int size = WishList(driver);
		System.out.println("No of items added to wishlist are " + "" + size );
		
		Thread.sleep(2000);
		
		//Get the count of the all the tests
		TestCount(driver);
		
		Thread.sleep(3000);
		//Add Mac related products in the cart
		int macSize = AddMacProducts(driver);
		System.out.println("No of items related to Mac are " + "" + macSize );
		
		//Checkout
		driver.findElement(By.cssSelector("button.btn-block.btn-lg")).click();
		driver.findElement(By.xpath("//strong[normalize-space()='Checkout']")).click();
		System.out.println(driver.getTitle());
		

	}
	
	static void HitURL(WebDriver driver)
	{
		driver.get("http://tutorialsninja.com/demo/");
	}
	
	static void SelectCurrency(WebDriver driver , WebDriverWait wait) throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		WebElement currency = driver.findElement(By.xpath("//button[@name='EUR']"));
		wait.until(ExpectedConditions.visibilityOf(currency)).click();
		Thread.sleep(5000);
	}
	
	static int WishList(WebDriver driver) throws InterruptedException
	{
		List<WebElement> items = driver.findElements(By.xpath("//button[@data-original-title=\"Add to Wish List\"]"));
		
		for(int i=0 ; i<items.size();i++)
		{
			driver.findElements(By.xpath("//button[@data-original-title=\"Add to Wish List\"]")).get(i).click();
			Thread.sleep(1000);
		}

		return items.size();
		
	}
	
	static void TestCount(WebDriver driver)
	{
		driver.findElement(By.xpath("//li/a[contains(text(),'MP3 Players')]")).click();
		int size = driver.findElements(By.xpath("//a[contains(text(),'test')]")).size();
		System.out.println("No of test links are " + size);
		
	}
	
	public static int AddMacProducts(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.cssSelector("input[name='search']")).sendKeys("Mac");
		Thread.sleep(2000);
		List<WebElement> macProducts = driver.findElements(By.xpath("//button/span[contains(text(),'Add to Cart')]"));
		
		for(int a=1 ; a <= macProducts.size(); a++)
		{
			//System.out.println(macProducts.size());
			driver.findElements(By.xpath("//button/span[contains(text(),'Add to Cart')]")).get(a).click();
		}
		
		return macProducts.size();
		
	}

}
