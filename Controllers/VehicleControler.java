package Controllers;

import Models.DataBaseConnection;
import Models.Truck;
import Models.VehicleModule;
import Views.VehicleView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class VehicleControler implements Serializable {

  VehicleModule module;
  VehicleView view;

  public VehicleControler(VehicleModule module, VehicleView view) {
    this.module = module;
    this.view = view;
  }

  public void addVhicle(PrintWriter out, BufferedReader in) throws IOException, ClassNotFoundException, SQLException {
   
   if( (this.module.addVhicle(this.view.addVhicle(out, in))!=0) )
   out.println("Data added");
  }

  public void displayVehicle(String Type, PrintWriter out) throws SQLException, ClassNotFoundException {
    String sql = "SELECT * FROM vehicle WHERE vehicleType = ? ";
        Connection conn = DataBaseConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, Type);
        ResultSet rst=stm.executeQuery();

        while(rst.next()){
          out.println("VehicleID: "+rst.getInt(1));
          out.println("Vehicle MOdel Name: "+rst.getString(2));
          out.println("Vehicle Model Year: "+rst.getInt(3));
          out.println("Vehicle annual Number: "+rst.getString(4));
          out.println("Vehicle Vehicle Color: "+rst.getString(5));
          out.println("Vehicle Owner Name: "+rst.getString(6));
          out.println("Vehicle Plate Number: "+rst.getInt(7));
          out.println("Vehicle Vehicle Type: "+rst.getString(8));
          out.println("Vehicle Vin: "+rst.getString(9));
          
        }

    // if (Type.equals("truck")) {
    //   this.module.readTrukFromFile();

    //   this.view.displayTruck(module.getT(), out);
    // } else if (Type.equals("transport")) {
    //   this.module.readTransportFromFile();
    //   this.view.displayTransport(module.getTrans(), out);
    // } else {
    //   this.module.readPrivateCarFromFile();
    //   this.view.displayPrivateCar(module.getCar(), out);
    // }
  }

  public void displayAll(PrintWriter out) throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM vehicle ";
    Connection conn = DataBaseConnection.getDBConnection().getConnection();
    PreparedStatement stm = conn.prepareStatement(sql);
    
    ResultSet rst=stm.executeQuery();

    while(rst.next()){
      out.println("VehicleID: "+rst.getInt(1));
      out.println("Vehicle MOdel Name: "+rst.getString(2));
      out.println("Vehicle Model Year: "+rst.getInt(3));
      out.println("Vehicle annual Number: "+rst.getString(4));
      out.println("Vehicle Vehicle Color: "+rst.getString(5));
      out.println("Vehicle Owner Name: "+rst.getString(6));
      out.println("Vehicle Plate Number: "+rst.getInt(7));
      out.println("Vehicle Vehicle Type: "+rst.getString(8));
      out.println("Vehicle Vin: "+rst.getString(9));
      
    }




    // // truck || add truck to file
    // this.module.readTrukFromFile();

    // this.view.displayTruck(module.getT(), out);
    // // transport
    // this.module.readTransportFromFile();
    // this.view.displayTransport(module.getTrans(), out);
    // // private
    // this.module.readPrivateCarFromFile();
    // this.view.displayPrivateCar(module.getCar(), out);
  }

  public void serchForCar(String annual, String Type, PrintWriter out) throws SQLException, ClassNotFoundException {

    String sql = "SELECT * FROM vehicle WHERE annualNumber = ? , vehicleType = ? ";
    Connection conn = DataBaseConnection.getDBConnection().getConnection();
    PreparedStatement stm = conn.prepareStatement(sql);
    stm.setObject(1, annual);
    stm.setObject(2, Type);

    ResultSet rst=stm.executeQuery();

    while(rst.next()){
      out.println("VehicleID: "+rst.getInt(1));
      out.println("Vehicle MOdel Name: "+rst.getString(2));
      out.println("Vehicle Model Year: "+rst.getInt(3));
      out.println("Vehicle annual Number: "+rst.getString(4));
      out.println("Vehicle Vehicle Color: "+rst.getString(5));
      out.println("Vehicle Owner Name: "+rst.getString(6));
      out.println("Vehicle Plate Number: "+rst.getInt(7));
      out.println("Vehicle Vehicle Type: "+rst.getString(8));
      out.println("Vehicle Vin: "+rst.getString(9));
      
    }




    // //check type vehicle
    // if (Type.equals("truck")) {
    //   this.module.readTrukFromFile();
    //   this.module.getT()
    //     .stream()
    //     .filter(p -> p.getAnnualNumber().equals(annual)).skip(1)
    //     .forEach(out::println);
    // } else if (Type.equals("transport")) {
    //   this.module.readTransportFromFile();
    //   this.module.getTrans()
    //     .stream()
    //     .filter(p -> p.getAnnualNumber().equals(annual)).skip(1)
    //     .forEach(out::println);
    // } else if (Type.equals("private")) {
    //   this.module.readPrivateCarFromFile();
    //   this.module.getCar()
    //     .stream()
    //     .filter(p -> p.getAnnualNumber().equals(annual)).skip(1)
    //     .forEach(out::println);
    // }
  }

  public void DeleteVehicle(int plateNumber, String Type) throws ClassNotFoundException, SQLException {

    String sql = "DELETE FROM vehicle WHERE plateNumber ='"+plateNumber+"',vehicleType ='"+Type+"'";
    Connection conn = DataBaseConnection.getDBConnection().getConnection();
    PreparedStatement stm = conn.prepareStatement(sql);

      stm.executeUpdate();





    // if (Type.equals("truck")) {
    //   ////////////////

    //   this.module.readTrukFromFile();
    //   ((Collection<Truck>) this.module.getT().stream()).removeIf(p ->
    //       p.getPlateNumber() == plateNumber
    //     );
    //   this.module.addnewTruckToFile();
    // } else if (Type.equals("transport")) {
    //   this.module.readTransportFromFile();
    //   ((Collection<Truck>) this.module.getTrans().stream()).removeIf(p ->
    //       p.getPlateNumber() == plateNumber
    //     );
    //   this.module.aaddnewTransportCarToFile();
    // }
    // ///////////////

    // else if (Type.equals("private")) {
    //   this.module.readPrivateCarFromFile();
    //   ((Collection<Truck>) this.module.getCar().stream()).removeIf(p ->
    //       p.getPlateNumber() == plateNumber
    //     );
    //   this.module.addnewPrivateCarToFile();
    // }
  }
  ////////////

}
