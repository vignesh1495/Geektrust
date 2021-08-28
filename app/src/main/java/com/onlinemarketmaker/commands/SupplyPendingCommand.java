package com.onlinemarketmaker.commands;

import com.onlinemarketmaker.services.IServicePendingSerivce;

public class SupplyPendingCommand implements ICommand {

  public IServicePendingSerivce iServicePendingSerivce;

  public SupplyPendingCommand(IServicePendingSerivce iServicePendingSerivce) {
    this.iServicePendingSerivce = iServicePendingSerivce;
  }

  @Override
  public void execute() {
    iServicePendingSerivce.execute();

  }

}
