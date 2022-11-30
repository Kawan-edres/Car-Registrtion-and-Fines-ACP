package Controllers;

import Models.DataBaseConnection;
import Models.RenewAnnualModel;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RenewController {

  static Scanner scan = new Scanner(System.in);

  private static Set<RenewAnnualModel> renewAnnual = new HashSet<>();

  public static void addRenewAnnualData(PrintWriter out, BufferedReader in)
      throws IOException, ClassNotFoundException, SQLException {
    out.println("Enter CarPlate Number: ");
    out.println("k");
    int plateNumber = Integer.parseInt(in.readLine());

    out.println("owner Full Name: ");
    out.println("k");
    String owenerFullName = in.readLine();

    out.println("Owener Addrees ");
    out.println("k");
    String owenerAddress = in.readLine();

    out.println("Car Model");
    out.println("k");
    String carModel = in.readLine();

    out.println("Enter Car Type: ");
    out.println("k");
    String vechicleType = in.readLine();

    boolean check = true;
    while (check) {
      if (!(vechicleType.equals("truck") ||
          vechicleType.equals("private") ||
          vechicleType.equals("transport"))) {
        out.println("the type shuld be truck or private or transport");
        out.println("k");
        vechicleType = in.readLine();
      } else {
        check = false;
        break;
      }
    }
    out.println("Enter VIN");
    out.println("k");
    String VIN = in.readLine();

    out.println("Car Color");
    out.println("k");
    String carColor = in.readLine();

    out.println("Annuall start Date ");
    out.println("k");
    String annualStartDate = in.readLine();

    out.println("Annuall End Date ");
    out.println("k");
    String annualEndDate = in.readLine();

    out.println("Vheicle SafetyE ndDate");
    out.println("k");
    String vheicleSafetyEndDate = in.readLine();

    out.println("Environment Fines EndDate");
    out.println("k");
    String environmentFinesEndDate = in.readLine();

    out.println("Chain Number ");
    out.println("k");
    int vheicleChainNumber = Integer.parseInt(in.readLine());

    String SQL = "INSERT INTO renewannual VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

    Connection conn = DataBaseConnection.getDBConnection().getConnection();

    PreparedStatement stm = conn.prepareStatement(SQL);

    stm.setObject(1, plateNumber);
    stm.setObject(2, owenerFullName);
    stm.setObject(3, owenerAddress);
    stm.setObject(4, carModel);
    stm.setObject(5, vechicleType);
    stm.setObject(6, carColor);
    stm.setObject(7, annualStartDate);
    stm.setObject(8, annualEndDate);
    stm.setObject(9, vheicleChainNumber);
    stm.setObject(10, vheicleSafetyEndDate);
    stm.setObject(11, environmentFinesEndDate);
    stm.setObject(12, VIN);

     

     if(stm.executeUpdate()!=0)
     out.println("Renew Annuall added");

    // readRenewAnnualFromFile();

    // renewAnnual.add(
    //     new RenewAnnualModel(
    //         plateNumber,
    //         owenerFullName,
    //         owenerAddress,
    //         carModel,
    //         vechicleType,
    //         carColor,
    //         annualStartDate,
    //         annualEndDate,
    //         vheicleChainNumber,
    //         vheicleSafetyEndDate,
    //         environmentFinesEndDate,
    //         VIN));
    // writeRenewAnnualToFile();
  }

  static void writeRenewAnnualToFile() {
    try {
      ObjectOutputStream outData = new ObjectOutputStream(
          new FileOutputStream("renewAnnual.txt"));
      outData.writeObject(renewAnnual);
      outData.flush();
      outData.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void readRenewAnnualFromFile() {
    try {
      ObjectInputStream in = new ObjectInputStream(
          new FileInputStream("renewAnnual.txt"));
      renewAnnual = (HashSet<RenewAnnualModel>) in.readObject();
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static void print(PrintWriter out) throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM renewannual ";
    Connection conn = DataBaseConnection.getDBConnection().getConnection();
    PreparedStatement stm = conn.prepareStatement(sql);
    
    ResultSet rst=stm.executeQuery();

    while(rst.next()){
      out.println("vehicle Plate Number: "+rst.getInt(1));
      out.println("owner FullName: "+rst.getString(2));
      out.println("owner Address: "+rst.getString(3));
      out.println("car Model: "+rst.getString(4));
      out.println("car Type: "+rst.getString(5));
      out.println("Vin: "+rst.getString(6));
      out.println("car Color: "+rst.getString(7));
      out.println("start Date: "+rst.getString(8));
      out.println("end Date: "+rst.getString(9));
      out.println("vheicle Safety End Date: "+rst.getString(10));
      out.println("enviroment Fines End Date: "+rst.getString(11));
      out.println("vehicle ChainNumber: "+rst.getInt(12));
      
    }

    // readRenewAnnualFromFile();
    // renewAnnual.stream().forEach(p -> out.println(p));
  }


  public static void delete(int plateNumber, String typeTodelete) throws ClassNotFoundException, SQLException {

    String sql = "DELETE FROM renewannual WHERE vehiclePlateNumber ='"+plateNumber+"',carType ='"+typeTodelete+"'";
    Connection conn = DataBaseConnection.getDBConnection().getConnection();
    PreparedStatement stm = conn.prepareStatement(sql);

      stm.executeUpdate();



    // readRenewAnnualFromFile();
    // renewAnnual.removeIf(p -> p.getVehiclePlateNumber() == plateNumber &&
    //     p.getCarType().equals(typeTodelete));
    // writeRenewAnnualToFile();
  }



  public static void search(PrintWriter out, int plateNumber, String type) throws ClassNotFoundException, SQLException {
    String sql = "SELECT * FROM renewannual WHERE vehiclePlateNumber = ? , carType = ? ";
    Connection conn = DataBaseConnection.getDBConnection().getConnection();
    PreparedStatement stm = conn.prepareStatement(sql);
    stm.setObject(1, plateNumber);
    stm.setObject(2, type);

    ResultSet rst=stm.executeQuery();

    while(rst.next()){
      out.println("vehicle Plate Number: "+rst.getInt(1));
      out.println("owner FullName: "+rst.getString(2));
      out.println("owner Address: "+rst.getString(3));
      out.println("car Model: "+rst.getString(4));
      out.println("car Type: "+rst.getString(5));
      out.println("Vin: "+rst.getString(6));
      out.println("car Color: "+rst.getString(7));
      out.println("start Date: "+rst.getString(8));
      out.println("end Date: "+rst.getString(9));
      out.println("vheicle Safety End Date: "+rst.getString(10));
      out.println("enviroment Fines End Date: "+rst.getString(11));
      out.println("vehicle ChainNumber: "+rst.getInt(12));
      
    }



    
    // readRenewAnnualFromFile();
    // renewAnnual
    //     .stream()
    //     .filter(p -> p.getVehiclePlateNumber() == plateNumber && p.getCarType().equals(type)).skip(1)
    //     .forEach(p -> out.println(p));
  }
}
