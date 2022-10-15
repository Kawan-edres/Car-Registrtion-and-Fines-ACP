
public class Vehicle {

	private String vehicleModelName;
	private Integer vehicleYearModel;
	private String annualNumber;
	private String vehicleColor;
	private String annualId;
	private String ownerName;
	private Integer plateNumber;
	private String vehicleType;
    private VIN_Number Vin; //does not has a setter 

	public Vehicle() {
	}

	

	public Vehicle(String vehicleModelName, Integer vehicleYearModel, String annualNumber, String vehicleColor,
			String annualId, String ownerName, Integer plateNumber,String vehicleType,VIN_Number vin) {
		this.vehicleModelName = vehicleModelName;
		this.vehicleYearModel = vehicleYearModel;
		this.annualNumber = annualNumber;
		this.vehicleColor = vehicleColor;
		this.annualId = annualId;
		this.ownerName = ownerName;
		this.plateNumber = plateNumber;
		this. vehicleType=vehicleType;
		this.Vin=Vin;
	}


	

	public String getVehicleType() {
		return vehicleType;
	}



	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}



	public Integer getPlateNumber() {
		return plateNumber;
	}



	public void setPlateNumber(Integer plateNumber) {
		this.plateNumber = plateNumber;
	}



	public String getAnnualId() {
		return annualId;
	}

	public void setAnnualId(String annualId) {
		this.annualId = annualId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getvehicleModelName() {
		return vehicleModelName;
	}

	public void setvehicleModelName(String modelName) {
		this.vehicleModelName = modelName;
	}

	public int getvehicleYearModel() {
		return vehicleYearModel;
	}

	public void setvehicleYearModel(int year) {
		this.vehicleYearModel = year;
	}

	public String getAnnualNumber() {
		return annualNumber;
	}

	public void setAnnualNumber(String annualNumber) {
		this.annualNumber = annualNumber;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String color) {
		this.vehicleColor = color;
	}

	
	
	public VIN_Number getVin() {
		return Vin;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vehicleModelName == null) ? 0 : vehicleModelName.hashCode());
		result = prime * result + ((vehicleYearModel == null) ? 0 : vehicleYearModel.hashCode());
		result = prime * result + ((annualNumber == null) ? 0 : annualNumber.hashCode());
		result = prime * result + ((vehicleColor == null) ? 0 : vehicleColor.hashCode());
		result = prime * result + ((annualId == null) ? 0 : annualId.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (vehicleModelName == null) {
			if (other.vehicleModelName != null)
				return false;
		} else if (!vehicleModelName.equals(other.vehicleModelName))
			return false;
		if (vehicleYearModel == null) {
			if (other.vehicleYearModel != null)
				return false;
		} else if (!vehicleYearModel.equals(other.vehicleYearModel))
			return false;
		if (annualNumber == null) {
			if (other.annualNumber != null)
				return false;
		} else if (!annualNumber.equals(other.annualNumber))
			return false;
		if (vehicleColor == null) {
			if (other.vehicleColor != null)
				return false;
		} else if (!vehicleColor.equals(other.vehicleColor))
			return false;
		if (annualId == null) {
			if (other.annualId != null)
				return false;
		} else if (!annualId.equals(other.annualId))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleModelName=" + vehicleModelName + ", vehicleYearModel=" + vehicleYearModel
				+ ", annualNumber=" + annualNumber + ", vehicleColor=" + vehicleColor + ", annualId=" + annualId
				+ ", ownerName=" + ownerName + "]";
	}


	
}