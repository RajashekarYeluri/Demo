package js.Executor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownClass {
	String driverPath = "C:\\Users\\geckodriver-v0.34.0-win32\\geckodriver.exe";
	public WebDriver driver;

	@Test
	public void AppLaunch() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		WebElement text=driver.findElement(By.id("twotabsearchtextbox"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='Samsung Mobiles';", text);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]")).click();
		Select st=new Select(driver.findElement(By.id("searchDropdownBox")));
		st.selectByVisibleText("Books");
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select selectDropdown = new Select(dropdown);
		selectDropdown.selectByVisibleText("Books");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Prime']"))).perform();

	}

}