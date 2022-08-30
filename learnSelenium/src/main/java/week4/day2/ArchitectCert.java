package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCert {

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
		driver.findElement(By.xpath("(//button[contains(text(),'Accept')])[2]")).click();
		driver.findElement(By.linkText("Resources")).click();
		
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		
		Actions action = new Actions(driver);
		
		dom.findElementByXPath("//span[text()='Learning on Trailhead']").click();
		dom.findElementByXPath("//a[text()='Salesforce Certification']").getLocation();
		action.click(dom.findElementByXPath("//a[text()='Salesforce Certification']")).build().perform();

		driver.findElement(By.xpath("(//button[contains(text(),'Accept')])[2]")).click();
		
		driver.findElement(By.cssSelector("img[alt*=Architect]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Salesforce Architect')]")).getText();
		List<WebElement> certList = driver.findElements(By.xpath("//div[contains(@class, 'title')]/a"));
		System.out.println("Available Salesforce Architect Certifications: ");
		for (WebElement webElement : certList)
			System.out.println(webElement.getText());
		
		//Click on Application Architect
		driver.findElement(By.linkText("Application Architect")).click();

		
		List<WebElement> appArchCerts = driver.findElements(By.xpath("//div[text()='Certification']/following-sibling::div/a"));
		System.out.println("\nAvailable Application Architect certifications: ");
		for (WebElement webElement : appArchCerts)
			System.out.println(webElement.getText());		
	}

}
