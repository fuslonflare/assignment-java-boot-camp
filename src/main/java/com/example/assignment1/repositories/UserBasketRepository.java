package com.example.assignment1.repositories;

import com.example.assignment1.database.UserBasket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBasketRepository extends JpaRepository<UserBasket, Long> {

    List<UserBasket> findByUserId(long userId);

}
