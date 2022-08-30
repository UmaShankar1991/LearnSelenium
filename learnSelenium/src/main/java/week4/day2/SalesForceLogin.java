package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		String homeWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		List<String> winList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(winList.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		System.out.println("Title of new page is: "+driver.getTitle());
		driver.switchTo().window(homeWindow);
		driver.quit();
		
		
	}

}
