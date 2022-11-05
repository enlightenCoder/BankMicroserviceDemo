package com.christnet.account.service.client;

import com.christnet.account.model.Cards;
import com.christnet.account.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("card")
public interface CardsFeignClient {

    @PostMapping("/myCards")
    public List<Cards> getCardsDetails(@RequestBody Customer customer);
}
