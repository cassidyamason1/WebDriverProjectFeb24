package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,30); //explicit wait
		//WebElement LoginLink = driver.findElement(By.className("login"));
		WebElement LoginLink = driver.findElement(By.linkText("Log in")); //info between opening and closing anchor tags: <a> linkText </a>                   
		
		wait.until(ExpectedConditions.elementToBeClickable(LoginLink));
		LoginLink.click();
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.name("user_pwd"));
		//WebElement Password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.name("btn_login"));
		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		
		
		UserName.sendKeys("xyz@gmail.com");
		Password.sendKeys("Abc@1234!");
		RememberMe.click();
		loginButton.click();
		
		WebElement ErrorMessage = driver.findElement(By.id("msg_box"));
		String ActualMessage = ErrorMessage.getText();
		String ExpectedMessage = "The email or password you have entered is invalid.";
		
		if (ActualMessage.equals(ExpectedMessage)) {
			System.out.println("Test case passed!");
		}
		else {
			System.out.println("Test case failed.");
		}
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are: " +links.size());
		
		for(WebElement elm : links) {
			System.out.println(elm.getAttribute("href"));
		}
		
		driver.close();

	}

}
