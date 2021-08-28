package com.onlinemarketmaker.repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.onlinemarketmaker.entities.Supply;

public class SupplyRepository implements ISupplyRepository {
  private final Map<String, Supply> supplyMap;

  public SupplyRepository() {
    supplyMap = new HashMap<>();
  }

  public SupplyRepository(Map<String, Supply> supplyMap) {
    this.supplyMap = supplyMap;
  }

  @Override
  public Supply getSupplyById(String id) {
    // TODO Auto-generated method stub
    return supplyMap.get(id);
  }

  @Override
  public void saveSupply(Supply supply) {
    supplyMap.put(supply.getId(), supply);

  }

  @Override
  public void updateSupply(Supply supply) {
    supplyMap.put(supply.getId(), supply);

  }

  @Override
  public List<Supply> sortbyTime() {
    return supplyMap.values().stream().sorted(Comparator.comparing(Supply::getTime).thenComparing(Supply::getId))
        .collect(Collectors.toList());
  }

  @Override
  public List<Supply> getSupplyNotSold() {
    return supplyMap.values().stream().filter(c -> c.getQtyAvailable() > 0).collect(Collectors.toList());
  }

}
