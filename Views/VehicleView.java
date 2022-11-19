package Views;

import Controllers.VehicleControler;
import Models.PrivateCar;
import Models.TransportCar;
import Models.Truck;
import Models.Vehicle;
import Models.VehicleModule;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;

public class VehicleView implements Serializable {

  static Scanner scan = new Scanner(System.in);

  public Vehicle addVhicle(PrintWriter out, BufferedReader in)
    throws IOException {
    out.println("enter vehicleType: truck || transport || private ");
    out.println("k");
    String type = in.readLine();
    boolean check = true;
    while (check) {
      if (
        !(
          type.equals("truck") ||
          type.equals("transport") ||
          type.equals("private")
        )
      ) {
        out.println("the type of car must be truck or transport or car");
        out.println("k");
        type = in.readLine();
      } else {
        check = false;
      }
    }
    out.println("enter vhicle model: ");
    out.println("k");
    String model = in.readLine();
    out.println("enter vhicle Year: ");
    out.println("k");
    Integer year = Integer.parseInt(in.readLine());
    out.println("enter annual Number:  ");
    out.println("k");
    String annualNo = in.readLine();
    out.println("enter vhicle color: ");
    out.println("k");
    String color = in.readLine();
    out.println("enter owner Name: ");
    out.println("k");
    String owner = in.readLine();
    out.println("enter plate Number: ");
    out.println("k");
    Integer plateNo = Integer.parseInt(in.readLine());

    out.println("enter vin number: ");
    out.println("k");
    String Vin = in.readLine();

    if (type.equals("truck")) {
      return new Truck(
        plateNo,
        model,
        year,
        annualNo,
        color,
        owner,
        plateNo,
        null,
        Vin
      );
    } else if (type.equals("transport")) {
      return new TransportCar(
        plateNo,
        model,
        year,
        annualNo,
        color,
        owner,
        plateNo,
        Vin
      );
    } else if (type.equals("private")) {
      return (
        new PrivateCar(
          plateNo,
          model,
          year,
          annualNo,
          color,
          owner,
          plateNo,
          Vin
        )
      ); // = rangrovar
    }
    return null;
  }

  /////////////////////////////////////////////////////

  public void displayTruck(Set<Truck> truck, PrintWriter out) {
    truck.stream().forEach(p -> out.println(p));
  }

  public void displayTransport(Set<TransportCar> trans, PrintWriter out) {
    trans.stream().forEach(p -> out.println(p));
  }

  public void displayPrivateCar(Set<PrivateCar> privateCar, PrintWriter out) {
    privateCar.stream().forEach(p -> out.println(p));
  }

  public static void menu(PrintWriter out, BufferedReader in)
    throws IOException {
    VehicleControler v = new VehicleControler(
      new VehicleModule(),
      new VehicleView()
    );

    int c;
    do {
      out.println("Welcome to the  Car Fines System ");
      out.println("------------------------------------");
      out.println("Choose What do you want :");
      out.println("1-Add Vehicle ");
      out.println("2-display car");
      out.println("3-Display All display all type of car ");
      out.println("4-Search for spesfic Car");
      out.println("5-Delete a Vehicle");
      out.println("6- Exit");
      out.println("k");
      c = Integer.parseInt(in.readLine());

      switch (c) {
        case 1:
          v.addVhicle(out, in);
          break;
        case 2:
          out.println("Display Enter the type of car ");
          out.println("k");
          String type = in.readLine();
          v.displayVehicle(type, out);

          break;
        case 3:
          v.displayAll(out);
          break;
        case 4:
          out.println("what is the type of car :");
          out.println("k");
          String Type = in.readLine();
          out.println("Enter the annual number of the vehicle:");
          out.println("k");
          String annual = in.readLine();

          v.serchForCar(annual, Type, out);
          break;
        case 5:
          out.println("what is the type of car :");
          out.println("k");
          String Type1 = in.readLine();
          out.println("Enter the plate number of the vehicle:");
          out.println("k");
          int platnum = Integer.parseInt(in.readLine());
          v.DeleteVehicle(platnum, Type1);
          out.println("Vehicle Deleted");
          break;
        case 6:
          out.println("Exit...");
        default:
          out.println("Choose on of the above options to start !");
          break;
      }
    } while (c != '6');
  }
}
