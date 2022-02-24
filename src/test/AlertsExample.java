package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//Accept Alert=================
		WebElement alert = driver.findElement(By.xpath("//button[@id='alertButton']"));
		alert.click();
		
		Alert alertPopUp = driver.switchTo().alert();
		System.out.println(alertPopUp.getText());
		alertPopUp.accept();
		
		//Cancel Alert=================
		WebElement cancel = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		cancel.click();
		
		Alert cancelPopUp = driver.switchTo().alert();
		System.out.println(cancelPopUp.getText());
		cancelPopUp.dismiss();
		
		//SendKeys Alert===============
		WebElement sendKey = driver.findElement(By.xpath("//button[@id='promtButton']"));
		sendKey.click();
		
		Alert keyPopUp = driver.switchTo().alert();
		System.out.println(keyPopUp.getText());
		keyPopUp.sendKeys("Cassidy Amason");
		keyPopUp.accept();
		
		
		driver.close();
		
		

	}

}
