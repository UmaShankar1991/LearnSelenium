package  week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main
		 
		Delete Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Phone
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
*/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//		Thread.sleep(10000);
//		
//		String leadID = driver.findElement(By.xpath("(//span[text()='Lead List']//following::tbody/tr)[1]/td[1]//a")).getText();
//		System.out.println("Lead ID: "+leadID);
//		driver.findElement(By.xpath("(//span[text()='Lead List']//following::tbody/tr)[1]/td[1]//a")).click();
//		driver.findElement(By.linkText("Delete")).click();
//		driver.findElement(By.linkText("Find Leads")).click();
//		driver.findElement(By.xpath("//span[text()='Phone']")).click();
//		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("123457890");
//		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(10000);
		String actualResult = driver.findElement(By.xpath("//div[contains(@class,'paging')]")).getText();
		
		System.out.println(actualResult);
		if(actualResult.contentEquals("No records to display"))
			System.out.println("Lead deleted successfuly");
		else
			System.out.println("Lead not deleted successfuly");
			
	}
}