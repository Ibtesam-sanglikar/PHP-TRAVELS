package net.Phptravels.phptravels;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class Flights extends Browser{

	public Flights() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	By flights=By.xpath("//*[@id='body-section']/section/div[2]/div/div/div[2]/ul/li[2]/a");
	By departure=By.xpath("//input[@id='departure']");
	By returnDate=By.xpath("//*[@id='arrival']");
	By roundTrip=By.xpath("//div[@class='col-md-12']//div[2]//div[1]//div[1]//ins[1]");
	By oneWay=By.xpath("");
	Actions action=new Actions(driver);
    
	
	public void selectFromCity()
	{
		driver.findElement(flights).click();
		
		///solution for element not interactable error
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='s2id_origin']//span[@class='select2-chosen'][contains(text(),'Enter Location')]")).click();
		driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(prop.getProperty("fromcity"));
		driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
	}
	
	public void selectToCity()
	{
		driver.findElement(flights).click();
		
		///solution for element not interactable error
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='s2id_destination']/a")).click();
		driver.findElement(By.xpath("//div[@id='select2-drop']//input[@class='select2-input']")).sendKeys(prop.getProperty("tocity"));
		driver.findElement(By.xpath("//*[@id='select2-drop']/ul/li/div")).click();
	}
	
	public void pickDeparture()
	{
		driver.findElement(departure).click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		String current_month=driver.findElement(By.xpath("/html[1]/body[1]/div[16]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
		System.out.println(current_month);
		while(!current_month.equals(prop.getProperty("FcheckInMonth")))
		{
			driver.findElement(By.xpath("/html[1]/body[1]/div[16]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
			current_month=driver.findElement(By.xpath("/html[1]/body[1]/div[16]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
		}
		
		List<WebElement> dates=driver.findElements(By.xpath("/html[1]/body[1]/div[16]/div[1]/table[1]/tbody[1]/tr/td"));
		int count=dates.size();
		System.out.println("count"+count);
		
		for(int i=0;i<count;i++)
		{
			String date=driver.findElements(By.xpath("/html[1]/body[1]/div[16]/div[1]/table[1]/tbody[1]/tr/td")).get(i).getText();
			//String inputdate=prop.getProperty("checkInDate");
			if(date.equals(prop.getProperty("FcheckInDate")))
			{
			driver.findElement(By.xpath("/html[1]/body[1]/div[16]/div[1]/table[1]/tbody[1]/tr/td[contains(text(),"+prop.getProperty("FcheckInDate")+")]")).click();
			}
		}
		
	}
	
	
	public void pickReturnDate()
	{
		driver.findElement(returnDate).click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(returnDate).sendKeys(prop.getProperty("returnDate"));
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
	}
	
	public void selectGuests()
	{
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='col-md-1 form-group go-right col-xs-12']//input[@placeholder='0']")).click();
		
		//select adults
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='madult']")).click();
		WebElement menu=driver.findElement(By.xpath("//select[@id='madult']"));
		action.moveToElement(menu).perform();
		String val="";
		do
		{
			val=driver.findElement(By.xpath("//select[@id='madult']//option")).getText();
			driver.findElement(By.xpath("//*[@id='madult']")).sendKeys(Keys.ARROW_DOWN);	
		}while(val.equals(prop.getProperty("adults")));
		
		driver.findElement(By.xpath("//*[@id='madult']")).sendKeys(Keys.TAB);
		
	
		
		//selectChilds;
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='mchildren']")).click();
		WebElement menu1=driver.findElement(By.xpath("//select[@id='mchildren']"));
		action.moveToElement(menu1).perform();
		String val_children="";
		do
		{
			val_children=driver.findElement(By.xpath("//select[@id='mchildren']//option")).getText();
			driver.findElement(By.xpath("//*[@id='mchildren']")).sendKeys(Keys.ARROW_DOWN);	
		}while(val.equals(prop.getProperty("childs")));
		driver.findElement(By.xpath("//*[@id='mchildren']")).sendKeys(Keys.TAB);
		
		//selectInfants();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='minfant']")).click();
		WebElement menu2=driver.findElement(By.xpath("//select[@id='minfant']"));
		action.moveToElement(menu2).perform();
		String val_infants="";
		do
		{
			val_infants=driver.findElement(By.xpath("//select[@id='minfant']//option")).getText();
			driver.findElement(By.xpath("//*[@id='minfant']")).sendKeys(Keys.ARROW_DOWN);	
		}while(val.equals(prop.getProperty("infants")));
		driver.findElement(By.xpath("//*[@id='minfant']")).sendKeys(Keys.TAB);
		
	  
      driver.findElement(By.xpath("//button[@id='sumManualPassenger']")).click();
	

	}
  
	public void selectRoundTrip()
	{
	driver.findElement(roundTrip).click();
	}
	
	public void selectOneWay()
	{
		driver.findElement(oneWay).click();
	}
	public void clickSearch()
	{
		driver.findElement(By.xpath("//div[@class='col-md-1 form-group go-right col-xs-12']//input[@placeholder='0']")).sendKeys(Keys.ENTER);
		
		
	}
	
}
