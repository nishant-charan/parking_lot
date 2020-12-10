package com.gofin.model;

public class ParkingTicket {

    private String vehicleNumber;
    private Double parkingTime;
    private Double parkingCost;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Double getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(Double parkingTime) {
        this.parkingTime = parkingTime;
    }

    public Double getParkingCost() {
        return parkingCost;
    }

    public void setParkingCost(Double parkingCost) {
        this.parkingCost = parkingCost;
    }
}
