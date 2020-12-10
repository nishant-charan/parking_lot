package com.gofin.service;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ParkingLotApplicationTest {

    private final ParkingLotService parkingLotService = new ParkingLotService();

    @Test
    public void readCommandFileTest() throws IOException {
        File file =  new File("./bin/parking_lot_file_inputs.txt");
        parkingLotService.readCommandFile(file);
    }
}
