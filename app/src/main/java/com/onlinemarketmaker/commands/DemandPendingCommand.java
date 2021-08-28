package com.onlinemarketmaker.commands;

import com.onlinemarketmaker.services.IDemandPendingSerivce;

public class DemandPendingCommand implements ICommand {

  public IDemandPendingSerivce iDemandPendingSerivce;

  public DemandPendingCommand(IDemandPendingSerivce iDemandPendingSerivce) {
    this.iDemandPendingSerivce = iDemandPendingSerivce;
  }

  @Override
  public void execute() {
    iDemandPendingSerivce.execute();
  }

}
