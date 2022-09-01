package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1) Go to https://www.nykaa.com/ 2) Mouseover on Brands and Search L'Oreal
		 * Paris 3) Click L'Oreal Paris 4) Check the title contains L'Oreal
		 * Paris(Hint-GetTitle) 5) Click sort By and select customer top rated 6) Click
		 * Category and click Hair->Click haircare->Shampoo 7) Click->Concern->Color
		 * Protection 8)check whether the Filter is applied with Shampoo 9) Click on
		 * L'Oreal Paris Colour Protect Shampoo 10) GO to the new window and select size
		 * as 175ml 11) Print the MRP of the product 12) Click on ADD to BAG 13) Go to
		 * Shopping Bag 14) Print the Grand Total amount 15) Click Proceed 16) Click on
		 * Continue as Guest 17) Check if this grand total is the same in step 14 18)
		 * Close all windows
		 */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).click(driver.findElement(By.xpath("//div[text()='topbrands']//parent::div//a[text()=\"L'Oreal Paris\"]"))).build().perform();
		action.click().perform();//to remove overlay
		if(driver.getTitle().contains("L'Oreal Paris")) {
			driver.findElement(By.xpath("//span[contains(text(),'popularity')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'top rated')]")).click();
			driver.findElement(By.xpath("//span[text()='Category']")).click();
			driver.findElement(By.xpath("//span[text()='Hair']/following::span")).click();
			driver.findElement(By.xpath("//span[text()='Hair Care']/following::span")).click();
			driver.findElement(By.xpath("(//span[text()='Shampoo']/following::div[contains(@class,'checkbox')])[1]")).click();
			driver.findElement(By.xpath("//span[text()='Concern']")).click();
			driver.findElement(By.xpath("(//span[(text()='Color Protection')]/following::div[contains(@class,'checkbox')])[1]")).click();
			
			List<WebElement> filterList = driver.findElements(By.xpath("//span[contains(@class,'filter')]"));
			for (WebElement webElement : filterList) {
				if(webElement.getText().equals("Shampoo"))
					System.out.println("Filter applied with Shampoo");
					break;
			}
			String mainWindow =  driver.getWindowHandle();
			driver.findElement(By.xpath("//div[contains(text(),'Paris Colour')]")).click();
			List<String> allWinHandles = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(allWinHandles.get(1));
			
			Select selectSize = new Select(driver.findElement(By.xpath("//div[contains(text(),'inclusive')]/following::select")));
		    selectSize.selectByValue("1");//select 360ml
		    
		    System.out.println("MRP of the selected product: " +driver.findElement(By.xpath("//div[text()='inclusive of all taxes']/preceding::span[contains(text(),'₹')]")).getText());
			driver.findElement(By.xpath("(//span[contains(text(),'Add')])[1]")).click();
			
			
		}
	}

}
