package com.onlinemarketmaker.repository.data;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.onlinemarketmaker.entities.Demand;
import com.onlinemarketmaker.repository.IDemandRepository;

public class DemandData implements IData {

    private final IDemandRepository idemandRepository;

    public DemandData(IDemandRepository idemandRepository) {
        this.idemandRepository = idemandRepository;
    }

    public static LocalTime localtimeConvertor(String time) {
        String pattern = "HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalTime localTime = LocalTime.from(formatter.parse(time));
        return localTime;
    }

    private void adddemand(String id, String time, String vegetable, String pricePerkg, String qtyAvailable) {

        Demand demand = new Demand(id, localtimeConvertor(time), vegetable, Integer.parseInt(pricePerkg),
                Integer.parseInt(qtyAvailable));
        this.idemandRepository.saveDemand(demand);
    }

    @Override
    public void loadData(String dataPath, String delimiter) {
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader(dataPath));

            String line = reader.readLine();
            while (line != null) {

                List<String> tokens = Arrays.asList(line.split(delimiter));
                if (tokens.get(0).startsWith("d")) {
                    adddemand(tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3).split("/")[0],
                            tokens.get(4).split("k")[0]);
                }

                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}