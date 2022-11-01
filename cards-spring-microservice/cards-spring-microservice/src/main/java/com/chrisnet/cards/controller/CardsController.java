package com.chrisnet.cards.controller;

import com.chrisnet.cards.config.CardServiceConfig;
import com.chrisnet.cards.model.Cards;
import com.chrisnet.cards.model.Customer;
import com.chrisnet.cards.model.Properties;
import com.chrisnet.cards.repository.CardsRepository;
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
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;
    @Autowired
    private CardServiceConfig cardConfig;

    @PostMapping("/myCards")
    public List<Cards> getCardsDetails(@RequestBody Customer customer) {

        List<Cards> cardsList = cardsRepository.findByCustomerId(customer.getCustomerId());
        if(cardsList != null) {
            return cardsList;
        }else {
            return null;
        }
    }

    @GetMapping("/card/properties")
    public String cardDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardConfig.getMsg(), cardConfig.getBuildVersion(), cardConfig.getMailDetails(), cardConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }

}
