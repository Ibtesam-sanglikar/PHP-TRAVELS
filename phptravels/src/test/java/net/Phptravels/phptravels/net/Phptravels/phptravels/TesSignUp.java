package net.Phptravels.phptravels.net.Phptravels.phptravels;

import org.testng.annotations.Test;

import net.Phptravels.phptravels.Browser;
import net.Phptravels.phptravels.SignUp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TesSignUp extends Browser{
   
	public TesSignUp() throws IOException {

	}
	
	//object creation
	
	SignUp s=new SignUp();
	@BeforeTest
	public void initialize() throws IOException
	{
		
		s.launchBrowser();
		s.Maximize(driver);
	}
	
	@Test
	public void runtest() throws IOException
	{
		
		s.My_account();
		s.SignUp();
		s.firstname();
		s.lastname();
		s.mobileNumber();
		s.email();
		s.password();
		s.confirmPassword();
		s.gotIt();
		s.submit();
	}
	
	@AfterTest
	public void close() {
		s.Quit(driver);
	}
	
    
}
