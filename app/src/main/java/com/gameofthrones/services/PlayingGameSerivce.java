package com.gameofthrones.services;

import com.gameofthrones.entities.Kingdom;
import com.gameofthrones.repository.IKingdomRepository;


public class PlayingGameSerivce implements IPlayingGameSerivce {

    private IKingdomRepository kingdomRepository;

    public PlayingGameSerivce(IKingdomRepository kingdomRepository) {
        this.kingdomRepository=kingdomRepository;
    }

    @Override
    public String playGame(String kingdomname,String message) {
        String emblem=kingdomRepository.getKingdomByname(kingdomname).getEmblem().toUpperCase();
        message = message.toUpperCase();
        int size = emblem.length();
        int []  array= new int[26];
		for (int i=0;i<emblem.length();i++) {
            char character = emblem.charAt(i);
            if (character>='A' && character<='Z') {
                array[character-'A']+=1;
            }
			
        }
      
        for (int i=0;i<message.length();i++) {
            if (message.charAt(i)>='A' && message.charAt(i)<='Z') {
                char character=(char)(message.charAt(i)-size); 
                    if (character<'A') {                
                        character=(char)(character-'A'+'Z'+1);
                    }
                    if (emblem.contains(String.valueOf(character))) {
                        array[character-'A']-=1;
                    }	
                    
            }   
        } 
        for (int i:array) {
            if(i>0){
            return null;
            }
        }
        return kingdomname;
}
    
}