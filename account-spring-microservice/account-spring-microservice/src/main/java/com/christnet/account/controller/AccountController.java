package com.christnet.account.controller;


import com.christnet.account.config.AccountServiceConfig;
import com.christnet.account.model.*;
import com.christnet.account.repository.AccountsRepository;
import com.christnet.account.response.CustomerDetails;
import com.christnet.account.service.client.CardsFeignClient;
import com.christnet.account.service.client.LoanFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.netflix.discovery.converters.Auto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private LoanFeignClient loanFeignClient;

    @Autowired
    private CardsFeignClient cardsFeignClient;

    @Autowired
    private AccountServiceConfig accountsConfig;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        System.out.println(customer.getCustomerId());
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        if(accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }


    @PostMapping("/myCustomerDetails")
    //@CircuitBreaker(name = "detailsForCustomerSupportApp", fallbackMethod = "myCustomerDetailsFallback")
    @Retry(name = "retryForCustomerDetails", fallbackMethod = "myCustomerDetailsFallback")
    public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId());
        List<Loans> loans = loanFeignClient.getLoansDetails(customer);
        List<Cards> cards = cardsFeignClient.getCardsDetails(customer);

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccount(account);
        customerDetails.setLoan(loans);
        customerDetails.setCard(cards);

        return customerDetails;
    }

    private CustomerDetails myCustomerDetailsFallback(Customer customer, Throwable t) {
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId());
        List<Loans> loans = loanFeignClient.getLoansDetails(customer);

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccount(account);
        customerDetails.setLoan(loans);

        return customerDetails;
    }


    @GetMapping(value = "accounts/properties")
    public String getAccountPropertiesDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties props = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(), accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(props);
        return jsonStr;
    }




}
