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
import com.onlinemarketmaker.entities.Supply;
import com.onlinemarketmaker.repository.ISupplyRepository;

public class SupplyData implements IData {

    private final ISupplyRepository isupplyRepository;

    public SupplyData(ISupplyRepository isupplyRepository) {
        this.isupplyRepository = isupplyRepository;
    }

    public static LocalTime localtimeConvertor(String time) {
        String pattern = "HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalTime localTime = LocalTime.from(formatter.parse(time));
        return localTime;
    }

    private void addSupply(String id, String time, String vegetable, String pricePerkg, String qtyAvailable) {

        Supply supply = new Supply(id, localtimeConvertor(time), vegetable, Integer.parseInt(pricePerkg),
                Integer.parseInt(qtyAvailable));
        this.isupplyRepository.saveSupply(supply);
    }

    @Override
    public void loadData(String dataPath, String delimiter) {
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader(dataPath));

            String line = reader.readLine();
            while (line != null) {

                List<String> tokens = Arrays.asList(line.split(delimiter));
                if (tokens.get(0).startsWith("s")) {
                    addSupply(tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3).split("/")[0],
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