import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//steps to connect to mysql
		//url to connect will be
		//"jdbc:mysql://"+host+":"+port+"/database";
		//"jdbc:mysql://"+localhost+":"+3306+"/qadbtest";
String host= "localhost";
String port="3306";
	Connection com=	DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadbtest?useTimezone=true&serverTimezone=UTC", "root", "anuprita@12345");

	Statement s=com.createStatement();
	ResultSet rs= s.executeQuery("select * from Employeeinfo where id=2");
	while(rs.next())
	{
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString("location"));
	}
}

}
