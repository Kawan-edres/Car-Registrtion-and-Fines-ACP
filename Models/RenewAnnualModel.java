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
  private String startDate;
  private String endDate;
  private String vheicleSafetyEndDate;
  private String environmentFinesEndDate;
  private Integer vheicleChainNumber; //sequnece Number

  public RenewAnnualModel(
    Integer vehicleNumber,
    String fullName,
    String address,
    String carModel,
    String carType,
    String carColor,
    String startDate,
    String endDate,
    Integer vheicleChainNumber,
    String carSafetyEndDate,
    String environmentFinesEndDate,
    String vin
  ) {
    this.vehiclePlateNumber = vehicleNumber;
    this.ownerFullName = fullName;
    this.ownerAddress = address;
    this.carModel = carModel;
    this.carType = carType;
    this.carColor = carColor;
    this.startDate = startDate;
    this.endDate = endDate;
    this.vheicleChainNumber = vheicleChainNumber;
    this.vheicleSafetyEndDate = carSafetyEndDate;
    this.environmentFinesEndDate = environmentFinesEndDate;
    this.Vin = vin;
  }

  public Integer getVehiclePlateNumber() {
    return vehiclePlateNumber;
  }

  public void setVehiclePlateNumber(Integer vehiclePlateNumber) {
    this.vehiclePlateNumber = vehiclePlateNumber;
  }

  public String getOwnerFullName() {
    return ownerFullName;
  }

  public void setOwnerFullName(String ownerFullName) {
    this.ownerFullName = ownerFullName;
  }

  public String getOwnerAddress() {
    return ownerAddress;
  }

  public void setOwnerAddress(String ownerAddress) {
    this.ownerAddress = ownerAddress;
  }

  public String getCarModel() {
    return carModel;
  }

  public void setCarModel(String carModel) {
    this.carModel = carModel;
  }

  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }

  public String getVin() {
    return Vin;
  }

  public void setVin(String vin) {
    Vin = vin;
  }

  public String getCarColor() {
    return carColor;
  }

  public void setCarColor(String carColor) {
    this.carColor = carColor;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getVheicleSafetyEndDate() {
    return vheicleSafetyEndDate;
  }

  public void setVheicleSafetyEndDate(String vheicleSafetyEndDate) {
    this.vheicleSafetyEndDate = vheicleSafetyEndDate;
  }

  public String getEnvironmentFinesEndDate() {
    return environmentFinesEndDate;
  }

  public void setEnvironmentFinesEndDate(String environmentFinesEndDate) {
    this.environmentFinesEndDate = environmentFinesEndDate;
  }

  public Integer getVheicleChainNumber() {
    return vheicleChainNumber;
  }

  public void setVheicleChainNumber(Integer vheicleChainNumber) {
    this.vheicleChainNumber = vheicleChainNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RenewAnnualModel that)) return false;
    return (
      Objects.equals(getVehiclePlateNumber(), that.getVehiclePlateNumber()) &&
      Objects.equals(getOwnerFullName(), that.getOwnerFullName()) &&
      Objects.equals(getOwnerAddress(), that.getOwnerAddress()) &&
      Objects.equals(getCarModel(), that.getCarModel()) &&
      Objects.equals(getCarType(), that.getCarType()) &&
      Objects.equals(getVin(), that.getVin()) &&
      Objects.equals(getCarColor(), that.getCarColor()) &&
      Objects.equals(getStartDate(), that.getStartDate()) &&
      Objects.equals(getEndDate(), that.getEndDate()) &&
      Objects.equals(
        getVheicleSafetyEndDate(),
        that.getVheicleSafetyEndDate()
      ) &&
      Objects.equals(
        getEnvironmentFinesEndDate(),
        that.getEnvironmentFinesEndDate()
      ) &&
      Objects.equals(getVheicleChainNumber(), that.getVheicleChainNumber())
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      getVehiclePlateNumber(),
      getOwnerFullName(),
      getOwnerAddress(),
      getCarModel(),
      getCarType(),
      getVin(),
      getCarColor(),
      getStartDate(),
      getEndDate(),
      getVheicleSafetyEndDate(),
      getEnvironmentFinesEndDate(),
      getVheicleChainNumber()
    );
  }

  @Override
  public String toString() {
    return (
      "Model{" +
      "vehiclePlateNumber=" +
      vehiclePlateNumber +
      ", ownerFullName='" +
      ownerFullName +
      '\'' +
      ", ownerAddress='" +
      ownerAddress +
      '\'' +
      ", carModel='" +
      carModel +
      '\'' +
      ", carType='" +
      carType +
      '\'' +
      ", Vin='" +
      Vin +
      '\'' +
      ", carColor='" +
      carColor +
      '\'' +
      ", startDate='" +
      startDate +
      '\'' +
      ", endDate='" +
      endDate +
      '\'' +
      ", vheicleSafetyEndDate='" +
      vheicleSafetyEndDate +
      '\'' +
      ", environmentFinesEndDate='" +
      environmentFinesEndDate +
      '\'' +
      ", vheicleChainNumber=" +
      vheicleChainNumber +
      '}'
    );
  }
}
