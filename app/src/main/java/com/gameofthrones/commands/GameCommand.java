package com.gameofthrones.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gameofthrones.exceptions.NoFileFoundException;
import com.gameofthrones.services.IPlayingGameSerivce;

public class GameCommand implements ICommand {

    public IPlayingGameSerivce playingGameSerivce;

    public GameCommand(IPlayingGameSerivce playingGameSerivce) {
        this.playingGameSerivce = playingGameSerivce;
    }

    @Override
    public void execute(String inputFile) {
        String output = "";
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            ArrayList<String> allies = new ArrayList<String>();
            allies.add("SPACE");
            while (line != null) {
                String kingdomname = line.substring(0, line.indexOf(' '));
                String message = line.substring(line.indexOf(' ') + 1);
                String ally = playingGameSerivce.playGame(kingdomname, message);
                if (ally != null) {
                    if (!allies.contains(ally)) {
                        allies.add(ally);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
            output = "";
            if (allies.size() >= 4) {
                for (String ally : allies) {
                    output += ally + " ";
                }
            } else {
                output = "NONE";
            }
            System.out.println(output.trim());
        } catch (FileNotFoundException e) {
            System.out.println("No Such File is Found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}