package study.jdbc_dec_23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;	//--for statement use this
import java.util.Scanner;




public class ClientExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1=add connector to build path=.jar files
		
		//2=load the driver class so that its static block gets executed
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//3=create jdbc url
		String jdbc_url = "jdbc:mysql://localhost:3306/dbjava";
		String uname="root";
		String pass= "root";
		
		//4=get the connection
		Connection con = DriverManager.getConnection(jdbc_url, uname, pass);
		System.out.println("Connection to db is successful :: "+con);
		
		//till here run & check for connections with db
		
		//5=create statements
		Statement stmt = con.createStatement();
		/*mysql> desc mybooklist;-----made new table
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| bookID   | int         | NO   | PRI | NULL    |       |
| bookName | varchar(45) | YES  |     | NULL    |       |
| Type     | varchar(45) | YES  |     | NULL    |       |
| Cost     | int         | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+*/
		//String sql = "insert into mybooklist values(1001,\"ABC1\",\"alphabet1\",3001)";
		
		//user input
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter book_id,bookname,type,cost separated by comma ");
		String input = sc.nextLine();
		String[] values = input.split(",");
		//String sql = "insert into book values("+Integer.parseInt(values[0])+","+Integer.parseInt(values[1])+",'"+values[2]+"')";
		String sql = "insert into mybooklist values("+values[0]+",'"+values[1]+"','"+values[2]+"',"+values[3]+")";
		
		//6=fire query
		stmt.executeUpdate(sql);	//firring the query to driver, driver will send to mysql , mysql will execute this query finally on cmd
		
		
		/*String sql2 = "insert into student values(12,'prachi','2012-1-29')";
		stmt.executeUpdate(sql2);*/
		sc.close();
	}

}
