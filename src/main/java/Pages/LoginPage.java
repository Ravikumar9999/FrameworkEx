package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	
	WebDriver driver;

	//Constructor that will be automatically called as soon as the object of the class is created
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Locator for username field
	By Username = By.name("username");
	
	//Locator for password field
	By Password = By.name("password");
	
	
	//Locator for login button
	By LoginBtn = By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input");
	
	
	
	//Method to enter username
	public void enterUserName(String user) {
		driver.findElement(Username).sendKeys(user);
	}
	
	
	
	//Method to enter password
	public void enterPassword(String pass) {
		driver.findElement(Password).sendKeys(pass);
	}
	
	
	
	//Method to click on LoginButton
	public void clickLogin() {
		driver.findElement(LoginBtn).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
