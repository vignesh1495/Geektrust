package com.gameofthrones.repository.data;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.gameofthrones.entities.Kingdom;
import com.gameofthrones.repository.IKingdomRepository;




public class KingdomData implements IData {

    private final IKingdomRepository ikingdomRepository;

    public KingdomData(IKingdomRepository ikingdomRepository) {
        this.ikingdomRepository = ikingdomRepository;
    }


    private void addKingdom(String id, String name,String emblem){
        Kingdom king =  new Kingdom(Integer.parseInt(id),name,emblem);
       this.ikingdomRepository.saveKingdom(king);
}

    @Override
    public void loadData() {
        addKingdom("1", "SPACE", "Gorilla");
        addKingdom("2", "LAND", "Panda");
        addKingdom("3", "WATER", "Octopus");
        addKingdom("4", "ICE", "Mammoth");
        addKingdom("5", "AIR", "Owl");
        addKingdom("6", "FIRE", "Dragon");
    }

      
}