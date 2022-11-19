package Controllers;

import Models.Truck;
import Models.VehicleModule;
import Views.VehicleView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Collection;

public class VehicleControler implements Serializable {

  VehicleModule module;
  VehicleView view;

  public VehicleControler(VehicleModule module, VehicleView view) {
    this.module = module;
    this.view = view;
  }

  public void addVhicle(PrintWriter out, BufferedReader in) throws IOException {
    this.module.addVhicle(this.view.addVhicle(out, in));
  }

  public void displayVehicle(String Type, PrintWriter out) {
    if (Type.equals("truck")) {
      this.module.readTrukFromFile();

      this.view.displayTruck(module.getT(), out);
    } else if (Type.equals("transport")) {
      this.module.readTransportFromFile();
      this.view.displayTransport(module.getTrans(), out);
    } else {
      this.module.readPrivateCarFromFile();
      this.view.displayPrivateCar(module.getCar(), out);
    }
  }

  public void displayAll(PrintWriter out) {
    // truck || add truck to file
    this.module.readTrukFromFile();

    this.view.displayTruck(module.getT(), out);
    // transport
    this.module.readTransportFromFile();
    this.view.displayTransport(module.getTrans(), out);
    // private
    this.module.readPrivateCarFromFile();
    this.view.displayPrivateCar(module.getCar(), out);
  }

  public void serchForCar(String annual, String Type, PrintWriter out) {
    //check type vehicle
    if (Type.equals("truck")) {
      this.module.readTrukFromFile();
      this.module.getT()
        .stream()
        .filter(p -> p.getAnnualNumber().equals(annual))
        .forEach(out::println);
    } else if (Type.equals("transport")) {
      this.module.readTransportFromFile();
      this.module.getTrans()
        .stream()
        .filter(p -> p.getAnnualNumber().equals(annual))
        .forEach(out::println);
    } else if (Type.equals("private")) {
      this.module.readPrivateCarFromFile();
      this.module.getCar()
        .stream()
        .filter(p -> p.getAnnualNumber().equals(annual))
        .forEach(out::println);
    }
  }

  public void DeleteVehicle(int plateNumber, String Type) {
    if (Type.equals("truck")) {
      ////////////////

      this.module.readTrukFromFile();
      ((Collection<Truck>) this.module.getT().stream()).removeIf(p ->
          p.getPlateNumber() == plateNumber
        );
      this.module.addnewTruckToFile();
    } else if (Type.equals("transport")) {
      this.module.readTransportFromFile();
      ((Collection<Truck>) this.module.getTrans().stream()).removeIf(p ->
          p.getPlateNumber() == plateNumber
        );
      this.module.aaddnewTransportCarToFile();
    }
    ///////////////

    else if (Type.equals("private")) {
      this.module.readPrivateCarFromFile();
      ((Collection<Truck>) this.module.getCar().stream()).removeIf(p ->
          p.getPlateNumber() == plateNumber
        );
      this.module.addnewPrivateCarToFile();
    }
  }
  ////////////

}
