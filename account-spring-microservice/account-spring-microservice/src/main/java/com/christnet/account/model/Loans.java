package com.christnet.account.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@ToString
public class Loans {


    private int loanNumber;


    private int customerId;


    private LocalDate startDt;


    private String loanType;


    private int totalLoan;


    private int amountPaid;


    private int outstandingAmount;


    private LocalDate createdDt;
}
