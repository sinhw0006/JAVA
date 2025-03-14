package CH19;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C10JsoupMain {
	private static final String WEB_DRIVER_ID="webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH="src/Drivers/chromedriver.exe";
	public static void main(String[] args){
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--no-sandbox");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.naver.com");
		
		WebElement searchEl = driver.findElement(By.id("query"));
		
		searchEl.sendKeys("노트북");
		
		searchEl.sendKeys(Keys.RETURN);
		
		WebElement shoppingBtnEl = driver.findElement(By.cssSelector(".api_pcpg_wrap .tab:nth-child(1)"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].removeAttribute('target')", shoppingBtnEl);
		shoppingBtnEl.click();
	}
}
