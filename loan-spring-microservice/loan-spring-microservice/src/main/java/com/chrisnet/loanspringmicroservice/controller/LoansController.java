package com.chrisnet.loanspringmicroservice.controller;

import com.chrisnet.loanspringmicroservice.config.LoanServiceConfig;
import com.chrisnet.loanspringmicroservice.model.Customer;
import com.chrisnet.loanspringmicroservice.model.Loans;
import com.chrisnet.loanspringmicroservice.model.Properties;
import com.chrisnet.loanspringmicroservice.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private LoanServiceConfig loanConfig;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer) {
        List<Loans> loansDetails = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if(loansDetails != null) {
            return loansDetails;
        }else {
            return null;
        }
    }


    @GetMapping("/loan/properties")
    public String loanDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loanConfig.getMsg(), loanConfig.getBuildVersion(), loanConfig.getMailDetails(), loanConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
