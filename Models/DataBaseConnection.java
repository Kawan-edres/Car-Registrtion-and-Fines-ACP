package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection  {
  private static final String URL="jdbc:mysql://localhost:3306/car_registration_and_fines";
  private static final String USERNAME="sqluser";
  private static final String PASSWORD="password";
  public static Connection connection;
  private static DataBaseConnection dataBaseConnection;
  


  public DataBaseConnection() {

    dataBaseConnection();
  }


  public static String getUrl() {
    return URL;
  }

  public static String getUsername() {
    return USERNAME;
  }
  

  public static Connection getConnection() {
    return connection;
  }


  private static void dataBaseConnection(){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
       connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (Exception e) {

System.err.println(e);   

 }
    
  
  }

 
  public static DataBaseConnection getDBConnection()throws ClassNotFoundException,SQLException{
    if(dataBaseConnection==null){
      dataBaseConnection=new DataBaseConnection();
    }
    return dataBaseConnection;
}
}
