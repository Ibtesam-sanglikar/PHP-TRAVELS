package net.Phptravels.phptravels;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser{
	Properties prop=new Properties();
	protected static WebDriver driver;
	
	public Browser() throws IOException{
	
		FileInputStream fis=new FileInputStream("C:\\AG\\phptravels\\src\\main\\java\\net\\Phptravels\\phptravels\\Data.properties");
		prop.load(fis);
		
	    	
	}
	
	
	
	public void launchBrowser()
	{	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Online Test\\Downloads\\geckodriver-v0.24.0-win32\\geckodriver.exe");
	    driver=new FirefoxDriver();
		driver.get(prop.getProperty("URL"));
	}
	public void Maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void Quit(WebDriver driver) {
	    driver.quit();
	}
	/*public static void main(String[] args) throws IOException {
		Browser b=new Browser();
		b.launchBrowser(driver);
		b.Maximize(driver);
		b.Quit(driver);
		
	}*/

}
