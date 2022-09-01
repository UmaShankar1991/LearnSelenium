package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mongodb.MapReduceCommand.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		/*  1. Launch https://www.snapdeal.com/
			2. Go to Mens Fashion
			3. Go to Sports Shoes
			4. Get the count of the sports shoes
			5. Click Training shoes
			6. Sort by Low to High
			7. Check if the items displayed are sorted correctly
			8. Select the price range (900-1200)
			9. Filter with color Navy 
			10. Verify the all applied filters 
			11. Mouse Hover on first resulting Training shoes
			12. click QuickView button
			13. Print the cost and the discount percentage
			14. Take the snapshot of the shoes.
			15. Close the current window
			16. Close the main window*/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"))).click(driver.findElement(By.xpath("//div[@id='category1Data']//span[text()='Sports Shoes']"))).build().perform();
		System.out.println("Total results: "+driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText().replace('(',' ').replace(')',' ').trim());
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Sort')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Sort by')]/following::ul//li[@data-sorttype='plth']")).click();
		Thread.sleep(1000);
		List<WebElement> priceElementList = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
		List<Integer> priceList = new ArrayList<Integer>();
	
		for (WebElement webElement : priceElementList)
			priceList.add(Integer.valueOf(webElement.getText().replace("Rs. ", "").replace(",", "")));
		System.out.println(priceList);
		
		//check if price list is ordered or not
		Boolean isListOrdered = true;
		int temp =priceList.get(0);
		for(int i =1; i<priceList.size(); i++) {
			if(temp > priceList.get(i)) {
				isListOrdered = false;
				break;
			}
			temp = priceList.get(i);
		}
		
		if(isListOrdered) 
			System.out.println("Items are sorted correctly");
		else
			System.out.println("Items are not sorted correctly");
		
		driver.findElement(By.cssSelector("input[name=fromVal]")).clear();
		driver.findElement(By.cssSelector("input[name=fromVal]")).sendKeys("100");
		driver.findElement(By.cssSelector("input[name=toVal]")).clear();
		driver.findElement(By.cssSelector("input[name=toVal]")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
		
		//To overcome StaleElementReference exception
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//input[@value='Navy']/parent::div/label"))));
		
		driver.findElement(By.xpath("//input[@value='Navy']/parent::div/label")).click();
	
		if(driver.findElement(By.xpath("(//div[text()='Color: ']//a[contains(@data-key,'Color')])[1]")).getText().equals("Navy"))
			System.out.println("Color filter matched");
		else
			System.out.println("Color filter not matched");
		if(driver.findElement(By.xpath("(//div[text()='Price: ']//a[contains(@data-key,'Price')])[1]")).getText().equals("Rs. 100 - Rs. 1200"))
			System.out.println("Price filter matched");
		else
			System.out.println("Price filter not matched");
		
		action.moveToElement(driver.findElement(By.xpath("(//div[contains(@class,'tuple-image')])[1]/a"))).moveToElement(driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"))).click(driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"))).build().perform();
		
		System.out.println("Discounted Price: "+ driver.findElement(By.xpath("//span[contains(@class,'pay')]")).getText());
		System.out.println(driver.findElement(By.xpath("//span[contains(@class,'percent')]")).getText());
		
		//Get all images from the popup window
		List<WebElement> imagesElement = driver.findElements(By.xpath("//div[contains(@id,'image')]/a/img"));
		int i=0;
		for (WebElement webElement : imagesElement) {
			try {
			webElement.click();
			}catch(ElementNotInteractableException e) {//After taking 5th image it has an expand option to view the 6th image
				driver.findElement(By.xpath("//a[contains(@class,'expand')]")).click();
				webElement.click();
			}finally {
			File src = ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			File dest = new File("./img/shoes"+i+".png");
			FileUtils.copyFile(src, dest);
			i++;
			}
			
		}

		driver.findElement(By.xpath("(//div[contains(@class,'close1')])[1]")).click();
		driver.close();
		
		
		
		
	}
	}

