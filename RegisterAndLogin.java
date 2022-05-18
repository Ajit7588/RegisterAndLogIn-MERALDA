package meradla;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterAndLogin
{
	public WebDriver driver;
	@BeforeTest
	public void set()
	{
		System.setProperty("webdriver.chrome.driver","D:\\MyWork\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://meralda.scalenext.io/");
	    driver.manage().window().maximize();
	}
	
	
  @Test
  public void f() throws InterruptedException
  {
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//a[@class='d-xl-block d-none']//img[@class='icon-nav-hover-effect']")).click();
	  
	  
	  //  Click for Register
	  Thread.sleep(5000);
	  driver.findElement(By.cssSelector(".col-5.col-sm-3.col-md-3.col-lg-2.button-in-form-mob.default-button.black.d-xs-block.d-sm-block.d-lg-block")).click();
	  
	  // Enter the First Name
	  Thread.sleep(5000);
	   driver.findElement(By.name("first_name")).sendKeys("Ajit");
	    
	   // Last name
	    driver.findElement(By.name("last_name")).sendKeys("Tung");
	    
	    // E mail
	    driver.findElement(By.name("email")).sendKeys("ajitkumartung@gmail.com");
	    
	    // Mobile no
	    driver.findElement(By.name("mobile")).sendKeys("8093376354");
	    
	    
	    
	    //  DOB
	    
	    String dob="Apr 1994";
	    String pikdate="5";
	    Thread.sleep(5000);
	   driver.findElement(By.xpath("//div[@class='mx-datepicker']")).click();
	   
	   driver.findElement(By.xpath("//input[@placeholder='DOB']")).click();
	   
	   while(true)
	   {
		  String date= driver.findElement(By.xpath("//span[@class='mx-calendar-header-label']")).getText();
		  System.out.println(date);
		  
		  if(date.equals(dob))
		  break;
		  
		  else
		  {
			  driver.findElement(By.xpath("//i[@class='mx-icon-left']")).click();
		  }
	   }
	   
	   
	  List<WebElement> alldate= driver.findElements(By.xpath("//tbody//td[@class='cell']"));
	  
	  for(WebElement i:alldate)
	  {
		 if(i.getText().contains(pikdate))
		 {
			 i.click();
			 break;
		 }
	  }
	  
	  //  Password
	  driver.findElement(By.name("password")).sendKeys("123456");
	  //  Re Enter Password
	  driver.findElement(By.name("password_confirmation")).sendKeys("123456");
	  
	  Thread.sleep(5000);
	  // Click on Register   
	  driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
	  
	  
	  
	  //  After Register Log-Out
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//a[@id='profileDropdown']//img[@class='icon-nav-hover-effect']")).click();
	    
	  driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item profile-dropdown-menu'][normalize-space()='Logout']")).click();
	  
	  //   LogIn By Valid Credential
	  
	  driver.findElement(By.name("username")).sendKeys("ajitkumartung@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("123456");
	  driver.findElement(By.xpath("//button[text()='Login']")).click();
	  

	  
	  
  }
}
