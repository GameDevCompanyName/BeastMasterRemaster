package com.gamedevcompanyname.beastmaster.game.Files;

import com.gamedevcompanyname.beastmaster.game.Elements.Interactable;
import java.util.ArrayList;
import java.util.List;

public final class InteractablesReader {

    private static String lines = "*****NAME|TEXT_ON_INTERACTION*****\n" +
            "Камень с рунами|Поистине древний объект. " +
            "Письменности на его поверхности, кажется, " +
            "больше лет, чем самым древним тварям, " +
            "встреченным вами. Кто знает, может быть он " +
            "стоял здесь с самого Начала.|false\n" +
            "Спящий голем|Лучше не трогать этого парня. " +
            "Кажется, он спит здесь не первое столетие. " +
            "Вряд ли он будет сильно рад пробуждению.|false";

    public static List<Interactable> readInteractables() {

        final List<Interactable> listOfInteractables = new ArrayList<>();

        String[] splited = lines.split("\n");

        for (int i = 1; i < splited.length; i++) {
            final String line = splited[i];
            final String[] nameAndText = line.split("\\|");
            final String name = nameAndText[0];
            final String text = nameAndText[1];
            final boolean isUniq = Boolean.parseBoolean(nameAndText[2]);
            final Interactable interactable = new Interactable(name, text, isUniq);
            listOfInteractables.add(interactable);
        }

        return listOfInteractables;

    }
}
