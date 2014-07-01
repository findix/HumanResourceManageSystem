package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JbdcUtils_C3P0 {
	private static String dbDrive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=HumanResource";
	private static String userName = "admin";
	private static String password = "admin";
	private static Connection con = null;
    
	static{
 
        try{
            //这个是加载配置文件
        	Class.forName(dbDrive);
           
            //这个手动设置，不加载配置文件
 
            /*ds.setDriverClass("com.mysql.jdbc.Driver");
 
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/day16");
 
            ds.setUser("root");
 
            ds.setPassword("root");
 
            ds.setInitialPoolSize(20);*/
 
        }catch (Exception e) {
 
            throw new ExceptionInInitializerError(e);
 
        }
 
    }
 
     
 
    public static Connection getConnection() throws SQLException{
        return con = DriverManager.getConnection(url, userName, password);
 
    }
 
     
 
}