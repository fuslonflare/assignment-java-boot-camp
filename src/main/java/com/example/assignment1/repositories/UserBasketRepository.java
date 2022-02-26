package com.example.assignment1.repositories;

import com.example.assignment1.database.UserBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBasketRepository extends JpaRepository<UserBasket, Long> {

}
