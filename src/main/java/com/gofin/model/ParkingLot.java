package com.gofin.model;

public class ParkingLot {

    private Integer parkingId;
    private String registrationNumber;

    public ParkingLot(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isVehicleParked(String registrationNumber) {
        boolean flag = false;
        if (this.registrationNumber != null
                && this.registrationNumber.equals(registrationNumber)) {
            flag = true;
        }
        return flag;
    }
}
