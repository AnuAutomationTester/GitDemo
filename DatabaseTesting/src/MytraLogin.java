import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MytraLogin {
public static ResultSet connectDB() throws SQLException
{
	String host="localhost";
	String port="3306";
	Connection com=	DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadbtest?useTimezone=true&serverTimezone=UTC", "root", "anuprita@12345");
 Statement s=com.createStatement();
 ResultSet rs=s.executeQuery("select *  from credentials where site='myntra'");
 while(rs.next())
 {
	 System.out.println(rs.getString("username"));
	 System.out.println(rs.getString("password"));
	 
 }
return rs;
	
}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\ANU\\selenium stuff\\selenium\\chromedriver_79.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		ResultSet rs=connectDB();
		System.out.println(rs);
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("anu");
		WebElement pswd=driver.findElement(By.id("password"));
		while(rs.next())
		{
		System.out.println("inside while");
		username.sendKeys(rs.getString("username"));
		pswd.sendKeys(rs.getString("password"));
		}
		
		/*driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[@class='desktop-userTitle'and text()='Profile']"))).build().perform();
		driver.findElement(By.xpath("//a[text()='login / Signup']")).click();
		driver.findElement(By.xpath("//input[@class='form-control mobileNumberInput']")).sendKeys("7774055747");
		driver.findElement(By.xpath("//*[@class='submitBottomOption']")).click();
		//driver.findElement(By.id("mobileNumberPass")).clear();
		WebElement username=driver.findElement(By.id("mobileNumberPass"));
		WebElement pswd=driver.findElement(By.xpath("//input[@type='password']"));
		ResultSet rs=connectDB();
		while(rs.next())
		{
		username.clear();
		username.sendKeys(rs.getString("username"));
		pswd.sendKeys(rs.getString("password"));
		}
		
		driver.findElement(By.xpath("//button[@class='btn primary  lg block submitButton']")).click();
	}*/
	}
}
