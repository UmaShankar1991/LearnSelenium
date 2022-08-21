package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//WebDriverManager.firefoxdriver().setup();
	//FirefoxDriver driver = new FirefoxDriver();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		WebElement stationFrom = driver.findElement(By.id("txtStationFrom"));
		stationFrom.clear();
		stationFrom.sendKeys("MS", Keys.TAB, Keys.TAB, "PDY", Keys.TAB);
		driver.findElement(By.xpath("//td[@id='tdDateOnly']/input")).click();
		
		List<WebElement> tableRows = driver.findElements(By.xpath("//div[@id='divMainWrapper']//table[contains(@class,'TrainList')]/tbody/tr"));
		
		//List<WebElement> tableColumns = driver.findElements(By.xpath("//div[@id='divMainWrapper']//table[contains(@class,'TrainList')]/tbody/tr[1]/td"));
		
		System.out.println(tableRows.size());
		//System.out.println(tableColumns.size());
		
		for(int i = 1; i<=tableRows.size(); i++) {
			for(int j=1; j<=9; j++) {
				String values = driver.findElement(By.xpath("//div[@id='divMainWrapper']//table[contains(@class,'TrainList')]/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(values);
			}
		
	}

}
}
