package busStation;

import java.sql.*;

public class db {

	static Connection con;//Help us get connection to our Database
	static Statement st;//Help us have access to our table inside our Database
	static ResultSet rs;//Help us have access to records inside our Database
	
	public db() {
		
		connect();
		
	}
	public void connect() {
		
		try{
		
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
            Class.forName(driver);
            String db="jdbc:odbc:Database1";
            //Connection con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver(*.accdb)};DBQ=D:\\Andries\\testdatabase.accdb");
            con = DriverManager.getConnection(db);
            //Statement st = con.createStatement();
           // String.format(arg0, arg1)
            st = con.createStatement();
            
            String sql = "select * from Table1";
            rs=st.executeQuery(sql);// rs is holding all the records in Table1
            //String sql = "select Username,Password from Table1 where Username='"+user+"'Password='"+pass+"'";
            
            /*while (rs.next()) {
				String name = rs.getString("Name");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				
				//System.out.println(name+" "+username+" "+password);
				
			}*/
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
		
	}
	
}
