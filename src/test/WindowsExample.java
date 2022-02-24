package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String ParentWindow = driver.getWindowHandle();
		System.out.println("Before clicking new button: " +ParentWindow);
		
		//WebElement window = driver.findElement(By.xpath("//button[@id='windowButton']"));
		//window.click();
		WebElement newTab = driver.findElement(By.xpath("//button[@id='tabButton']"));
		newTab.click();
		
		System.out.println("After clicking new button: ");
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		
		while (itr.hasNext()) {
			String current = itr.next();
			System.out.println(current);
			
			if(!current.equals(ParentWindow)) {
				driver.switchTo().window(current);
			}
		}
		
		WebElement heading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(heading.getText());
		
		driver.close();
		
		driver.switchTo().window(ParentWindow);
		driver.close();
		
	

	}

}
