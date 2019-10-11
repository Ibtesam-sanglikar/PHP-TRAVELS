package net.Phptravels.phptravels;

import java.io.IOException;

import org.openqa.selenium.By;

public class SignUp extends Browser{
	
	
	public SignUp() throws IOException {
		super();
	}

	By submit=By.xpath("/html/body/div[6]/section/div/div/div/div/div[3]/div/form/div[9]/button");
	By fname=By.xpath("//input[@placeholder='First Name']");
	By lname=By.xpath("//input[@placeholder='Last Name']");
	By mobile_number=By.xpath("//input[@placeholder='Mobile Number']");
	By email=By.xpath("//input[@placeholder='Email']");
	By password=By.xpath("//input[@placeholder='Password']");
	By confirm_pwd=By.xpath("//input[@placeholder='Confirm Password']");
	
	
	public void firstname() {
		driver.findElement(fname).sendKeys(prop.getProperty("fname"));
		
	}
	public void lastname() {
		driver.findElement(lname).sendKeys(prop.getProperty("lname"));
		
	}
	public void mobileNumber() {
		driver.findElement(mobile_number).sendKeys(prop.getProperty("mobile_number"));
		
	}
	public void email() {
		driver.findElement(email).sendKeys(prop.getProperty("email"));
		
	}
	public void password() {
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		
	}
	public void confirmPassword() {
		driver.findElement(confirm_pwd).sendKeys(prop.getProperty("confirm_password"));
		
	}
	public void submit()
	{
		driver.findElement(submit).click();
	}
	public void gotIt() {

		By gotIt=By.xpath("//*[@id=\"cookyGotItBtn\"]");
		driver.findElement(gotIt).click();
	}
	
	public void My_account() {
		   By my_acct=By.xpath(prop.getProperty("my_acct"));
		   driver.findElement(my_acct).click();
		}
		
		public void SignUp() {
			   By signup=By.xpath(prop.getProperty("signup"));
			   driver.findElement(signup).click();
		}
			
	/*public static void main(String[] args) throws IOException {
	SignUp signup=new SignUp();
	signup.launchBrowser(driver);
	signup.My_account();
	signup.SignUp();
	signup.firstname();
	signup.lastname();
	signup.mobileNumber();
	signup.email();
	signup.password();
	signup.confirmPassword();
	signup.gotIt();
	signup.submit();
	}*/
}
