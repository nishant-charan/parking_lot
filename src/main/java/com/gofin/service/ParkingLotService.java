package com.gofin.service;

import com.gofin.model.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {

    public List<ParkingLot> createParkingLotSpace(Integer limit) {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        for (int index = 1; index <= limit; index++) {
            ParkingLot parkingLot = new ParkingLot(index);
            parkingLotList.add(parkingLot);
        }
        return parkingLotList;
    }

    public void getParkingLotStatus(List<ParkingLot> parkingLotList) {
        System.out.println("Slot No. \t Registration No.");
        parkingLotList.stream().forEach(parkingLot -> {
            if (parkingLot.getVehicleNumber() != null) {
                System.out.println(parkingLot.getParkingId() + " \t\t\t " + parkingLot.getVehicleNumber());
            }
        });
    }

    public boolean parkVehicle(List<ParkingLot> parkingLotList, String vehicleNumber) {
        boolean isParked = false;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getVehicleNumber() == null) {
                parkingLot.setVehicleNumber(vehicleNumber);
                System.out.println("Allocated Slot Number : " + parkingLot.getParkingId());
                isParked = true;
                break;
            }
        }
        if (!isParked) {
            System.out.println("Sorry, parking lot is full");
        }
        return isParked;
    }

    public boolean leaveVehicle(List<ParkingLot> parkingLotList, String vehicleNumber, Integer hours) {
        boolean isLeft = false;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getVehicleNumber().equals(vehicleNumber)) {
                parkingLot.setVehicleNumber(null);
                isLeft = true;
                System.out.println("Registration number " + vehicleNumber + " with Slot Number " + parkingLot.getParkingId()
                        + " is free with Charge " + parkingCostCalculation(hours));
            }
        }
        return isLeft;
    }

    private Integer parkingCostCalculation(Integer hours) {
        Integer parkingCost;
        if (hours <= 2) {
            parkingCost = 10;
        } else {
            parkingCost = 10 + ((hours - 2) * 10);
        }
        return parkingCost;
    }

}
