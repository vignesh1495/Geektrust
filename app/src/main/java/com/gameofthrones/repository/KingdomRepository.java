package com.gameofthrones.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.gameofthrones.entities.Kingdom;


public class KingdomRepository implements IKingdomRepository {
    private final Map<Integer, Kingdom> kingdomMap;

    public KingdomRepository() {
        kingdomMap = new HashMap<>();
    }

    public KingdomRepository(Map<Integer, Kingdom> KingdomMap) {
        this.kingdomMap = KingdomMap;
    }

   
    @Override
    public Kingdom getKingdomById(Integer id) {
        return kingdomMap.get(id);
    }

    @Override
    public void saveKingdom(Kingdom kingdom) {
         kingdomMap.put(kingdom.getid(),kingdom);
        

    }

    @Override
    public void updateKingdom(Kingdom kingdom) {
        kingdomMap.put(kingdom.getid(),kingdom);

    }

    @Override
    public Kingdom getKingdomByname(String name) {
        for (Kingdom kingdom : kingdomMap.values()) {
            if (kingdom.getName().equalsIgnoreCase(name)) {
                return kingdom;
            }
        }
        return null;
    }


    
}