import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DbWithSelenium {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","D:\\ANU\\selenium stuff\\selenium\\chromedriver_79.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		String host="localhost";
		String port="3306";
		Connection com=	DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadbtest?useTimezone=true&serverTimezone=UTC", "root", "anuprita@12345");
	 Statement s=com.createStatement();
	 ResultSet rs=s.executeQuery("select *  from credentials where site='myntra'");
	 WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("anu");
		WebElement pswd=driver.findElement(By.id("password"));
	 while(rs.next())
	 {
		 
			System.out.println("inside while");
			username.sendKeys(rs.getString("username"));
			pswd.sendKeys(rs.getString("password"));
	 }
	}

}
