package net.Phptravels.phptravels;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Hotels extends HomePage {

	public Hotels() throws IOException {
		super();
		
	}

	By location=By.xpath("/html/body/div[6]/section/div[2]/div/div/div[2]/div[1]/div[4]/form/div[1]/div/div[2]/a");
	By checkIn=By.xpath("/html/body/div[6]/section/div[2]/div/div/div[2]/div[1]/div[4]/form/div[2]/div/input[1]");
	By checkOut=By.xpath("/html/body/div[6]/section/div[2]/div/div/div[2]/div[1]/div[4]/form/div[3]/div/input");
	By guests=By.xpath("//*[@id='htravellersInput']");
	By search=By.xpath("/html/body/div[6]/section/div[2]/div/div/div[2]/div[1]/div[4]/form/div[5]/button");
	
	
    public void gotIt()
	{
	    By got=By.xpath("//*[@id='cookyGotItBtn']");
		driver.findElement(got).click();
	
	}
	
	public void by_city_name() throws InterruptedException
	{
		gotIt();
		driver.findElement(location).click();
		driver.findElement(By.xpath("/html/body/div[20]/div/input")).sendKeys(prop.getProperty("city_name"));
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//span[contains(@class,'select2-match')]")).click();
				
	}
	
	
	public void pick_checkIn()
	{
		driver.findElement(checkIn).click();
		String current_month=driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
		System.out.println(current_month);
		while(!current_month.equals(prop.getProperty("checkInMonth")))
		{
			driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
			current_month=driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
		}
		
		List<WebElement> dates=driver.findElements(By.xpath("/html/body/div[14]/div[1]/table/tbody/tr/td"));
		int count=driver.findElements(By.xpath("/html/body/div[14]/div[1]/table/tbody/tr/td")).size();
		System.out.println("count"+count);
		
		for(int i=0;i<count;i++)
		{
			String date=driver.findElements(By.xpath("/html/body/div[14]/div[1]/table/tbody/tr/td")).get(i).getText();
			//String inputdate=prop.getProperty("checkInDate");
			if(date.equals(prop.getProperty("checkInDate")))
			{
				driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/tbody/tr/td[contains(text(),"+prop.getProperty("checkInDate")+")]")).click();
			}
		}
		
	    	
	}
	
	
    public void pick_checkOut()
    {
    	driver.findElement(By.xpath("//*[@id='htravellersInput']")).click();
    }
    
    
    public void pick_guests()
    {
    	driver.findElement(guests).click();
    	//adults
    	driver.findElement(By.xpath("//*[@id='hadultInput']")).clear();
    	driver.findElement(By.xpath("//*[@id='hadultInput']")).sendKeys(prop.getProperty("adults"));
    	
    	//child
    	driver.findElement(By.xpath("//*[@id='hchildInput']")).clear();
    	driver.findElement(By.xpath("//*[@id='hchildInput']")).sendKeys(prop.getProperty("childs"));
    	driver.findElement(search).click();
    	
    }
    	
    
    	
	
	

	                                     
	/*public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Hotels h=new Hotels();
		h.launchBrowser(driver);
		h.Maximize(driver);
		//h.gotIt();
		
	}*/

}
