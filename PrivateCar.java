public class PrivateCar extends Vehicle {

    public PrivateCar() {
    }

    public PrivateCar(String vehicleModelName, Integer vehicleYearModel, String annualNumber, String vehicleColor,
            String annualId, String ownerName, Integer plateNumber, String vehicleType) {
        super(vehicleModelName, vehicleYearModel, annualNumber, vehicleColor, annualId, ownerName, plateNumber,
                "private");
    }

    

}
