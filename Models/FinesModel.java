package Models;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class FinesModel implements Serializable {


    private String carType;
    private Integer carPlateNumber;
    private String annualNumber;
    private String finesHistoryDate;
    private String typeOfTrafficViolation;
    private Double amountOfTrafficViolationMoney;
    private Integer totalNumberOfTrafficViolation;
    private Double totalAmountOfTrafficViolationMoney;

    public FinesModel(String carType, Integer carPlateNumber, String annualNumber, Date finesHistoryDate, String typeOfTrafficViolation, Double amountOfTrafficViolationMoney, Integer totalNumberOfTrafficViolation, Double totalAmountOfTrafficViolationMoney) {
        this.carType = carType;
        this.carPlateNumber = carPlateNumber;
        this.annualNumber = annualNumber;
        this.finesHistoryDate = String.valueOf(finesHistoryDate);
        this.typeOfTrafficViolation = typeOfTrafficViolation;
        this.amountOfTrafficViolationMoney = amountOfTrafficViolationMoney;
        this.totalNumberOfTrafficViolation = totalNumberOfTrafficViolation;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinesModel model)) return false;
        return Objects.equals(getCarType(), model.getCarType()) && Objects.equals(getCarPlateNumber(), model.getCarPlateNumber()) && Objects.equals(getAnnualNumber(), model.getAnnualNumber()) && Objects.equals(getFinesHistoryDate(), model.getFinesHistoryDate()) && Objects.equals(getTypeOfTrafficViolation(), model.getTypeOfTrafficViolation()) && Objects.equals(getAmountOfTrafficViolationMoney(), model.getAmountOfTrafficViolationMoney()) && Objects.equals(getTotalNumberOfTrafficViolation(), model.getTotalNumberOfTrafficViolation()) && Objects.equals(getTotalAmountOfTrafficViolationMoney(), model.getTotalAmountOfTrafficViolationMoney());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarType(), getCarPlateNumber(), getAnnualNumber(), getFinesHistoryDate(), getTypeOfTrafficViolation(), getAmountOfTrafficViolationMoney(), getTotalNumberOfTrafficViolation(), getTotalAmountOfTrafficViolationMoney());
    }

    @Override
    public String toString() {
        return "Model{" +
                "carType='" + carType + '\'' +
                ", carPlateNumber=" + carPlateNumber +
                ", annualNumber='" + annualNumber + '\'' +
                ", finesHistoryDate='" + finesHistoryDate + '\'' +
                ", typeOfTrafficViolation='" + typeOfTrafficViolation + '\'' +
                ", amountOfTrafficViolationMoney=" + amountOfTrafficViolationMoney +
                ", totalNumberOfTrafficViolation=" + totalNumberOfTrafficViolation +
                ", totalAmountOfTrafficViolationMoney=" + totalAmountOfTrafficViolationMoney +
                '}';
    }

}
