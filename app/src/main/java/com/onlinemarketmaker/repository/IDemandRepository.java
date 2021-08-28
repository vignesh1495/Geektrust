package com.onlinemarketmaker.repository;

import java.util.List;

import com.onlinemarketmaker.entities.Demand;

public interface IDemandRepository {
    Demand getDemandById(String id);

    void saveDemand(Demand demand);

    void updateDemand(Demand demand);

    List<Demand> sortbyTime();

    List<Demand> getDemandNotPurchased();

}