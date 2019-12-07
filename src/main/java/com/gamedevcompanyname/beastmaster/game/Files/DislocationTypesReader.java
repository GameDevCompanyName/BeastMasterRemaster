package com.gamedevcompanyname.beastmaster.game.Files;

import com.gamedevcompanyname.beastmaster.game.Elements.Dislocation;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DislocationTypesReader {

    public static List<Dislocation.DislocationType> readLocations(){

        File fileOfLocations = null;
        try {
            fileOfLocations = new ClassPathResource("gamedata/Locations.txt").getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final List<Dislocation.DislocationType> listOfLocations = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileOfLocations));
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null){
                final String[] parameters = line.split("\\|");
                final int dangerLvl = Integer.parseInt(parameters[0]);
                final int treassureness = Integer.parseInt(parameters[1]);
                final String name = parameters[2];
                final String description = parameters[3];
                final Dislocation.DislocationType disType = new Dislocation.DislocationType(name, description, dangerLvl, treassureness);
                listOfLocations.add(disType);
                line = reader.readLine();
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfLocations;

    }

}
