package ProjectA.SeleniumA;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kraje\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		String parent= driver.getWindowHandle();
		//System.out.println(driver.findElement(By.xpath("//button[contains(text(),'Open New Window')]")).getText());
		//System.out.println(driver.findElement(By.xpath("//button[contains(text(),'Open New Window')]")).getAttribute("id"));
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[contains(text(),'Open New Window')]")).click();
		driver.findElement(By.id("newWindowBtn")).click();
		Thread.sleep(2000);
		
		Set <String> win= driver.getWindowHandles();
		for(String s: win) {
			System.out.println(s);
			System.out.println(!s.equalsIgnoreCase(parent));
			if(!s.equalsIgnoreCase(parent)) {
				driver.switchTo().window(s);
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
				String msg= driver.findElement(By.id("msg")).getText();
				System.out.println(msg);
				if(msg.equalsIgnoreCase("Registration is Successful")) {
					
					driver.close();
					driver.switchTo().window(parent);
					System.out.println(parent);
					}
			}
			else {
				continue;
			}
		}
		

	}

}
