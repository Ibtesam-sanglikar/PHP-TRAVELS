package net.Phptravels.phptravels.net.Phptravels.phptravels;
import org.testng.annotations.Test;
import net.Phptravels.phptravels.Browser;
import net.Phptravels.phptravels.Hotels;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import org.testng.annotations.AfterTest;

public class TestHotel extends Browser{
  
	
	
	public TestHotel() throws IOException {
		
	}
	Hotels h=new Hotels();


@BeforeTest
public void initialize() {
	  h.launchBrowser();
	  h.Maximize(driver);
}
@Test
public void runtest() throws InterruptedException{
	h.Hotels();
	h.by_city_name();
	h.pick_checkIn();
	h.pick_checkOut();
	h.pick_guests();
	 
}
@AfterTest
public void close() {
	  h.Quit(driver);
}


}
