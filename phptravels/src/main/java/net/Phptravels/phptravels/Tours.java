package net.Phptravels.phptravels;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Tours extends HomePage{

	public Tours() throws IOException {
		super();
	}
	
	
	By location=By.xpath("/html/body/div[6]/section/div[2]/div/div/div[2]/div[1]/div[1]/form/div[1]/div/div/div[2]/a");
	By checkIn=By.xpath("/html/body/div[6]/section/div[2]/div/div/div[2]/div[1]/div[1]/form/div[2]/div/input");
	By checkOut=By.xpath("/html/body/div[6]/section/div[2]/div/div/div[2]/div[1]/div[4]/form/div[3]/div/input");
	By guests=By.xpath("//*[@id='adults']");
	By select_tour=By.xpath("//*[@id='tourtype']");
	By search=By.xpath("/html/body/div[6]/section/div[2]/div/div/div[2]/div[1]/div[1]/form/div[5]/button");
	Actions action=new Actions(driver);
    
	
	
    public void gotIt()
	{
	    By got=By.xpath("//*[@id='cookyGotItBtn']");
		driver.findElement(got).click();
	
	}
	
	public void by_city_name() throws InterruptedException
	{
		driver.findElement(location).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[6]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).sendKeys(prop.getProperty("tour_destination"));
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div[contains(text(),'Sheraton Trip')]")).click();
				
	}
	
	
	public void pick_checkIn()
	{
		driver.findElement(checkIn).click();
		String current_month=driver.findElement(By.xpath("/html/body/div[11]/div[1]/table/thead/tr[1]/th[2]")).getText();
		System.out.println(current_month);
		while(!current_month.equals(prop.getProperty("checkInM")))
		{
			driver.findElement(By.xpath("/html/body/div[11]/div[1]/table/thead/tr[1]/th[3]")).click();
			current_month=driver.findElement(By.xpath("/html/body/div[11]/div[1]/table/thead/tr[1]/th[2]")).getText();
		}
		
		List<WebElement> dates=driver.findElements(By.xpath("/html/body/div[11]/div[1]/table/tbody/tr/td"));
		int count=dates.size();
		System.out.println("count"+count);
		
		for(int i=0;i<count;i++)
		{
			String date=driver.findElements(By.xpath("/html/body/div[11]/div[1]/table/tbody/tr/td")).get(i).getText();
			//String inputdate=prop.getProperty("checkInDate");
			if(date.equals(prop.getProperty("checkInD")))
			{
				driver.findElement(By.xpath("/html/body/div[11]/div[1]/table/tbody/tr/td[contains(text(),"+prop.getProperty("checkInD")+")]")).click();
			}
		}
		
	    	
	}
	public void select_guest()
	{
		driver.findElement(guests).click();
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='adults']")).click();
		WebElement menu=driver.findElement(By.xpath("//*[@id='adults']"));
		action.moveToElement(menu).perform();
		String val="";
		do
		{
			val=driver.findElement(By.xpath("//*[@id='adults']//option")).getText();
			driver.findElement(By.xpath("//*[@id='adults']")).sendKeys(Keys.ARROW_DOWN);	
		}while(val.equals(prop.getProperty("guests")));
		
	}
   public void select_tourtype()
   {
	  driver.findElement(select_tour).click();
	  driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//select[@id='tourtype']")).click();
	  WebElement menu=driver.findElement(By.xpath("//select[@id='tourtype']"));
	  action.moveToElement(menu).perform();
	  String val="";
	  do
	  {
		val=driver.findElement(By.xpath("//select[@id='tourtype']//option")).getText();
		driver.findElement(By.xpath("//select[@id='tourtype']")).sendKeys(Keys.ARROW_DOWN);	
      }while(val.equals(prop.getProperty("tour_type")));
	  
	  
   }
   public void click_search()
   {
	   driver.findElement(search).click();
		  
   }
	/*public static void main(String[] args) throws IOException, InterruptedException {
		Tours t=new Tours();
		t.launchBrowser(driver);
		t.Maximize(driver);
		t.tours();
		t.by_city_name();
		t.pick_checkIn();
		t.select_guest();
		t.select_tourtype();
		t.click_search();
		*/

}
