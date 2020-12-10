package com.gofin;


import com.gofin.model.ParkingLot;
import com.gofin.service.ParkingLotService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotServiceTest {

    private ParkingLotService parkingLotService = new ParkingLotService();


    @Test
    @DisplayName("Test to check create parking lot space logic")
    public void createParkingLotSpaceTest() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        Integer parkingCount = 5;
        parkingLotList = parkingLotService.createParkingLotSpace(parkingLotList, parkingCount);
        assertEquals(parkingCount, parkingLotList.size(), "Size does not match");
    }

    @Test
    @DisplayName("Test to check parking lot status")
    public void getParkingLotStatusTest() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        for (int index = 1; index <= 3; index++) {
            ParkingLot parkingLot = new ParkingLot(index);
            parkingLotList.add(parkingLot);
        }
        parkingLotList.get(0).setRegistrationNumber("MH 12 KH 1023");
        parkingLotList.get(2).setRegistrationNumber("MH 12 FN 6166");

        parkingLotService.getParkingLotStatus(parkingLotList);
    }

    @Test
    @DisplayName("Test to check park vehicle flow when parking available")
    public void parkVehicleTest1() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        for (int index = 1; index <= 3; index++) {
            ParkingLot parkingLot = new ParkingLot(index);
            parkingLotList.add(parkingLot);
        }
        parkingLotList.get(0).setRegistrationNumber("MH 12 KH 1023");

        boolean isParked = parkingLotService.parkVehicle(parkingLotList, "MH 12 FN 6166");

        assertTrue(isParked, "Vehicle is not parked");
    }

    @Test
    @DisplayName("Test to check park vehicle flow when parking not available")
    public void parkVehicleTest2() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        for (int index = 1; index <= 3; index++) {
            ParkingLot parkingLot = new ParkingLot(index);
            parkingLotList.add(parkingLot);
        }
        parkingLotList.get(0).setRegistrationNumber("MH 12 KH 1023");
        parkingLotList.get(1).setRegistrationNumber("BR 01 BV 3194");
        parkingLotList.get(2).setRegistrationNumber("MH 12 FN 6166");

        boolean isParked = parkingLotService.parkVehicle(parkingLotList, "MH 12 FQ 0123");

        assertFalse(isParked, "Vehicle is parked");
    }

    @Test
    @DisplayName("Test to check leave vehicle flow when time is less than equal to 2 hours")
    public void leaveVehicleTest1() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        for (int index = 1; index <= 3; index++) {
            ParkingLot parkingLot = new ParkingLot(index);
            parkingLotList.add(parkingLot);
        }
        parkingLotList.get(0).setRegistrationNumber("MH 12 KH 1023");
        parkingLotList.get(1).setRegistrationNumber("BR 01 BV 3194");
        parkingLotList.get(2).setRegistrationNumber("MH 12 FN 6166");

        boolean isLeft = parkingLotService.leaveVehicle(parkingLotList, "BR 01 BV 3194", 2f);

        assertTrue(isLeft, "Vehicle has not left");
    }

    @Test
    @DisplayName("Test to check leave vehicle flow when time is more than 2 hours")
    public void leaveVehicleTest2() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        for (int index = 1; index <= 3; index++) {
            ParkingLot parkingLot = new ParkingLot(index);
            parkingLotList.add(parkingLot);
        }
        parkingLotList.get(0).setRegistrationNumber("MH 12 KH 1023");
        parkingLotList.get(1).setRegistrationNumber("BR 01 BV 3194");
        parkingLotList.get(2).setRegistrationNumber("MH 12 FN 6166");

        boolean isLeft = parkingLotService.leaveVehicle(parkingLotList, "MH 12 KH 1023", 4.3f);

        assertTrue(isLeft, "Vehicle has not left");
    }

    @Test
    @DisplayName("Test to check leave vehicle flow when vehicle is not present")
    public void leaveVehicleTest3() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        for (int index = 1; index <= 3; index++) {
            ParkingLot parkingLot = new ParkingLot(index);
            parkingLotList.add(parkingLot);
        }
        parkingLotList.get(0).setRegistrationNumber("MH 12 KH 1023");
        parkingLotList.get(1).setRegistrationNumber("BR 01 BV 3194");
        parkingLotList.get(2).setRegistrationNumber("MH 12 FN 6166");

        boolean isLeft = parkingLotService.leaveVehicle(parkingLotList, "MH 12 KH 1111", 4f);

        assertFalse(isLeft, "Vehicle has not left");
    }
}
