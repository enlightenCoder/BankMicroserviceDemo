package com.chrisnet.cards.repository;

import com.chrisnet.cards.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Cards, Integer> {

    List<Cards> findByCustomerId(long customerId);
}
