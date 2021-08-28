package com.onlinemarketmaker.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.onlinemarketmaker.exceptions.NoFileFoundException;
import com.onlinemarketmaker.services.DemandSupplySerivce;
import com.onlinemarketmaker.services.IDemandSupplySerivce;

public class TradingCommand implements ICommand {

    public IDemandSupplySerivce demandSupplySerivce;

    public TradingCommand(IDemandSupplySerivce demandSupplySerivce) {
        this.demandSupplySerivce = demandSupplySerivce;
    }

    @Override
    public void execute() {
        demandSupplySerivce.execute();
    }
}