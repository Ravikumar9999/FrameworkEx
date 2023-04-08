package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.ContactsPage;
//import Pages.Dashboard;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginTestCase {

	public static void main(String[] args) throws InterruptedException {


		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAVI KUMAR\\eclipse-workspace\\FrameworkEx\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://classic.freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		
		//Creating object of Home Page
		HomePage home = new HomePage(driver);
		
		
		//Creating object of Login Page
		LoginPage login = new LoginPage(driver);
		
		
		//Creating object of Contacts Page
		ContactsPage contacts = new ContactsPage(driver);
		
		
		//Click on login button
		//home.clickLogin();
		
		
		//Enter username & password
		login.enterUserName("Ravikumar@9999");
		login.enterPassword("test@9999");
		
		//Click on login button
		login.clickLogin();
		Thread.sleep(2000);
		
		driver.switchTo().frame("mainpanel");
		
		//Click on Login button
		home.ConClick();
		
		
		//Capture the contacts page title and print on console
//		String contitle = driver.getTitle();
//		
//		if(contitle.contains(contitle)) {
//			System.out.println("Correct Title");
//		}
//		else {
//			System.out.println("In-Correct Title");
//		}
		
		
        String contitle= driver.getTitle();
        
        if(contitle.contains(contitle)) {
        	System.out.println(contitle);
        }
        
        
        String url= driver.getCurrentUrl();
        
        if(url.contains(url)) {
        	System.out.println(url);
        }
		
		
	
		

	}	

}
