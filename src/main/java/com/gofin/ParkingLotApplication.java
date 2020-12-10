package com.gofin;

import com.gofin.service.ParkingLotService;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ParkingLotApplication {

    public static void main(String [] args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        Scanner inScanner = new Scanner(System.in);
        System.out.print("Enter input file path and name:");
        String inFile = inScanner.next();
        System.out.println("You entered: " + inFile);
        try {
            File file =  new File(inFile);
            parkingLotService.readCommandFile(file);
        } catch (IOException ex) {
            System.out.println("Error reading file due to " + ex);
        }

    }

}
