package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Acme {
public static void main(String[] args) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver ();
	driver.get("https://acme-test.uipath.com/account/login");	
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
	driver.findElement(By.xpath("//button[@id='buttonLogin']")).click();
	
	Thread.sleep(3000);
	
	Actions builder = new Actions (driver);
	WebElement target = driver.findElement(By.xpath("(//button[@type=\"button\"])[6]"));
	builder.moveToElement(target).perform();
	System.out.println("mouse over to Vendor is done successfully ");
	
	driver.findElement(By.xpath("//a[text()='Search for Vendor']")).click();
	
	driver.findElement(By.xpath("//input[@id='vendorName']")).sendKeys("Blue Lagoon");
	driver.findElement(By.xpath("//button[@id='buttonSearch']")).click();
	System.out.println("Vendor name is entered ");
	
	WebElement eletable = driver.findElement(By.xpath("//table[@class='table']"));
	List<WebElement> allrows = eletable.findElements(By.tagName("tr"));
	System.out.println("The header is : " + allrows.get(0).getText());
	System.out.println("First Row in the table is :" + allrows.get(1).getText());
	
	List<WebElement> allcolumns = eletable.findElements(By.tagName("td"));
	System.out.println("The country is : " + allcolumns.get(4).getText());

	WebElement target1 = driver.findElement(By.xpath("//a[text()='Log Out']"));
	builder.moveToElement(target1).click().perform();
	System.out.println("Logged Out");
	
	driver.close();
	System.out.println("ACME program is success");
//	driver.close();
	
	
	
	
	
	
	
	
	
	
	
	
}
}
