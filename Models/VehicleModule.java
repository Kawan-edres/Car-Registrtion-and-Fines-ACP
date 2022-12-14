package Models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class VehicleModule implements Serializable {

   DataBaseConnection d= new DataBaseConnection();
  
  private static Set<Truck> t = new HashSet<>();
  private static Set<TransportCar> trans = new HashSet<TransportCar>();
  private static Set<PrivateCar> car = new HashSet<PrivateCar>();

  public int addVhicle(Vehicle v) throws SQLException, ClassNotFoundException { // v= ragrover
    String SQL="INSERT INTO vehicle VALUES(?,?,?,?,?,?,?,?,?)";

    Connection conn = DataBaseConnection.getDBConnection().getConnection();

    PreparedStatement stm = conn.prepareStatement(SQL);

    stm.setObject(1, v.getVehicleId());
    stm.setObject(2, v.getVehicleModelName());
    stm.setObject(3, v.getVehicleYearModel());
    stm.setObject(4, v.getAnnualNumber());
    stm.setObject(5, v.getVehicleColor());
    stm.setObject(6, v.getOwnerName());
    stm.setObject(7, v.getPlateNumber());
    stm.setObject(8, v.getVehicleType());
    stm.setObject(9, v.getVin());

     return stm.executeUpdate();

    // if (v.getVehicleType().equals("truck")) {
    //   readTrukFromFile();

    //   t.add((Truck) v);
    //   addnewTruckToFile();
    // } else if (v.getVehicleType().equals("transport")) {
    //   readTransportFromFile();
    //   trans.add((TransportCar) v);

    //   aaddnewTransportCarToFile();
    // } else if (v.getVehicleType().equals("private")) {
    //   readPrivateCarFromFile();
    //   car.add((PrivateCar) v);

    //   addnewPrivateCarToFile();
    // }
  }

  // Truck
  public void addnewTruckToFile() {
    try {
      ObjectOutputStream outData = new ObjectOutputStream(
        new FileOutputStream("Truck.txt")
      );
      outData.writeObject(t);
      outData.flush();
      outData.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //transport car
  public void aaddnewTransportCarToFile() {
    try {
      ObjectOutputStream outData = new ObjectOutputStream(
        new FileOutputStream("TransportCars.txt")
      );
      outData.writeObject(trans);
      outData.flush();
      outData.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //private car
  public void addnewPrivateCarToFile() {
    try {
      ObjectOutputStream outData = new ObjectOutputStream(
        new FileOutputStream("PrivateCars.txt")
      );
      outData.writeObject(car);
      outData.flush();
      outData.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readTrukFromFile() {
    try {
      ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("Truck.txt")
      );
      t = (HashSet<Truck>) in.readObject();
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void readTransportFromFile() {
    try {
      ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("TransportCars.txt")
      );
      trans = (HashSet<TransportCar>) in.readObject();
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void readPrivateCarFromFile() {
    try {
      ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("PrivateCars.txt")
      );
      car = (HashSet<PrivateCar>) in.readObject();
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {}
  }

  public Set<Truck> getT() {
    return t;
  }

  public Set<TransportCar> getTrans() {
    return trans;
  }

  public Set<PrivateCar> getCar() {
    return car;
  }
}
