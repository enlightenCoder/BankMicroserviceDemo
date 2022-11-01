package org.example.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface RentalService {

    Double calculatePrice(LocalDate from, LocalDate to, String carType);
}
