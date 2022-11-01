package com.chrisnet.cards.model;

import lombok.Data;
import lombok.ToString;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@ToString
public class Cards {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "card_id")
    private int cardId;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType; // visa or maestro

    @Column(name = "total_limit")
    private int totalLimit;

    @Column(name = "amount_used")
    private int amountUsed;

    @Column(name = "available_amount")
    private int availableAmount;

    @Column(name = "created_dt")
    private LocalDate createdDt;


}
