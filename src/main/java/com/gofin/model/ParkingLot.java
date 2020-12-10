package com.gofin.model;

public class ParkingLot {

    private Integer parkingId;
    private Boolean isAvailable;
    private ParkingTicket parkingTicket;

    public ParkingLot(Integer parkingId) {
        this.parkingId = parkingId;
        this.isAvailable = true;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }
}
