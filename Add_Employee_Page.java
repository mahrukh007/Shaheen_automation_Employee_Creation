
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.interactions.Action;

public class Add_Employee_Page {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("http://shn-qa/PRODH/HomePage.aspx?menuitemid=211");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Variables_Class ec = new Variables_Class();
		//Login Credentials
		driver.findElement(By.id(ec.LoginID)).sendKeys("waqas");
		driver.findElement(By.id(ec.Password)).sendKeys("abcd@1234");
		driver.findElement(By.id(ec.SubmitBtn)).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Navigation
		WebElement link_Home = driver.findElement(By.linkText("HRM"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		// Actions builder = new Actions(driver);
		org.openqa.selenium.interactions.Action mouseOverHome = builder
				.moveToElement(link_Home)
				.moveToElement(driver.findElement(By.xpath(ec.EmpInfo)))
                .pause(500)
                .click()
                .build();
		
		mouseOverHome.perform();
		
		driver.findElement(By.id(ec.EmpAdd)).click();
		
		//select 'new' 
		Select new_rejoin = new Select(driver.findElement(By.id(ec.joinStat)));
		new_rejoin.selectByIndex(0);
		
		//enter first name
		driver.findElement(By.xpath(ec.firstName)).clear();
		driver.findElement(By.xpath(ec.firstName)).sendKeys("ABCD");
		
		//Enter Calendar date as 'DOB'
		driver.findElement(By.xpath(ec.dob)).sendKeys("01/10/2018");
		
		//select gender as 'male' 
		Select gender = new Select(driver.findElement(By.xpath(ec.gender)));
		gender.selectByIndex(1);
		
		//Enter CNIC 
		driver.findElement(By.xpath(ec.cnic)).clear();
		driver.findElement(By.xpath(ec.cnic)).sendKeys("1236467890123");
		
		//Enter calendar date as cnic_Expiry
		driver.findElement(By.xpath(ec.exNic)).sendKeys("01/10/2022");
		
		//Select role type 
		Select Role_Type = new Select
		(driver.findElement(By.id(ec.roleType)));
		Role_Type.selectByIndex(2);
				
		//Enter login ID 
		driver.findElement(By.xpath(ec.logDir)).clear();
		driver.findElement(By.xpath(ec.logDir)).sendKeys("abcd.efgh2");
		
		//click 'save' button 
		driver.findElement(By.xpath(ec.save)).click();
		
		String empCode = driver.findElement(By.xpath(ec.EmpCode)).getText();
		System.out.println(empCode);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

}
