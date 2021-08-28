package com.onlinemarketmaker.repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.onlinemarketmaker.entities.Demand;

public class DemandRepository implements IDemandRepository {
    private final Map<String, Demand> demandMap;

    public DemandRepository() {
        demandMap = new HashMap<>();
    }

    public DemandRepository(Map<String, Demand> demandMap) {
        this.demandMap = demandMap;
    }

    @Override
    public Demand getDemandById(String id) {
        // TODO Auto-generated method stub
        return demandMap.get(id);
    }

    @Override
    public void saveDemand(Demand demand) {
        demandMap.put(demand.getId(), demand);

    }

    @Override
    public void updateDemand(Demand demand) {
        demandMap.put(demand.getId(), demand);

    }

    @Override
    public List<Demand> sortbyTime() {
        return demandMap.values().stream().sorted(Comparator.comparing(Demand::getTime).thenComparing(Demand::getId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Demand> getDemandNotPurchased() {
        return demandMap.values().stream().filter(c -> c.getQtyRequired() > 0).collect(Collectors.toList());

    }

}