package week4.day2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ZoomCar {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver ();
		driver.get("https://www.zoomcar.com/chennai");	
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class=\"search\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='items'])[3]")).click();
		
		WebElement target = driver.findElement(By.xpath("//button[text()='Next']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(target).click().perform();
		
		System.out.println("clicked on Next successfully");
		
		Date date = new Date (); // to get the current date
		System.out.println("Today's date is :" + date);
		DateFormat df = new SimpleDateFormat("dd");
		String today =df.format(date);
		int  Tommorow = Integer.parseInt(today)+1 ;
		System.out.println("Tomorrow's date is " +Tommorow);
		
		driver.findElementByXPath("//div[contains(text(),'"+Tommorow+"')]").click();		
	 	//driver.findElement(By.xpath("//div[text()='Fri']")).click();
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		driver.findElement(By.xpath("//div[text()='Sat']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		Thread.sleep(3000);
		
		
    	List<WebElement> count = driver.findElements(By.tagName("h3"));
		int size = count.size();
		System.out.println("yes");
		System.out.println("size is " + size);
		
		
    	Map <String , String > map = new LinkedHashMap  < String , String>();
		List<WebElement> carnames = driver.findElements(By.xpath("//div[@class=\"details\"]/h3"));
		List<WebElement> carPrice = driver.findElementsByXPath("//div[@class='price']");
		
        for (int i = 0; i < carnames.size(); i++) {
    	String carlist = carnames.get(i).getText();
   		System.out.println(carlist);
   		
   		String pricelist = carPrice.get(i).getText().replaceAll("[^0-9]", "");
   		System.out.println(pricelist);
      
   		map.put(carlist,pricelist);
   		
        }
        System.out.println("ok");
      
        String maxvalue = Collections.max(map.values());
        System.out.println("Maximum value is "  +maxvalue);
 
	}
}
      
   
		
    
	
 