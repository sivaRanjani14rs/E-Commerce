package project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class flipnew2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.findElement(By.className("Pke_EE")).sendKeys("realme",Keys.ENTER);
		List<WebElement> realme=driver.findElements(By.xpath("//*[contains(text(),'realme')]"));
		
		for(WebElement text:realme) {
			System.out.println(text.getText());

		}// realme phones count
		System.out.println("count of Realme Phones "+ realme.size());
		Thread.sleep(1000);
		// mobile clicking
		driver.findElement(By.xpath("//a[@title='Mobiles']")).click();
		Thread.sleep(3000);
		WebElement dropdown=driver.findElement(By.xpath("//select[@class='Gn+jFg']"));
		Select s1=new Select(dropdown);
		s1.selectByValue("10000");
		//*[@id="container"]/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select
		Thread.sleep(3000);
		WebElement dropdown1 =driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select"));
	    Select dp1=new Select(dropdown1);
	    dp1.selectByValue("15000");
		List<WebElement>range=driver.findElements(By.xpath("//*[contains(text(),'realme')]"));
		System.out.println("count of realme phones range betweeen 10k_15k: "+range.size());
		//clicking phone
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='realme 12x 5G (Twilight Purple, 128 GB)'][1]")).click();
		Set<String>Windowhandles=driver.getWindowHandles();
		System.out.println(Windowhandles);
		List<String>windowhandle=new ArrayList<>(Windowhandles);
		driver.switchTo().window(windowhandle.get(1));
		driver.findElement(By.xpath("//span[@class='sBWZ-k']")).click();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File des=new File("./Screenshot/img6.png");
		FileHandler.copy(source, des);

		//closing details
		driver.findElement(By.xpath("//button[@class='QqFHMw gtm1So']")).click();

		//scrolling down
		for(int i=0;i<80;i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		//add to cart
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
		
		//save for later
		for(int i=0;i<70;i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		driver.findElement(By.xpath("//div[text()='Save for later']")).click();
		
		//login
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='QqFHMw aEsfVh _7Pd1Fp']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys("8973162977");
		driver.findElement(By.xpath("//button[text()='Request OTP']")).click();

	}

}
