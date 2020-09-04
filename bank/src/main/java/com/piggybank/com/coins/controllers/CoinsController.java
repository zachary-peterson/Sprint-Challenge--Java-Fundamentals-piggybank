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
}
