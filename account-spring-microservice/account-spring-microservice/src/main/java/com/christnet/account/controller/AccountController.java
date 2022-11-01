package com.christnet.account.controller;


import com.christnet.account.config.AccountServiceConfig;
import com.christnet.account.model.Accounts;
import com.christnet.account.model.Customer;
import com.christnet.account.model.Properties;
import com.christnet.account.repository.AccountsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;



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


    @GetMapping(value = "accounts/properties")
    public String getAccountPropertiesDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties props = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(), accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(props);
        return jsonStr;
    }




}
