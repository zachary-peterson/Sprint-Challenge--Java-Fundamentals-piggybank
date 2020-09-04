package com.piggybank.com.coins.controllers;

import com.piggybank.com.coins.models.Coins;
import com.piggybank.com.coins.repositories.CoinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinsController
{
    @Autowired
    private CoinsRepository coinsrepos;

    // http://localhost:2019/names/all

    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCoins()
    {
        List<Coins> myList = new ArrayList<>();
        coinsrepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        for (Coins c : myList)
        {
            System.out.println(c);
        }
        return new ResponseEntity<>( myList, HttpStatus.OK);
    }

    // http://localhost:2019/total

    /*
    1 Quarter
    1 Dime
    5 Dollars
    3 Nickels
    7 Dimes
    1 Dollar
    10 Pennies
    The piggy bank holds 7.3
    */

    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> piggyBankDisplay()
    {
        ArrayList<Coins> myList = new ArrayList<>();
        coinsrepos.findAll().iterator().forEachRemaining(myList::add);

        double total = 0.0;

        for (Coins c : myList)
        {
            System.out.println(c);
            total = total + c.getTotalValue();
        }
        System.out.println("The Piggy Bank Holds " + total);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
