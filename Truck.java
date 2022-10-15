public class Truck extends Vehicle {


	private Double truckTonWeight;

	public Truck() {}

	public Truck(String vehicleModelName, Integer vehicleYearModel, String annualNumber, String vehicleColor,
			String annualId, String ownerName, Integer plateNumber, Double truckTonWeight,VIN_Number Vin ) {
		super(vehicleModelName, vehicleYearModel, annualNumber, vehicleColor, annualId, ownerName, plateNumber,"truck",Vin);
		this.truckTonWeight = truckTonWeight;
	}

	public Double getTruckTonWeight() {
		return truckTonWeight;
	}

	public void setTruckTonWeight(Double truckTonWeight) {
		this.truckTonWeight = truckTonWeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((truckTonWeight == null) ? 0 : truckTonWeight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Truck other = (Truck) obj;
		if (truckTonWeight == null) {
			if (other.truckTonWeight != null)
				return false;
		} else if (!truckTonWeight.equals(other.truckTonWeight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Truck [truckTonWeight=" + truckTonWeight + "]";
	}


	
	
	





}