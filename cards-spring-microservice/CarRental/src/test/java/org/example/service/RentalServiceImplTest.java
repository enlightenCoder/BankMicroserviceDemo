package org.example.service;

import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RentalServiceImplTest extends TestCase {
    RentalService rs = new RentalServiceImpl();

    @Test
    void checkRentalTest(){
        assertEquals(15.0, rs.calculatePrice(LocalDate.now(), LocalDate.now(), "small"));
    }

}