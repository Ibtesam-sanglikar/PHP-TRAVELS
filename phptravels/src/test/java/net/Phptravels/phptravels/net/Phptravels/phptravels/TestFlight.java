package net.Phptravels.phptravels.net.Phptravels.phptravels;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.Phptravels.phptravels.Flights;

public class TestFlight {
	  public TestFlight() throws IOException 
	  {}
	  
    Flights f=new Flights();
	Properties prop=new Properties();
	protected static WebDriver driver;
	@BeforeTest
    public void launchbrowser() throws IOException
    { 
    	FileInputStream fis=new FileInputStream("C:\\AG\\phptravels\\src\\main\\java\\net\\Phptravels\\phptravels\\Data.properties");
		prop.load(fis);
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Online Test\\Downloads\\geckodriver-v0.24.0-win32\\geckodriver.exe");
	    driver=new ChromeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
    }
	
	
	@Test
  public void runtest() {
		f.selectFromCity();
	    f.selectToCity();
	    f.pickDeparture();
	    f.selectRoundTrip();
	    f.pickReturnDate();
	    f.selectGuests();
	    f.clickSearch();
  }
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
