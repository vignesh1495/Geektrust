package com.onlinemarketmaker.services;

import java.util.List;
import com.onlinemarketmaker.entities.Demand;
import com.onlinemarketmaker.entities.Supply;
import com.onlinemarketmaker.repository.IDemandRepository;
import com.onlinemarketmaker.repository.ISupplyRepository;

public class DemandSupplySerivce implements IDemandSupplySerivce {

    private IDemandRepository demandRepository;
    private ISupplyRepository supplyRepository;

    public DemandSupplySerivce(IDemandRepository demandRepository, ISupplyRepository supplyRepository) {
        this.demandRepository = demandRepository;
        this.supplyRepository = supplyRepository;
    }

    @Override
    public void execute() {
        List<Demand> sorteddemandList = demandRepository.sortbyTime();

        List<Supply> sortedsupplylist = supplyRepository.sortbyTime();

        for (Demand demand : sorteddemandList) {
            for (Supply supply : sortedsupplylist) {

                if (supply.getQtyAvailable() <= 0) {
                    continue;
                }

                if (demand.getVegetable().equalsIgnoreCase(supply.getVegetable())) {
                    if (demand.getPricePerKg() >= supply.getPricePerKg()) {
                        int trade = supply.getQtyAvailable() >= demand.getQtyRequired() ? demand.getQtyRequired()
                                : supply.getQtyAvailable();
                        int qtydemandstillneed = demand.getQtyRequired() - supply.getQtyAvailable();
                        int qtysupplystillavailable = supply.getQtyAvailable() - demand.getQtyRequired();
                        demand.setQtyAvailable(qtydemandstillneed >= 0 ? qtydemandstillneed : 0);
                        supply.setQtyAvailable(qtysupplystillavailable >= 0 ? qtysupplystillavailable : 0);
                        System.out.println(demand.getId() + " " + supply.getId() + " " + " " + ""
                                + supply.getPricePerKg() + "/kg " + trade + "kg");
                    }
                }

                if (demand.getQtyRequired() == 0) {
                    break;
                }
            }
        }
    }
}