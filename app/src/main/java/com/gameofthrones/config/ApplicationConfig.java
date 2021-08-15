package com.gameofthrones.config;

import com.gameofthrones.commands.CommandInvoker;
import com.gameofthrones.commands.GameCommand;
import com.gameofthrones.repository.IKingdomRepository;
import com.gameofthrones.repository.KingdomRepository;
import com.gameofthrones.repository.data.IData;
import com.gameofthrones.repository.data.KingdomData;
import com.gameofthrones.services.IPlayingGameSerivce;
import com.gameofthrones.services.PlayingGameSerivce;


public class ApplicationConfig {

    private final IKingdomRepository ikingdomRepository = new KingdomRepository();
    private final IPlayingGameSerivce igameService = new PlayingGameSerivce(ikingdomRepository);
    private final GameCommand gameCommand = new GameCommand(igameService);
    private final IData kingdomData = new KingdomData(ikingdomRepository);
    private final CommandInvoker commandInvoker = new CommandInvoker();

    
    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("GAME-PLAY",gameCommand);
        return commandInvoker;
    }
    

    public IData getDataLoader(){
        return kingdomData;
    }    
 
}
