package com.bank.springAngular.service;

import com.bank.springAngular.model.Account;
import com.bank.springAngular.model.Card;
import com.bank.springAngular.repository.AccountRepository;
import com.bank.springAngular.repository.CardRepository;
import com.bank.springAngular.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AccountRepository accountRepository;


    public Card save(Card card, int id){
        Account account = accountRepository.findById(id).get();
        card.setAccount(account);
        card.setCardNumber(generateCardNumber());
        return cardRepository.save(card);
    }
//    public List<Card> showCard(int accountID){
//        return cardRepository.finByAccountId(accountID);
//    }
    public Integer generateCardNumber(){
        String uuid = UUID.randomUUID().toString().replaceAll("[^0-9]", ""); // Supprime tous les caractères non numériques
        return Integer.valueOf(uuid.substring(0, Math.min(uuid.length(), 10)));
    }
}
