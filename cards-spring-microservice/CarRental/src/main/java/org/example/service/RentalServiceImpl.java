package org.example.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class RentalServiceImpl implements RentalService {


    public Double calculatePrice(LocalDate from, LocalDate to, String carType) {
        //long duration = Duration.between(from, to).toDays() + 1L;
        long duration = (ChronoUnit.DAYS.between(from, to)) + 1L;
        Double durationPrice = null;
        System.out.println( "==> : " + duration);
        if(carType.equalsIgnoreCase("compact")) {
            double compactPricePerDay = 20.0;
            durationPrice = compactPricePerDay * duration;
        }else if(carType.equalsIgnoreCase("small")){
            double smallPricePerDay = 15.0;
            durationPrice = smallPricePerDay * duration;
            System.out.println("Cost for small " + durationPrice);
        }else {
            throw new IllegalArgumentException("Value not good");
        }

        return durationPrice;
    }
}
