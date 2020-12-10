package com.gofin.service;

import com.gofin.model.ParkingLot;

import java.util.List;

public class ParkingLotService {

    public List<ParkingLot> createParkingLotSpace(List<ParkingLot> parkingLotList, Integer parkingSpace) {
        int lastParkingId = parkingLotList.size() + 1;
        for (int index = 0; index < parkingSpace; index++) {
            ParkingLot parkingLot = new ParkingLot(lastParkingId + index);
            parkingLotList.add(parkingLot);
        }
        System.out.println("Created parking lot with " + parkingSpace + " slots");
        return parkingLotList;
    }

    public void getParkingLotStatus(List<ParkingLot> parkingLotList) {
        System.out.println("Slot No. \t Registration No.");
        if (parkingLotList.size() > 0) {
            parkingLotList.stream().forEach(parkingLot -> {
                if (parkingLot.getRegistrationNumber() != null) {
                    System.out.println(parkingLot.getParkingId() + " \t " + parkingLot.getRegistrationNumber());
                }
            });
        } else {
            System.out.println("No parking lot created");
        }
    }

    public boolean parkVehicle(List<ParkingLot> parkingLotList, String vehicleNumber) {
        boolean isParked = false;
        if (parkingLotList.size() > 0) {
            for (ParkingLot parkingLot : parkingLotList) {
                if (parkingLot.getRegistrationNumber() == null) {
                    parkingLot.setRegistrationNumber(vehicleNumber);
                    System.out.println("Allocated Slot Number : " + parkingLot.getParkingId());
                    isParked = true;
                    break;
                }
            }
            if (!isParked) {
                System.out.println("Sorry, parking lot is full");
            }
        } else {
            System.out.println("No parking lot created");
        }
        return isParked;
    }

    public boolean leaveVehicle(List<ParkingLot> parkingLotList, String registrationNumber, Float hours) {
        boolean isLeft = false;
        if (parkingLotList.size() > 0) {
            for (ParkingLot parkingLot : parkingLotList) {
                if (parkingLot.isVehicleParked(registrationNumber)) {
                    parkingLot.setRegistrationNumber(null);
                    isLeft = true;
                    System.out.println("Registration number " + registrationNumber + " with Slot Number " + parkingLot.getParkingId()
                            + " is free with Charge " + parkingCostCalculation(hours));
                    break;
                }
            }
            if (!isLeft) {
                System.out.println("Registration number " + registrationNumber + " not found");
            }
        } else {
            System.out.println("No parking lot created");
        }
        return isLeft;
    }

    private Integer parkingCostCalculation(Float hours) {
        Integer parkingCost;
        if (hours <= 2) {
            parkingCost = 10;
        } else {
            int remainingHours = (int) Math.ceil(hours) - 2;
            parkingCost = 10 + (remainingHours * 10);
        }
        return parkingCost;
    }

}
