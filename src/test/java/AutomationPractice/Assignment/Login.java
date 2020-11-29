package AutomationPractice.Assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	@Test
	public void stratExec() throws InterruptedException, IOException{
		
		WebDriverManager.chromedriver().setup(); 
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("rajan.dubey@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("rajan@123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.findElement(By.xpath("//span[text()='My addresses']")).click();
		driver.findElement(By.xpath("//span[text()='Add a new address']")).click();
		driver.findElement(By.id("address1")).sendKeys("aa");
		driver.findElement(By.id("address2")).sendKeys("aa");
		driver.findElement(By.id("city")).sendKeys("aa");
		Select s = new Select(driver.findElement(By.id("id_state")));
		s.selectByVisibleText("Arizona");
		driver.findElement(By.id("postcode")).sendKeys("00000");
		driver.findElement(By.id("phone")).sendKeys("8888888888");
		driver.findElement(By.id("phone_mobile")).sendKeys("8888888888");
		driver.findElement(By.id("other")).sendKeys("jbdff");
		Random rand = new Random(); 
        int rand1 = rand.nextInt(1000);
		driver.findElement(By.id("alias")).sendKeys("newadd"+rand1);
		driver.findElement(By.id("submitAddress")).click();
		
		Thread.sleep(3000);
		
		Actions a = new Actions(driver);
		
		WebElement women = driver.findElement(By.xpath("//a[text()='Women']"));
		a.moveToElement(women).build().perform();
		WebElement summerDresses = driver.findElement(By.xpath("//a[text()='Summer Dresses']"));
		summerDresses.click();
		
		driver.findElement(By.xpath("//li[@id='list']")).click();
		
		List<WebElement> li = driver.findElements(By.xpath("//*[@itemprop='name']"));
		System.out.println("size : "+li.size());
		for(int i=0;i<li.size();i++) {
		//driver.findElement(By.xpath("(//*[@itemprop='name'])[1]")).click();
		List<WebElement> l = driver.findElements(By.xpath("//*[@itemprop='name']"));
		l.get(i).click();
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("5");
		Select s1 = new Select(driver.findElement(By.id("group_1")));
		s1.selectByVisibleText("L");
		driver.findElement(By.name("Yellow")).click();
		
		driver.findElement(By.xpath("//p[@id='add_to_cart']/button")).click();
		Thread.sleep(3000);
		if(i==l.size()-1) {
			driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
			break;
		}else {
			driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
			Thread.sleep(5000);
			
		}
		driver.findElement(By.xpath("//div[@class='breadcrumb clearfix']/a[4]")).click();
		Thread.sleep(5000);
		
		}
	driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
	driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	driver.findElement(By.xpath("//*[@class='cart_navigation clearfix']/button")).click();
	driver.findElement(By.xpath("//a[@class='bankwire']")).click();
	driver.findElement(By.xpath("//button[@type='submit']/span[text()='I confirm my order']")).click();
	driver.findElement(By.xpath("//a[@class='account']")).click();
	driver.findElement(By.xpath("//span[text()='Order history and details']")).click();
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);  
	File dest = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Screenshot\\sc"+rand1+".png");
	FileUtils.copyFile(src, dest);
	
	driver.close();
	}
}
