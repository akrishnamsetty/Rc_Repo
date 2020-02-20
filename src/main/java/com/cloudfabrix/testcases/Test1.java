package com.cloudfabrix.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	
	//int a=0;  //global variable or instance variable
	 //String b="kumar"; //global variable or instance variable
	 WebDriver driver;
	 WebDriverWait wit;
	@BeforeTest
	// @BeforeClass
	public void methodbefore()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayodh\\OneDrive\\Documents\\SeleniumSoftwares\\chromedriver.exe");
		 driver=new ChromeDriver();
		  wit=new WebDriverWait(driver, 5);

		driver.manage().window().maximize();
		driver.get("https://www.pizzahut.co.in/customer-feedback.php");
	}
	
	@Test(priority = 1)
	public void method1() throws InterruptedException{
		
		String title=driver.getTitle();
		if(title.equals("Feedback | What can we do to improve your Pizza Hut experience? | Pizza Hut India")){
			System.out.println("successfully launched the app");
		}else{
			System.out.println("successfully not launched the app");
		}
		
	//Threaep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//implicitwait
		
      wit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[2]/button/span/div")));
	//	wit.until(ExpectedConditions.elementToBeClickable(ele));
		//implicit wait 
		//explicit wait
		
	}
@Test(priority = 0)
public void method2() throws InterruptedException{
	
/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayodh\\OneDrive\\Documents\\SeleniumSoftwares\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.pizzahut.co.in/customer-feedback.php");*/
driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[2]/button/span/div")).click();
Thread.sleep(1000);
WebElement experiencetype = driver.findElement(By.xpath("//*[@id='frmprocess']/table/tbody/tr[5]/td/table/tbody/tr[2]/td[1]/div/input"));
experiencetype.click();
WebElement expereincetext = driver.findElement(By.xpath("//*[@id='frmprocess']/table/tbody/tr[5]/td/table/tbody/tr[3]/td[1]/div"));
System.out.println("---"+expereincetext.getText());
wit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='frmprocess']/table/tbody/tr[5]/td/table/tbody/tr[3]/td[1]/div/input")));
WebElement expereincetype1 = driver.findElement(By.xpath("//*[@id='frmprocess']/table/tbody/tr[5]/td/table/tbody/tr[3]/td[1]/div/input"));
//expereincetype1.click();
System.out.println("---"+expereincetype1.getText());
//expereincetype1.getText()
Thread.sleep(500);
WebElement citytext = driver.findElement(By.xpath("//*[@id='frmprocess']/table/tbody/tr[5]/td/table/tbody/tr[5]/td/div/strong"));

System.out.println("---"+citytext.getText());
//WebElement city_id = driver.findElement(By.id("city_id"));
//WebElement cityvalues = driver.findElement(By.xpath("//*[@id='city_id']"));
//List<WebElement> list = cityvalues.findElements(By.tagName("option"));
//for (WebElement listvalues: list){
	//System.out.println(listvalues.getText());
//}

WebElement city_id = driver.findElement(By.id("city_id"));
Select list1 = new Select(city_id);
  List<WebElement> listvalues = list1.getOptions();
System.out.println(listvalues.get(3).getText());
for(WebElement printvalues :listvalues) {
	System.out.println(printvalues.getText());
	
}

}
@AfterTest
public void classafter()
{
	driver.close();
	driver.quit();
}
}
