package com.gofin;

import com.gofin.model.ParkingLot;
import com.gofin.service.ParkingLotService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotApplication {

    public static List<ParkingLot> parkingLots = new ArrayList<>();

    public static void main(String [] args) throws IOException {
        ParkingLotService parkingLotService = new ParkingLotService();
        File file =  new File("./bin/parking_lot file_inputs.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String command;
        while ((command = bufferedReader.readLine()) != null) {
            String[] commandSplit = command.split("\\s+");
            if (command.contains("create_parking_lot")) {
                int parkingSpace = Integer.parseInt(commandSplit[1]);
                parkingLotService.createParkingLotSpace(parkingLots, parkingSpace);
            } else if (command.contains("park")) {
                String registrationNumber = commandSplit[1];
                parkingLotService.parkVehicle(parkingLots, registrationNumber);
            } else if (command.contains("leave")) {
                String registrationNumber = commandSplit[1];
                float hours = Float.parseFloat(commandSplit[2]);
                parkingLotService.leaveVehicle(parkingLots, registrationNumber, hours);
            } else if (command.contains("status")) {
                parkingLotService.getParkingLotStatus(parkingLots);
            }
        }
    }

}
