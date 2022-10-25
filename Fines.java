import java.io.Serializable;

public class Fines  implements Serializable{


    private String carType;
    private Integer carPlateNumber;
    private String annualNumber;
    private String  finesHistoryDate;
    private String typeOfTrafficViolation;
    private Double amountOfTrafficViolationMoney;
    private Integer totalNumberOfTrafficViolation;
    private Double totalAmountOfTrafficViolationMoney;


//    public Fines() {
//    };

    public Fines(String carType, Integer carPlateNumber, String annualNumber, String finesHistoryDate, String typeOfTrafficViolation, Double amountOfTrafficViolationMoney, Integer totalNumberOfTrafficViolation, Double totalAmountOfTrafficViolationMoney) {
        this.carType = carType;
        this.carPlateNumber = carPlateNumber;
        this.annualNumber = annualNumber;
        this.finesHistoryDate = finesHistoryDate;
        this.typeOfTrafficViolation = typeOfTrafficViolation;
        this.amountOfTrafficViolationMoney = amountOfTrafficViolationMoney;
        this.totalNumberOfTrafficViolation = totalNumberOfTrafficViolation;
        this.totalAmountOfTrafficViolationMoney = totalAmountOfTrafficViolationMoney;
    }

    public String getFinesHistoryDate() {
        return finesHistoryDate;
    }

    public void setFinesHistoryDate(String finesHistoryDate) {
        this.finesHistoryDate = finesHistoryDate;
    }

    public String getTypeOfTrafficViolation() {
        return typeOfTrafficViolation;
    }

    public void setTypeOfTrafficViolation(String typeOfTrafficViolation) {
        this.typeOfTrafficViolation = typeOfTrafficViolation;
    }

    public Double getAmountOfTrafficViolationMoney() {
        return amountOfTrafficViolationMoney;
    }

    public void setAmountOfTrafficViolationMoney(Double amountOfTrafficViolationMoney) {
        this.amountOfTrafficViolationMoney = amountOfTrafficViolationMoney;
    }

    public Integer getTotalNumberOfTrafficViolation() {
        return totalNumberOfTrafficViolation;
    }

    public void setTotalNumberOfTrafficViolation(Integer totalNumberOfTrafficViolation) {
        this.totalNumberOfTrafficViolation = totalNumberOfTrafficViolation;
    }

    public Double getTotalAmountOfTrafficViolationMoney() {
        return totalAmountOfTrafficViolationMoney;
    }

    public void setTotalAmountOfTrafficViolationMoney(Double totalAmountOfTrafficViolationMoney) {
        this.totalAmountOfTrafficViolationMoney = totalAmountOfTrafficViolationMoney;
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

    public String getAnnualNumber() {
        return annualNumber;
    }

    public void setAnnualNumber(String annualNumber) {
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
    public String toString() {
        return "Fines [carType=" + carType + ", carPlateNumber=" + carPlateNumber + ", annualNumber=" + annualNumber
                + ", finesHistoryDate=" + finesHistoryDate + ", typeOfTrafficViolation=" + typeOfTrafficViolation
                + ", amountOfTrafficViolationMoney=" + amountOfTrafficViolationMoney
                + ", totalNumberOfTrafficViolation=" + totalNumberOfTrafficViolation
                + ", totalAmountOfTrafficViolationMoney=" + totalAmountOfTrafficViolationMoney + "]";
    }

}
