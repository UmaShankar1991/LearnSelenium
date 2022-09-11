package week6.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedbusHighestPriced {
	
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='src']")));
		element.sendKeys("Chennai");
		driver.findElement(By.xpath("(//input[@id='src']/following-sibling::ul/li)[1]")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("(//input[@id='dest']/following-sibling::ul/li)[1]")).click();
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
		driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//table[contains(@class,'monthTable')]/tbody/tr/td[text()=12]")).click();
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		System.out.println("Total Number of "+ driver.findElement(By.xpath("//span[contains(text(),'found')]")).getText());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i =0; i<50; i++) {
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Bus Distance')]")));
		
		List<WebElement> travelsName = driver.findElements(By.xpath("//div[contains(@class,'travels')]"));
		
		List<WebElement> fare = driver.findElements(By.xpath("//div[contains(@class,'fare')]//div[contains(@class,'fare d-block')]//span"));
		
		List<String> namelist = new ArrayList<String>();
		List<Integer> farelistsort = new ArrayList<Integer>();
		for (WebElement element1 : travelsName)
			namelist.add(element1.getText());
		
		for (WebElement element1 : fare)
			farelistsort.add(Integer.valueOf(element1.getText()));
		
		
		
		List<Integer> farelist = new ArrayList<Integer>(farelistsort);
		Collections.sort(farelistsort);
		System.out.println("Highest priced Bus/Travels: " +namelist.get(farelist.indexOf(farelistsort.get(farelistsort.size()-1))));
		
		
		}
	}


