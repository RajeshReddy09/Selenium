package ProjectA.SeleniumA;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
   
	public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kraje\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.in/ref=nav_logo");
        
        driver.manage().window().maximize();
        List <WebElement> links= driver.findElements(By.xpath("//a"));
        System.out.println(links.size());
        
        /*for(WebElement a: links) {
        	System.out.println(a.getAttribute("href"));
        }*/
        
        
        List <WebElement> links1= driver.findElements(By.xpath("//div[text()='Get to Know Us']/parent::div//a"));
        for(WebElement a: links1) {
        	//a.click();
        	String P= driver.getWindowHandle();
        	String nt = Keys.chord(Keys.CONTROL,"t");
        	a.sendKeys(nt);
        	Thread.sleep(3000);
        	
        	Set<String> wh= driver.getWindowHandles();
        	for(String b: wh) {
        		System.out.println(b);
        		
        	}
        	driver.switchTo().window(P);
        	
        }
        
        
        driver.quit();
    }
}
