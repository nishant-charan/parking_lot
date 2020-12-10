package com.gofin;


import com.gofin.model.ParkingLot;
import com.gofin.service.ParkingLotService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotServiceTest {

    private ParkingLotService parkingLotService = new ParkingLotService();

    @Test
    @DisplayName("Test to check create parking lot space logic")
    public void createParkingLotSpaceTest() {
        Integer parkingCount = 5;
        List<ParkingLot> parkingLotList = parkingLotService.createParkingLotSpace(parkingCount);
        assertEquals(parkingCount, parkingLotList.size(), "Size does not match");
    }
}
