package net.Phptravels.phptravels.net.Phptravels.phptravels;
import org.testng.annotations.Test;
import net.Phptravels.phptravels.Browser;
import net.Phptravels.phptravels.Tours;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import org.testng.annotations.AfterTest;

public class TestTour extends Browser {
    public TestTour() throws IOException {
		
		}

	
    Browser b=new Browser();	
	@BeforeTest
	public void initialize() throws IOException 
	{
	  
	  b.launchBrowser();
	  b.Maximize(driver);
	 }
	@Test
	public void runtest() throws InterruptedException, IOException{
		Tours t=new Tours();
		t.tours();
		t.by_city_name();
		t.pick_checkIn();
		t.select_guest();
		t.select_tourtype();
		t.click_search();
		}
	  
	  @AfterTest
	  public void close() {
		  b.Quit(driver);
	  }

	}
