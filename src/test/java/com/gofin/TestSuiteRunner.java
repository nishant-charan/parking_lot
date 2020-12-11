package com.gofin;

import com.gofin.service.ParkingLotService;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.logging.Logger;

public class TestSuiteRunner {

    private static Logger logger = Logger.getLogger(ParkingLotService.class.getName());

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ParkingLotTestSuite.class);

        for (Failure failure : result.getFailures()) {
            logger.warning(failure.toString());
            failure.getException().printStackTrace();
        }
        logger.info("Test successful? " + result.wasSuccessful());
    }

}
