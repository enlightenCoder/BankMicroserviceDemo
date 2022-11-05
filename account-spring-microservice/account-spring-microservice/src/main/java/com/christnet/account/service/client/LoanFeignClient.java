package com.christnet.account.service.client;


import com.christnet.account.model.Customer;
import com.christnet.account.model.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("loan")
public interface LoanFeignClient {

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer);
}
