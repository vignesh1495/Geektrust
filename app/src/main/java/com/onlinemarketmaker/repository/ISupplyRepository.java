package com.onlinemarketmaker.repository;

import java.util.List;

import com.onlinemarketmaker.entities.Supply;

public interface ISupplyRepository {

  Supply getSupplyById(String id);

  void saveSupply(Supply supply);

  void updateSupply(Supply supply);

  List<Supply> sortbyTime();

  List<Supply> getSupplyNotSold();

}
