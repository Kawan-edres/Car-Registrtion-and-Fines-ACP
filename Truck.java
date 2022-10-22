
public class Truck extends Vehicle {


    private Double truckTonWeight;




    public Truck(Integer vehicleId,String vehicleModelName, Integer vehicleYearModel, String annualNumber, String vehicleColor, String ownerName, Integer plateNumber, Double truckTonWeight,String Vin ) {
        super(vehicleId,vehicleModelName, vehicleYearModel, annualNumber, vehicleColor, ownerName, plateNumber,"truck",Vin);
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
        return  super.toString()+"Truck{" +
                "truckTonWeight=" + truckTonWeight +
                '}';
    }
}

