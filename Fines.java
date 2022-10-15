public class Fines {
    private String carType;
    private Integer carPlateNumber;
    private Integer annualNumber;

    public Fines() {
    };

    public Fines(String carType, Integer carPlateNumber, Integer annualNumber) {
        this.carType = carType;
        this.carPlateNumber = carPlateNumber;
        this.annualNumber = annualNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(Integer carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public Integer getAnnualNumber() {
        return annualNumber;
    }

    public void setAnnualNumber(Integer annualNumber) {
        this.annualNumber = annualNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carType == null) ? 0 : carType.hashCode());
        result = prime * result + ((carPlateNumber == null) ? 0 : carPlateNumber.hashCode());
        result = prime * result + ((annualNumber == null) ? 0 : annualNumber.hashCode());
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
        Fines other = (Fines) obj;
        if (carType == null) {
            if (other.carType != null)
                return false;
        } else if (!carType.equals(other.carType))
            return false;
        if (carPlateNumber == null) {
            if (other.carPlateNumber != null)
                return false;
        } else if (!carPlateNumber.equals(other.carPlateNumber))
            return false;
        if (annualNumber == null) {
            if (other.annualNumber != null)
                return false;
        } else if (!annualNumber.equals(other.annualNumber))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Fines [carType=" + carType + ", carPlateNumber=" + carPlateNumber + ", annualNumber=" + annualNumber
                + "]";
    }

}
