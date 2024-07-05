package com.bank.springAngular.service;

import com.bank.springAngular.model.Card;
import com.bank.springAngular.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;


    public Card save(Card card){
        return cardRepository.save(card);
    }
}
