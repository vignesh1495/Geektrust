package com.gameofthrones.repository;
import com.gameofthrones.entities.Kingdom;


public interface IKingdomRepository {
    Kingdom getKingdomById(Integer id);
    void saveKingdom(Kingdom kingdom);
    void updateKingdom(Kingdom kingdom);
    Kingdom getKingdomByname(String name);
   
}