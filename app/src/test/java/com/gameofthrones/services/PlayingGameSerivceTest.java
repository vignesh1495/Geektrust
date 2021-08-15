package com.gameofthrones.services;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.gameofthrones.entities.Kingdom;
import com.gameofthrones.repository.KingdomRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("PlayingGameServiceTest")
@ExtendWith(MockitoExtension.class)
public class PlayingGameSerivceTest {
    @Mock
    KingdomRepository kingdomRepositoryMock;

    @InjectMocks
    PlayingGameSerivce playingGameSerivce;


    @Test
    @DisplayName("playGame method Should Return kingomName")
    public void playGame_ShouldReturnkingomName(){
        //Arrange
        String kingdomNameMock ="LAND";
        String messageMock = "FDIXXSOKKOFBBMU";
        String kingdomEmblemMock = "Panda"; 

        String expectedKingdomname = "LAND";

        when(kingdomRepositoryMock.getKingdomByname(kingdomNameMock))
        .thenReturn(new Kingdom(2,kingdomNameMock, kingdomEmblemMock));

        //Act
        String actualKingdomname = playingGameSerivce.playGame(kingdomNameMock, messageMock);

        //Assert
        Assertions.assertEquals(expectedKingdomname,actualKingdomname);

        verify(kingdomRepositoryMock).getKingdomByname(kingdomNameMock);

    }


    @Test
    @DisplayName("playGame method Should Return Null")
    public void playGame_ShouldReturnNull(){
        //Arrange
        String kingdomNameMock ="WATER";
        String messageMock = "SUMMER IS COMING";
        String kingdomEmblemMock = "Octopus"; 

        String expectedKingdomname = "WATER";

        when(kingdomRepositoryMock.getKingdomByname(kingdomNameMock))
        .thenReturn(new Kingdom(2,kingdomNameMock, kingdomEmblemMock));

        //Act
        String actualKingdomname = playingGameSerivce.playGame(kingdomNameMock, messageMock);

        //Assert
        Assertions.assertNull(actualKingdomname);

        verify(kingdomRepositoryMock).getKingdomByname(kingdomNameMock);

    }


    
}