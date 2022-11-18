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
