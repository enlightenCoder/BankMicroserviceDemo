package com.christnet.account.response;

import com.christnet.account.model.Accounts;
import com.christnet.account.model.Cards;
import com.christnet.account.model.Loans;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CustomerDetails {

    private Accounts account;

    private List<Loans> loan;

    private List<Cards> card;

}
