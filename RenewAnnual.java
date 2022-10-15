import java.util.Date;

public class RenewAnnual {

    private Integer vehiclePlateNumber;
    private String ownerFullName;
    private String ownerAddress;
    private String carModel;
    private VIN_Number Vin; 
    private String carColor;
    private Date startDate;
    private Date endDate;
    private Date vheicleSafetyEndDate;
    private Date environmentFinesEndDate;
    private Integer vheicleChainNumber;//sequnece Number

    public RenewAnnual() {
    }

    public RenewAnnual(Integer vehicleNumber, String fullName, String address, String carModel,
            String carColor, Date startDate, Date endDate, Integer vheicleChainNumber, Date carSafetyEndDate,
            Date environmentFinesEndDate,VIN_Number vin) {
        this.vehiclePlateNumber = vehicleNumber;
        this.ownerFullName = fullName;
        this.ownerAddress = address;
        this.carModel = carModel;
        // this.Vin = Vin;
        this.carColor = carColor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vheicleChainNumber = vheicleChainNumber;
        this.vheicleSafetyEndDate = carSafetyEndDate;
        this.environmentFinesEndDate = environmentFinesEndDate;
        this.Vin=vin;
    }

    public Integer getVehicleNumber() {
        return vehiclePlateNumber;
    }

    public void setVehicleNumber(Integer vehicleNumber) {
        this.vehiclePlateNumber = vehicleNumber;
    }

    public String getFullName() {
        return ownerFullName;
    }

    public void setFullName(String fullName) {
        this.ownerFullName = fullName;
    }

    public String getAddress() {
        return ownerAddress;
    }

    public void setAddress(String address) {
        this.ownerAddress = address;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    // public String getCarBodyNumber() {
        // return carBodyNumber;
    // }

    // public void setCarBodyNumber(String carBodyNumber) {
        // this.carBodyNumber = carBodyNumber;
    // }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Integer getVheicleChainNumber() {
        return vheicleChainNumber;
    }

    public void setVheicleChainNumber(Integer vheicleChainNumber) {
        this.vheicleChainNumber = vheicleChainNumber;
    }

    

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getVheicleSafetyEndDate() {
        return vheicleSafetyEndDate;
    }

    public void setVheicleSafetyEndDate(Date vheicleSafetyEndDate) {
        this.vheicleSafetyEndDate = vheicleSafetyEndDate;
    }

    public Date getEnvironmentFinesEndDate() {
        return environmentFinesEndDate;
    }

    public void setEnvironmentFinesEndDate(Date environmentFinesEndDate) {
        this.environmentFinesEndDate = environmentFinesEndDate;
    }

    

    public VIN_Number getVin() {
        return Vin;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vehiclePlateNumber == null) ? 0 : vehiclePlateNumber.hashCode());
        result = prime * result + ((ownerFullName == null) ? 0 : ownerFullName.hashCode());
        result = prime * result + ((ownerAddress == null) ? 0 : ownerAddress.hashCode());
        result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
        result = prime * result + ((carColor == null) ? 0 : carColor.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((vheicleChainNumber == null) ? 0 : vheicleChainNumber.hashCode());
        result = prime * result + ((vheicleSafetyEndDate == null) ? 0 : vheicleSafetyEndDate.hashCode());
        result = prime * result + ((environmentFinesEndDate == null) ? 0 : environmentFinesEndDate.hashCode());
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
        RenewAnnual other = (RenewAnnual) obj;
        if (vehiclePlateNumber == null) {
            if (other.vehiclePlateNumber != null)
                return false;
        } else if (!vehiclePlateNumber.equals(other.vehiclePlateNumber))
            return false;
        if (ownerFullName == null) {
            if (other.ownerFullName != null)
                return false;
        } else if (!ownerFullName.equals(other.ownerFullName))
            return false;
        if (ownerAddress == null) {
            if (other.ownerAddress != null)
                return false;
        } else if (!ownerAddress.equals(other.ownerAddress))
            return false;
        if (carModel == null) {
            if (other.carModel != null)
                return false;
        } else if (!carModel.equals(other.carModel))
            return false;
        if (carColor == null) {
            if (other.carColor != null)
                return false;
        } else if (!carColor.equals(other.carColor))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (vheicleChainNumber == null) {
            if (other.vheicleChainNumber != null)
                return false;
        } else if (!vheicleChainNumber.equals(other.vheicleChainNumber))
            return false;
        if (vheicleSafetyEndDate == null) {
            if (other.vheicleSafetyEndDate != null)
                return false;
        } else if (!vheicleSafetyEndDate.equals(other.vheicleSafetyEndDate))
            return false;
        if (environmentFinesEndDate == null) {
            if (other.environmentFinesEndDate != null)
                return false;
        } else if (!environmentFinesEndDate.equals(other.environmentFinesEndDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RenewAnnual [vehiclePlateNumber=" + vehiclePlateNumber + ", ownerFullName=" + ownerFullName
                + ", ownerAddress=" + ownerAddress + ", carModel=" + carModel + ", carColor=" + carColor
                + ", startDate=" + startDate + ", endDate=" + endDate + ", vheicleChainNumber=" + vheicleChainNumber
                + ", vheicleSafetyEndDate=" + vheicleSafetyEndDate + ", environmentFinesEndDate="
                + environmentFinesEndDate + "]";
    }

    
 
    
 
}
 


