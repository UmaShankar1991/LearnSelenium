package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookRegister {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Step 1: Download and set the path 
		// Step 2: Launch the chromebrowser
		// Step 3: Load the URL https://en-gb.facebook.com/
		// Step 4: Maximise the window
		// Step 5: Add implicit wait
		// Step 6: Click on Create New Account button
		// Step 7: Enter the first name
		// Step 8: Enter the last name
		// Step 9: Enter the mobile number
		// Step 10: Enter the password
		// Step 11: Handle all the three drop downs
		// Step 12: Select the radio button "Female" 
		            
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[contains(text(),'optional')]")).click();
		//driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("testfirstname");
		driver.findElement(By.name("lastname")).sendKeys("testlastname");
		driver.findElement(By.name("reg_email__")).sendKeys("test@gmal.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("testpass");
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		Select selDay = new Select(day);
		Select selMonth = new Select(month);
		Select selYear = new Select(year);
		selDay.selectByValue("25");
		selMonth.selectByVisibleText("Jan");
		selYear.selectByValue("1999");
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
	}

}
