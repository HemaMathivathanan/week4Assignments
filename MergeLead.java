package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {
	
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver ();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	
	driver.findElementById("username").sendKeys("Demosalesmanager");
	driver.findElementById("password").sendKeys("crmsfa");
	driver.findElementByClassName("decorativeSubmit").click();
	driver.findElementByLinkText("CRM/SFA").click();
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	
	WebElement element = driver.findElement(By.xpath("(//img[@alt=\"Lookup\"])[1]"));
	element.click();
	//to handle a window , declare set , convert list to set,go to the window using index
	//to come out of the window , give the index of previous window again.
	Set <String> set = driver.getWindowHandles();
	List<String> list = new ArrayList <String> (set);
	String window1 = list.get(1);
	driver.switchTo().window(window1);
	Thread.sleep(3000);
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
	driver.switchTo().window(list.get(0));
	System.out.println("From contact entered");
	
	//to launch the same window , we should declare it again as session id may vary.
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set <String> set1 = driver.getWindowHandles();
	List<String> list1 = new ArrayList <String> (set1);
	String window2 = list1.get(1);
	driver.switchTo().window(window2);
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()='dp1a1contact1']")).click();
	driver.switchTo().window(list1.get(0));
	System.out.println("To contact entered");
	
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	System.out.println("Both the texts are merged");
	
	
	//To accept the alert 
	Alert alert = driver.switchTo().alert();
	String alerttext = alert.getText();
	System.out.println(alerttext);
	alert.accept();
	System.out.println("Alert is accepted"); 
	Thread.sleep(3000);
	
	String title = driver.getTitle();
	System.out.println(title);
	
	if(title.contains("Merge")) {
		System.out.println("Title is verified");
	}
	else {
		System.out.println("Title is not correct");
	}
	
    System.out.println("Merge lead is success");

	}
}