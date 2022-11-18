package Models;

import java.io.Serializable;
import java.util.Objects;

public class RenewAnnualModel implements Serializable {
    private Integer vehiclePlateNumber;
    private String ownerFullName;
    private String ownerAddress;
    private String carModel;
    private String carType;
    private String Vin;
    private String carColor;
    private String  startDate;
    private String endDate;
    private String vheicleSafetyEndDate;
    private String environmentFinesEndDate;
    private Integer vheicleChainNumber;//sequnece Number

    public RenewAnnualModel(Integer vehicleNumber, String fullName, String address, String carModel,
                            String carType, String carColor, String startDate, String endDate, Integer vheicleChainNumber, String carSafetyEndDate,
                            String environmentFinesEndDate, String vin) {
        this.vehiclePlateNumber = vehicleNumber;
        this.ownerFullName = fullName;
        this.ownerAddress = address;
        this.carModel = carModel;
        this.carType=carType;
        this.carColor = carColor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vheicleChainNumber = vheicleChainNumber;
        this.vheicleSafetyEndDate = carSafetyEndDate;
        this.environmentFinesEndDate = environmentFinesEndDate;
        this.Vin=vin;
    }
