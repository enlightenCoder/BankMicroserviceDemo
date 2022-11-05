package com.christnet.account.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@ToString
public class Cards {


    private int cardId;

    private long customerId;

    private String cardNumber;

    private String cardType; // visa or maestro

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

    private LocalDate createdDt;


}
