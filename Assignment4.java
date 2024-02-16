package co.edurekatraining;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	
	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {
		//Invoke a web Browser
				
				
				//Open Rediffmail
				driver.get("https://www.rediff.com/");
				driver.manage().window().maximize();
				
				String CurrentUrl=driver.getCurrentUrl();
				System.out.println("CurrentUrl= "+ CurrentUrl );
				
				WebElement signIn = driver.findElement(By.xpath("//a[text()='Sign in']"));
				signIn.click();
				WebElement userNameBox = driver.findElement(By.xpath("//p[contains(text(),'Username')]"));
				Boolean userNameBoxVal=userNameBox.isDisplayed();
				if (userNameBoxVal=true )
				{ 	System.out.println ("Sign In Page is displayed") ;}
				else 
				{	System.out.println ("Sign In Page is not displayed");}
				
				WebElement signInBtn = driver.findElement(By.xpath("//input[@type='submit']"));
				Boolean Val = signInBtn.isDisplayed();
				if (Val=true)
				{signInBtn.click();}
				else
				{	System.out.println ("Sign In button is not Available");}
				
				//Alert Handling
				
				driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
				Thread.sleep(3000);
				
				Alert alert = driver.switchTo().alert();
				String alertMsg= alert.getText();
				System.out.println ("Alert Msg is : " + alertMsg);	
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
				
				alert.accept();
				
				if (Val=true )
				{ 	System.out.println ("Sign In button is Available") ;}
				else 
				{	System.out.println ("Sign In button is not Available");}
				
            	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
				
				Thread.sleep(3000);
				//Window handles
				System.out.println("-----------------------------------------------");
				System.out.println("-----------------------------------------------");
				
				driver.get("https://demoqa.com/browser-windows");
				String parentWindow = driver.getWindowHandle();				
				
				System.out.println ("The Parent Window Handle is " + parentWindow) ;
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
				
				//Child 1 Window (New Tab )
				WebElement child1 = driver.findElement(By.id("tabButton"));
				String childName1=child1.getText();
				System.out.println (childName1+"  button is available ") ;
				child1.click();
				Thread.sleep(3000);
						
				//Child 2 ( New Window )				
				WebElement child2 = driver.findElement(By.id("windowButton"));
				String childName2=child2.getText();
				System.out.println (childName2+" is available ") ;
				//Thread.sleep(3000);
				child2.click();
				Thread.sleep(3000);
			
				
				//Child 3 ( New Window )				
				WebElement child3=driver.findElement(By.id("messageWindowButton"));
				String childName3=child3.getText();
				System.out.println (childName3+" is available ") ;
				//Thread.sleep(3000);
				//child3.click();
				//iframe[starts-with(@id,'google_ads_iframe')]
				Set<String> s =driver.getWindowHandles();
				System.out.println("Window handles is" + s);
				int num =s.size();
				System.out.println("No. of Windows opened are " + num);
				Iterator<String> i1 = s.iterator();

				// Here we will check if child window has other child windows and when child window
			    //is the main window it will come out of loop.
			      while (i1.hasNext()) {
			    	  String ChildWindow = i1.next();
			          if (!parentWindow.equalsIgnoreCase(ChildWindow)) 
			          {   driver.switchTo().window(ChildWindow);
			              System.out.println("parentWindow " + parentWindow +" and Child window handle "+ ChildWindow+" are unique"); }  
			          else if (parentWindow==ChildWindow)
			          {System.out.println("parentWindow is displayed : " + parentWindow); }
			      driver.close();    
				
				
			          	
				
				
	}
	}
}
