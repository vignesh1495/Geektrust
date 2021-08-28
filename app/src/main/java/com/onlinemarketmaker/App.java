package com.onlinemarketmaker;

import java.io.BufferedReader;

import com.onlinemarketmaker.commands.CommandInvoker;
import com.onlinemarketmaker.config.ApplicationConfig;
import com.onlinemarketmaker.exceptions.NoSuchCommandException;
import com.onlinemarketmaker.exceptions.NoSuchDataException;
import com.onlinemarketmaker.repository.data.DataLoader;
import com.onlinemarketmaker.repository.data.IData;

public class App {

    public void run(String inputFile) {
        try {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            DataLoader dataLoader = applicationConfig.getDataLoader();

            dataLoader.executeData("DEMAND-DATA", inputFile);
            dataLoader.executeData("SUPPLY-DATA", inputFile);
            CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
            commandInvoker.executeCommand("DEMAND-SUPPLY-TRADING");
            commandInvoker.executeCommand("DEMAND-PENDING");
            commandInvoker.executeCommand("SUPPLY-PENDING");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // String path = args[0];
        String path = "C:\\Users\\DELL\\eclipse-workspace\\SeleniumFramework\\Clover\\app\\src\\main\\resource\\input.txt";
        new App().run(path);

    }
}
