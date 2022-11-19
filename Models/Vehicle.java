package Models;

import java.io.Serializable;

public class Vehicle implements Serializable {
    private Integer vehicleId;
    private String vehicleModelName;
    private Integer vehicleYearModel;
    private String annualNumber;
    private String vehicleColor;
    private String ownerName;
    private Integer plateNumber;
    private String vehicleType;
    private String Vin;

    public Vehicle(Integer vehicleId, String vehicleModelName, Integer vehicleYearModel, String annualNumber, String vehicleColor,
                   String ownerName, Integer plateNumber, String vehicleType, String vin) {
        this.vehicleId=vehicleId;
        this.vehicleModelName = vehicleModelName;
        this.vehicleYearModel = vehicleYearModel;
        this.annualNumber = annualNumber;
        this.vehicleColor = vehicleColor;
        this.ownerName = ownerName;
        this.plateNumber = plateNumber;
        this.vehicleType = vehicleType;
        this.Vin = vin;
    }


    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public Integer getVehicleYearModel() {
        return vehicleYearModel;
    }

    public void setVehicleYearModel(Integer vehicleYearModel) {
        this.vehicleYearModel = vehicleYearModel;
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

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(Integer plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }


    public boolean equals(Vehicle v) {
        if (this.annualNumber.equals(v.annualNumber) &&
                this.vehicleModelName.equals(v.vehicleModelName)
                && this.vehicleType.equals(v.vehicleType) &&
                this.vehicleColor.equals(v.vehicleColor) &&
                this.ownerName.equals(v.ownerName)) {
            return  true;

        }
        return  false;


    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleModelName='" + vehicleModelName + '\'' +
                ", vehicleYearModel=" + vehicleYearModel +
                ", annualNumber='" + annualNumber + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +

                ", ownerName='" + ownerName + '\'' +
                ", plateNumber=" + plateNumber +
                ", vehicleType='" + vehicleType + '\'' +
                ", Vin='" + Vin + '\'' +
                '}';
    }
}
