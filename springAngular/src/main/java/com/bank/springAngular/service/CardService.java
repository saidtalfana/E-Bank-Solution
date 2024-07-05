package com.bank.springAngular.service;

import com.bank.springAngular.model.Account;
import com.bank.springAngular.model.Card;
import com.bank.springAngular.repository.AccountRepository;
import com.bank.springAngular.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Card save(Card card,int id){
        Account account = accountRepository.findById(id).get();
        card.setAccount(account);
        return cardRepository.save(card);
    }
    public List<Card> showCard(){
        return cardRepository.findAll();
    }
    public Card updateCard(Card card){
        return cardRepository.save(card);
    }
}
