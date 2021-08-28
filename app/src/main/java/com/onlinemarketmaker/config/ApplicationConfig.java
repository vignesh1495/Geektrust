package com.onlinemarketmaker.config;

import com.onlinemarketmaker.commands.CommandInvoker;
import com.onlinemarketmaker.commands.DemandPendingCommand;
import com.onlinemarketmaker.commands.SupplyPendingCommand;
import com.onlinemarketmaker.commands.TradingCommand;
import com.onlinemarketmaker.repository.DemandRepository;
import com.onlinemarketmaker.repository.IDemandRepository;
import com.onlinemarketmaker.repository.ISupplyRepository;
import com.onlinemarketmaker.repository.SupplyRepository;
import com.onlinemarketmaker.repository.data.DataLoader;
import com.onlinemarketmaker.repository.data.DemandData;
import com.onlinemarketmaker.repository.data.IData;
import com.onlinemarketmaker.repository.data.SupplyData;
import com.onlinemarketmaker.services.DemandPendingSerivce;
import com.onlinemarketmaker.services.DemandSupplySerivce;
import com.onlinemarketmaker.services.IDemandPendingSerivce;
import com.onlinemarketmaker.services.IDemandSupplySerivce;
import com.onlinemarketmaker.services.IServicePendingSerivce;
import com.onlinemarketmaker.services.ServicePendingSerivce;

public class ApplicationConfig {

    private final IDemandRepository iDemandRepository = new DemandRepository();
    private final ISupplyRepository iSupplyRepository = new SupplyRepository();
    private final CommandInvoker commandInvoker = new CommandInvoker();
    private final DataLoader dataLoader = new DataLoader();
    private final IDemandSupplySerivce demandSupplyService = new DemandSupplySerivce(iDemandRepository,
            iSupplyRepository);
    private final IDemandPendingSerivce demandPendingService = new DemandPendingSerivce(iDemandRepository);
    private final IServicePendingSerivce servicePendingService = new ServicePendingSerivce(iSupplyRepository);

    public CommandInvoker getCommandInvoker() {
        commandInvoker.register("DEMAND-SUPPLY-TRADING", new TradingCommand(demandSupplyService));
        commandInvoker.register("DEMAND-PENDING", new DemandPendingCommand(demandPendingService));
        commandInvoker.register("SUPPLY-PENDING", new SupplyPendingCommand(servicePendingService));
        return commandInvoker;
    }

    public DataLoader getDataLoader() {
        dataLoader.register("DEMAND-DATA", new DemandData(iDemandRepository));
        dataLoader.register("SUPPLY-DATA", new SupplyData(iSupplyRepository));
        return dataLoader;
    }

}
