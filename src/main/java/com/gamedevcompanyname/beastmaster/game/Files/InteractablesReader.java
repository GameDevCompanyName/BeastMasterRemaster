package com.gamedevcompanyname.beastmaster.game.Files;

import com.gamedevcompanyname.beastmaster.game.Elements.Interactable;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class InteractablesReader {

    public static List<Interactable> readInteractables(){

        File fileOfInteractables = null;
        try {
            fileOfInteractables = new ClassPathResource("gamedata/Interactibles.txt").getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final List<Interactable> listOfInteractables = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileOfInteractables));
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null){
                final String[] nameAndText = line.split("\\|");
                final String name = nameAndText[0];
                final String text = nameAndText[1];
                final boolean isUniq = Boolean.parseBoolean(nameAndText[2]);
                final Interactable interactable = new Interactable(name, text, isUniq);
                listOfInteractables.add(interactable);
                line = reader.readLine();
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfInteractables;

    }
}
