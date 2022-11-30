package Controllers;

import Models.DataBaseConnection;
import Models.FinesModel;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FinesController {

  static Scanner scan = new Scanner(System.in);

  private static Set<FinesModel> fines = new HashSet<>();

  public static void addFinesData(PrintWriter out, BufferedReader in)
    throws ParseException, IOException, SQLException, ClassNotFoundException {
    out.println("Enter Car Type: ");
    out.println("k");
    String type = in.readLine();
    boolean check = true;
    while (check) {
      if (
        !(
          type.equals("truck") ||
          type.equals("private") ||
          type.equals("transport")
        )
      ) {
        out.println("the type shuld be truck or private or transport");
        out.println("k");
        type = in.readLine();
      } else {
        check = false;
        break;
      }
    }
    out.println("Enter CarPlate Number: ");
    out.println("k");
    Integer plateNumber = Integer.parseInt(in.readLine());
    out.println("Enter Annual Number :");
    out.println("k");
    String annualNo = in.readLine();
    out.println("Enter typeOf Traffic Violation :");
    out.println("k");
    String typeOfTrafficViolation = in.readLine();
    out.println("Amount of Traffic Violation :");
    out.println("k");
    Double amountOfTrafficViolationMoney = Double.valueOf(in.readLine());
    out.println("total Number of Traffic Violation :");
    out.println("k");
    Integer totalViolation = Integer.parseInt(in.readLine());
    out.println("Total Violation money :");
    out.println("k");
    Double totalMoney = Double.valueOf(in.readLine());

    LocalDate dateObj = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String date = dateObj.format(formatter);
    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);

    String SQL = "INSERT INTO fines VALUES(?,?,?,?,?,?,?,?)";

    Connection conn = DataBaseConnection.getDBConnection().getConnection();

    PreparedStatement stm = conn.prepareStatement(SQL);

    stm.setObject(1, type);
    stm.setObject(2, plateNumber);
    stm.setObject(3, annualNo);
    stm.setObject(4, date1);
    stm.setObject(5, typeOfTrafficViolation);
    stm.setObject(6, amountOfTrafficViolationMoney);
    stm.setObject(7, totalViolation);
    stm.setObject(8, totalMoney);
   

     

     if(stm.executeUpdate()!=0)
     out.println("Fines added");


    // readFinesFromFile();
    // fines.add(
    //   new FinesModel(
    //     type,
    //     plateNumber,
    //     annualNo,
    //     date1,
    //     typeOfTrafficViolation,
    //     amountOfTrafficViolationMoney,
    //     totalViolation,
    //     totalMoney
    //   )
    // );
    // writeFinesToFile();
  }

  static void writeFinesToFile() {
    try {
      ObjectOutputStream outData = new ObjectOutputStream(
        new FileOutputStream("FinesTest.txt")
      );
      outData.writeObject(fines);
      outData.flush();
      outData.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void readFinesFromFile() {
    try {
      ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("FinesTest.txt")
      );
      fines = (HashSet<FinesModel>) in.readObject();
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static void printFines(PrintWriter out) throws ClassNotFoundException, SQLException {
    String sql = "SELECT * FROM fines ";
    Connection conn = DataBaseConnection.getDBConnection().getConnection();
    PreparedStatement stm = conn.prepareStatement(sql);
    
    ResultSet rst=stm.executeQuery();

    while(rst.next()){
      out.println("Car type: "+rst.getString(1));
      out.println("Car plate Number: "+rst.getInt(2));
      out.println("annual Number: "+rst.getString(3));
      out.println("fines History date: "+rst.getString(4));
      out.println(" type of trafic violation: "+rst.getString(5));
      out.println("amount of trafic violation mony : "+rst.getInt(6));
      out.println("total Number of trafic violation: "+rst.getInt(7));
      out.println("all amount of trafic violation mony: "+rst.getString(8));
      
    }
    // readFinesFromFile();
    // fines.stream().forEach(p -> out.println(p));
  }

  public static void deleteFines(int plateNumber, String type) throws ClassNotFoundException, SQLException {

    String sql = "DELETE FROM fines WHERE carPlateNumber ='"+plateNumber+"',carType ='"+type+"'";
    Connection conn = DataBaseConnection.getDBConnection().getConnection();
    PreparedStatement stm = conn.prepareStatement(sql);

      stm.executeUpdate();

    // readFinesFromFile();
    // fines.removeIf(p ->
    //   (p.getCarPlateNumber() == plateNumber && p.getCarType().equals(type))
    // );
    // writeFinesToFile();
  }

  public static void search(PrintWriter out, int plateNumber, String type) throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM fines WHERE carPlateNumber = ? , carType = ? ";
    Connection conn = DataBaseConnection.getDBConnection().getConnection();
    PreparedStatement stm = conn.prepareStatement(sql);
    stm.setObject(1, plateNumber);
    stm.setObject(2, type);

    ResultSet rst=stm.executeQuery();

    while(rst.next()){
      out.println("Car type: "+rst.getString(1));
      out.println("Car plate Number: "+rst.getInt(2));
      out.println("annual Number: "+rst.getString(3));
      out.println("fines History date: "+rst.getString(4));
      out.println(" type of trafic violation: "+rst.getString(5));
      out.println("amount of trafic violation mony : "+rst.getInt(6));
      out.println("total Number of trafic violation: "+rst.getInt(7));
      out.println("all amount of trafic violation mony: "+rst.getString(8));
      
    }




    // readFinesFromFile();
    // fines
    //   .stream()
    //   .filter(p ->
    //     p.getCarPlateNumber() == plateNumber && p.getCarType().equals(type)
    //   ).skip(1)
    //   .forEach(p -> out.println(p));
  }
}
