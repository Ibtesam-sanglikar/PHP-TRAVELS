package net.Phptravels.phptravels.net.Phptravels.phptravels;
import org.testng.annotations.Test;
import net.Phptravels.phptravels.Browser;
import net.Phptravels.phptravels.Login;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import org.testng.annotations.AfterTest;

public class TestLogin extends Browser {
  
	
	Login l=new Login();
	  
  public TestLogin() throws IOException 
  {
	
	}
  
  
  
  @BeforeTest
  public void initialize() {
	  l.launchBrowser();
	  l.Maximize(driver);
  }
  @Test
  public void runtest(){
	
	  l.My_account();
	  l.Login();
	  l.email();
	  l.password();
	  l.clickLoginBtn();
  }
  @AfterTest
  public void close() {
	  l.Quit(driver);
  }

}
