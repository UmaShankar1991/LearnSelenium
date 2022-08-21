package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on Leads Button
		 * 
		 * 6. Click on create Lead Button
		 * 
		 * 7. Enter CompanyName using id Locator
		 * 
		 * 8. Enter FirstName using id Locator
		 * 
		 * 9. Enter LastName using id Locator
		 * 
		 * 10. Select value as Employee in Source Using SelectbyVisible text
		 * 
		 * 11. Select value as Pay Per Click Advertising in MarketingCampaignId Using SelectbyValue
		 * 
		 * 
		 * 13. Select value as Corporation in OwnerShip field Using SelectbyIndex
		 * 
		 * 14. Select value as India in Country Field Using SelectbyVisibletext
		 *  
		 * 15. Click on create Lead Button Using name Locator
		 * 
		 * 16. Get the Title of the resulting Page
		 * 
		 
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
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABC");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("firstABC");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("lastABC");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("123457890");
		driver.findElement(By.className("smallSubmit")).click();
		driver.close();

		
		}

}
