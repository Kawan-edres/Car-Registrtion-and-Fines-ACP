public class TtransportCar extends Vehicle {

	public TtransportCar() {
	}

	public TtransportCar(String vehicleModelName, Integer vehicleYearModel, String annualNumber, String vehicleColor,
			String annualId, String ownerName, Integer plateNumber, String vehicleType ,VIN_Number Vin) {
		super(vehicleModelName, vehicleYearModel, annualNumber, vehicleColor, annualId, ownerName, plateNumber,"transport",Vin);
	}

}
