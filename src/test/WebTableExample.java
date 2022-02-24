package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//WRONG: WebElement tbRows = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr"));
		List<WebElement> tbRows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		List<WebElement> tbColumns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
		List<WebElement> tbData = driver.findElements(By.xpath("//table[@id='customers']//tr[4]//td"));
		List<WebElement> tbColumnData = driver.findElements(By.xpath("//table[@id='customers']//tr//td[1]"));
		
	
		System.out.println("The total number of rows are: " +tbRows.size());
		System.out.println("The total number of columns are: " +tbColumns.size());
		
		//Print the data in the 3rd row:
		for (WebElement data : tbData ) {
			System.out.println("The data in the 3rd row is: " +data.getText());
		}
		
		//Print the data in the 1st column:
		for (WebElement elm : tbColumnData) {
			System.out.println(elm.getText());
		}
		
		
		
		driver.close();

	}

}
