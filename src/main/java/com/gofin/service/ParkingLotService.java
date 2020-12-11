package com.gofin.service;

import com.gofin.model.ParkingLot;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ParkingLotService {

    private static Logger logger = Logger.getLogger(ParkingLotService.class.getName());

    public static List<ParkingLot> parkingLots = new ArrayList<>();

    public void readCommandFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String command;
        while ((command = bufferedReader.readLine()) != null) {
            String[] commandSplit = command.split("\\s+");
            if (command.contains("create_parking_lot")) {
                int parkingSpace = Integer.parseInt(commandSplit[1]);
                createParkingLotSpace(parkingLots, parkingSpace);
            } else if (command.contains("park")) {
                String registrationNumber = commandSplit[1];
                parkVehicle(parkingLots, registrationNumber);
            } else if (command.contains("leave")) {
                String registrationNumber = commandSplit[1];
                float hours = Float.parseFloat(commandSplit[2]);
                leaveVehicle(parkingLots, registrationNumber, hours);
            } else if (command.contains("status")) {
                getParkingLotStatus(parkingLots);
            }
        }
    }

    protected List<ParkingLot> createParkingLotSpace(List<ParkingLot> parkingLotList, Integer parkingSpace) {
        int lastParkingId = parkingLotList.size() + 1;
        for (int index = 0; index < parkingSpace; index++) {
            ParkingLot parkingLot = new ParkingLot(lastParkingId + index);
            parkingLotList.add(parkingLot);
        }
        logger.info("Created parking lot with " + parkingSpace + " slots");
        return parkingLotList;
    }

    protected void getParkingLotStatus(List<ParkingLot> parkingLotList) {
        logger.info("Slot No. \t Registration No.");
        if (parkingLotList.size() > 0) {
            parkingLotList.stream().forEach(parkingLot -> {
                if (parkingLot.getRegistrationNumber() != null) {
                    logger.info(parkingLot.getParkingId() + " \t " + parkingLot.getRegistrationNumber());
                }
            });
        } else {
            logger.warning("No parking lot created");
        }
    }

    protected boolean parkVehicle(List<ParkingLot> parkingLotList, String vehicleNumber) {
        boolean isParked = false;
        if (parkingLotList.size() > 0) {
            for (ParkingLot parkingLot : parkingLotList) {
                if (parkingLot.getRegistrationNumber() == null) {
                    parkingLot.setRegistrationNumber(vehicleNumber);
                    logger.info("Allocated Slot Number : " + parkingLot.getParkingId());
                    isParked = true;
                    break;
                }
            }
            if (!isParked) {
                logger.info("Sorry, parking lot is full");
            }
        } else {
            logger.warning("No parking lot created");
        }
        return isParked;
    }

    protected boolean leaveVehicle(List<ParkingLot> parkingLotList, String registrationNumber, Float hours) {
        boolean isLeft = false;
        if (parkingLotList.size() > 0) {
            for (ParkingLot parkingLot : parkingLotList) {
                if (parkingLot.isVehicleParked(registrationNumber)) {
                    parkingLot.setRegistrationNumber(null);
                    isLeft = true;
                    logger.info("Registration number " + registrationNumber + " with Slot Number " + parkingLot.getParkingId()
                            + " is free with Charge " + parkingCostCalculation(hours));
                    break;
                }
            }
            if (!isLeft) {
                logger.info("Registration number " + registrationNumber + " not found");
            }
        } else {
            logger.warning("No parking lot created");
        }
        return isLeft;
    }

    private int parkingCostCalculation(Float hours) {
        int parkingCost;
        if (hours <= 2) {
            parkingCost = 10;
        } else {
            int remainingHours = (int) Math.ceil(hours) - 2;
            parkingCost = 10 + (remainingHours * 10);
        }
        return parkingCost;
    }

}
