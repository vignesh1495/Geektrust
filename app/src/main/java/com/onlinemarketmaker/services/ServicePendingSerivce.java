package com.onlinemarketmaker.services;

import java.util.List;

import com.onlinemarketmaker.entities.Supply;
import com.onlinemarketmaker.repository.ISupplyRepository;

public class ServicePendingSerivce implements IServicePendingSerivce {

  private ISupplyRepository supplyRepository;

  public ServicePendingSerivce(ISupplyRepository supplyRepository) {
    this.supplyRepository = supplyRepository;
  }

  @Override
  public void execute() {
    List<Supply> supplyList = supplyRepository.getSupplyNotSold();
    if (supplyList.size() == 0) {
      System.out.println("All supplies are sold out");
    }
    for (Supply supply : supplyList) {
      System.out.println(supply);
    }

  }

}
