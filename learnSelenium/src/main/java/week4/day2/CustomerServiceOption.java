package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CustomerServiceOption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Assignments 3.Customer_Service_Options ====================================
		 * 1. Launch Salesforce application https://login.salesforce.com/ 2. Login with
		 * username as ramkumar.ramaiah@testleaf.com and password as Password#123 3.
		 * Click on Learn More link in Mobile Publisher 4. Click on Products and
		 * Mousehover on Service 5. Click on Customer Services 6. Get the names Of
		 * Services Available 7. Verify the title
		 */
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
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[text()='Products']").click();
		dom.findElementByXPath("//div[text()='Service']").click();

		Actions action = new Actions(driver);
		
		dom.findElementByXPath("//span[text()='Service']").click();
		dom.findElementByXPath("//a[text()='Customer Service']").getLocation();
		action.click(dom.findElementByXPath("//a[text()='Customer Service']")).build().perform();
		
		if(driver.getTitle().equals("Customer Service Tools from Service Cloud - Salesforce.com")) 
		{
		List<WebElement> serviceList = driver.findElements(By.xpath("//a[text()='Customer Service']//parent::li//child::li/a"));
		System.out.println("List of Customer services available are: ");
		for (WebElement webElement : serviceList) {
			System.out.println(webElement.getText());
		}
		System.out.println("--------------------Test Passed---------------------------");
		driver.quit();
		}
		
		else {
			System.out.println("--------------------Test Failed---------------------------");
		}
		
	}

}
