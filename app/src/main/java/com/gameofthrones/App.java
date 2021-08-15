package com.gameofthrones;

import java.io.BufferedReader;
import com.gameofthrones.commands.CommandInvoker;
import com.gameofthrones.config.ApplicationConfig;
import com.gameofthrones.exceptions.NoSuchCommandException;
import com.gameofthrones.exceptions.NoSuchDataException;
import com.gameofthrones.repository.data.IData;

public class App {

    public void run(String inputFile) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        IData dataLoader = applicationConfig.getDataLoader();
        dataLoader.loadData();
        CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();

        try {
            commandInvoker.executeCommand("GAME-PLAY", inputFile);
        } catch (NoSuchCommandException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new App().run(args[0]);

        // new App().run(args[0]);
    }
}
