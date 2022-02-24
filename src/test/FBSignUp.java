package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement SignUp = driver.findElement(By.cssSelector("a[data-testid*='registration']"));
		SignUp.click();
		
		WebElement FirstName = driver.findElement(By.cssSelector("input[placeholder='First name']"));
		WebElement LastName = driver.findElement(By.cssSelector("input[name='lastname']")); 
		WebElement Phone = driver.findElement(By.cssSelector("input[aria-label^='Mobile number']"));
		WebElement Password = driver.findElement(By.cssSelector("input[id^='password_']"));
		
		/*dynamic Xpath, apparently does not always work
		String Month = "Sep";
		String Day = "31";
		String Year = "1995";
		
		String monthXpath = "//select[@name='birthday_month']/option[text()='"+ Month +"']";
		String dayXpath = "//select[@name='birthday_day']/option["+ Day +"]";
		String yearXpath = "//select[@name='birthday_year']/option[text()='"+ Year +"']";
		WebElement findMonth = driver.findElement(By.xpath(monthXpath));
		WebElement findDay = driver.findElement(By.xpath(dayXpath));
		WebElement findYear = driver.findElement(By.xpath(yearXpath));
		*/
		
		List<WebElement> Months = driver.findElements(By.xpath("//select[@title='Month']/option"));
		
		for (WebElement elm : Months) {
			System.out.println(elm.getText());
		}
		
		WebElement currMonth = driver.findElement(By.xpath("//select[@id='month']"));
		WebElement birthDay = driver.findElement(By.xpath("//select[@id='day']"));
		WebElement birthYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select ddcurrMonth = new Select(currMonth);
		Select ddbirthDay = new Select(birthDay);
		Select ddbirthYear = new Select(birthYear);
		
		
		//dynamic Xpath:
		String strGen = "Female"; //Options: Male or Custom or Female
		String genXpath = "//label[text()='"+ strGen +"']/following-sibling::input";
		WebElement Gender = driver.findElement(By.xpath(genXpath));
		
		FirstName.sendKeys("Cassidy");
		LastName.sendKeys("Amason");
		Phone.sendKeys("770-354-1734");
		Password.sendKeys("Wfif#1232!");
		//findMonth.click();
		//findDay.click();
		//findYear.click();
		
		ddcurrMonth.selectByVisibleText("Sep");
		ddbirthDay.selectByVisibleText("14");
		ddbirthYear.selectByVisibleText("1995");
		Gender.click();
		
		
		
		
		

	}

}
