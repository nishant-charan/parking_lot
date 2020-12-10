package com.gofin.service;

import com.gofin.model.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {

    public List<ParkingLot> createParkingLotSpace(Integer limit) {
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
        for(int index=1; index<=limit; index++) {
            ParkingLot parkingLot = new ParkingLot(index);
            parkingLotList.add(parkingLot);
        }
        return parkingLotList;
    }

    public void getParkingLotStatus(List<ParkingLot> parkingLotList) {
        System.out.println("Slot No. \t Registration No.");
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getParkingTicket() != null) {
                System.out.println(parkingLot.getParkingId() + " \t " + parkingLot.getParkingTicket().getVehicleNumber());
            }
        }
    }

}
