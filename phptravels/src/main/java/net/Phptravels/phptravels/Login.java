package net.Phptravels.phptravels;

import java.io.IOException;

import org.openqa.selenium.By;

public class Login extends HomePage{

	
	public Login() throws IOException {
		super();
	}
	
	By login=By.xpath("/html/body/div[6]/div[1]/div[1]/form/button");
	By email=By.xpath("//input[@placeholder='Email']");
    By password=By.xpath("//input[@placeholder='Password']");
    
    
    public void email()
    {
    	driver.findElement(email).sendKeys(prop.getProperty("email"));
    }
    public void password()
    {
    	driver.findElement(password).sendKeys(prop.getProperty("password"));
    }
    public void clickLoginBtn()
    {
    	driver.findElement(login).click();
    }
    
	/*public static void main(String[] args) throws IOException {
		Login log=new Login();
		log.launchBrowser(driver);
		log.Maximize(driver);
		log.My_account();
		log.Login();
		log.email();
		log.password();
		log.clickLoginBtn();
		
	}*/

}
