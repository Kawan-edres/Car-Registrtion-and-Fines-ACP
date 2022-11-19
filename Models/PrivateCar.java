package Models;

public class PrivateCar extends Vehicle {


    public PrivateCar(Integer vehicleId, String vehicleModelName, Integer vehicleYearModel, String annualNumber, String vehicleColor,
                      String ownerName, Integer plateNumber, String Vin) {
        super(vehicleId, vehicleModelName, vehicleYearModel, annualNumber, vehicleColor, ownerName, plateNumber,
                "private", Vin);

    }


}  

