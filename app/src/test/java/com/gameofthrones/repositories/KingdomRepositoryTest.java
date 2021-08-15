package com.gameofthrones.repositories;

import java.util.HashMap;
import java.util.Map;
import com.gameofthrones.entities.Kingdom;
import com.gameofthrones.repository.IKingdomRepository;
import com.gameofthrones.repository.KingdomRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("KingdomRepositoryTest")
public class KingdomRepositoryTest {

    private IKingdomRepository kingdomRepository;

    @BeforeEach
    void setup() {
        Map<Integer, Kingdom> kingdomMap = new HashMap<>();
        kingdomMap.put(1, new Kingdom(1, "SPACE", "Gorilla"));
        kingdomMap.put(2, new Kingdom(2, "LAND", "Panda"));
        kingdomMap.put(3, new Kingdom(3, "WATER", "Octopus"));
        kingdomRepository = new KingdomRepository(kingdomMap);
    }

    @Test
    @DisplayName("getKingdomByname method Should Return Kingdom by passing Kingdom name")
    public void getKingdomByname_GivenKingdomname_ShouldReturnKingdom(){
        //Arrange
        Kingdom expectedkingdom = new Kingdom(2, "LAND", "Panda");
        //Act
        Kingdom actualkingdom = kingdomRepository.getKingdomByname("LAND");
        //Assert
        Assertions.assertEquals(expectedkingdom,actualkingdom);
    }

    @Test
    @DisplayName("getKingdomByname method Should Return null Given Kingdom name If Kingdom not found")
    public void getKingdomByname_GivenKingdomname_ShouldReturnNull(){
        //Arrange
        String kingdomname = "SAND";
        //Act
        Kingdom actualkingdom = kingdomRepository.getKingdomByname(kingdomname);
        //Assert
        Assertions.assertNull(actualkingdom);
    }

    @Test
    @DisplayName("saveKingdom method Should Save Kingdom")
    public void saveKingdom_ShouldSaveKingdom(){
        //Arrange
        Kingdom expectedkingdom=new Kingdom(4,"ICE","Mammoth");
        //Act
        kingdomRepository.saveKingdom(expectedkingdom);

        //Assert
        Assertions.assertEquals(expectedkingdom,kingdomRepository.getKingdomByname("ICE"));
    }

    @Test
    @DisplayName("updateCinema method Should Update Cinema")
    public void updateKingdom_ShouldUpdateKingdom(){
        //Arrange
        Kingdom expectedkingdom=new Kingdom(4,"ICE","MAMOTH");
        //Act
        kingdomRepository.updateKingdom(expectedkingdom);

        //Assert
        Assertions.assertEquals(expectedkingdom,kingdomRepository.getKingdomByname("ICE"));
    }



    



    
}