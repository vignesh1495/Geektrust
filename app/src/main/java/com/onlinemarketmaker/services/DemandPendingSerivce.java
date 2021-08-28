package com.onlinemarketmaker.services;

import java.util.List;

import com.onlinemarketmaker.entities.Demand;
import com.onlinemarketmaker.repository.IDemandRepository;

public class DemandPendingSerivce implements IDemandPendingSerivce {

  private IDemandRepository demandRepository;

  public DemandPendingSerivce(IDemandRepository demandRepository) {
    this.demandRepository = demandRepository;
  }

  @Override
  public void execute() {
    List<Demand> demandlist = demandRepository.getDemandNotPurchased();
    if (demandlist.size() == 0) {
      System.out.println("No Demand are pending");
    }
    for (Demand demand : demandlist) {
      System.out.println(demand);
    }

  }

}
