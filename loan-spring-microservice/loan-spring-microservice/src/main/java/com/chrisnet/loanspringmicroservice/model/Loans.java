package com.chrisnet.loanspringmicroservice.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@ToString
public class Loans {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "loan_number")
    private int loanNumber;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "start_dt")
    private LocalDate startDt;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "total_loan")
    private int totalLoan;

    @Column(name = "amount_paid")
    private int amountPaid;

    @Column(name = "outstandingAmount")
    private int outstandingAmount;

    @Column(name = "created_dt")
    private LocalDate createdDt;
}
