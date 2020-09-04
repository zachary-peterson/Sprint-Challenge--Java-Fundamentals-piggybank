package com.piggybank.com.coins.repositories;

import com.piggybank.com.coins.models.Coins;
import org.springframework.data.repository.CrudRepository;

public interface CoinsRepository extends CrudRepository<Coins, Long>
{
}
