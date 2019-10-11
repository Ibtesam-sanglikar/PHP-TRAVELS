package net.Phptravels.phptravels;

import java.io.IOException;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;

public class HomePage extends Browser{
	public HomePage() throws IOException {
		super();
	
	}
	public void My_account() {
	   By my_acct=By.xpath(prop.getProperty("my_acct"));
	   driver.findElement(my_acct).click();
	}
	
	public void SignUp() {
		   By signup=By.xpath(prop.getProperty("signup"));
		   driver.findElement(signup).click();
	}
		
	public void Login() {
		   By login=By.xpath(prop.getProperty("login"));
		   driver.findElement(login).click();
	}
	
	public void Hotels() {
		   By hotels=By.xpath(prop.getProperty("hotels"));
		   driver.findElement(hotels).click();
	}
	

	public void flights() {
		   By flights=By.xpath(prop.getProperty("flights"));
		   driver.findElement(flights).click();
	}
	
	public void tours() {
		   By tours=By.xpath(prop.getProperty("tours"));
		   driver.findElement(tours).click();
	}
	public void  cars()
	{
		   By cars=By.xpath(prop.getProperty("cars"));
		   driver.findElement(cars).click();
		
	}
	/*public static void main(String[] args) throws IOException {
		HomePage hp=new HomePage();
		hp.launchBrowser(driver);
		hp.My_account();
	    hp.SignUp();
	    //hp.Login();
	    
	}*/
}
