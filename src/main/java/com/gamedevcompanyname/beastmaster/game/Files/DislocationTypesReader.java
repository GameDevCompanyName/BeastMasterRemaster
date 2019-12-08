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

    private static String lines = "*****DANGER_LVL|TREASSURENESS|NAME|DECRIPTION*****\n" +
            "0|10|Эльфийский Лес|Светлое, красивое и безопасное место. Прежде здесь " +
            "жили эльфы. Возможно вы сможете найти здесь что-нибудь полезное\n" +
            "1|20|Скорпионья Пустошь|Несмотря на отсутствие углов, опасность поджидает " +
            "вас буквально повсюду. Однако, проходившие мимо караваны могли оставить здесь что-нибудь ценное.\n" +
            "2|30|Пещера Огра|Это мрачное место буквально пропитано тревогой и страхом. " +
            "Вам лучше не рисковать и поскорее убраться отсюда," +
            " пока на вас не напал серьезный противник.";

    public static List<Dislocation.DislocationType> readLocations() {

        final List<Dislocation.DislocationType> listOfLocations = new ArrayList<>();

        String[] splited = lines.split("\n");

        for (int i = 1; i < splited.length; i++) {
            final String line = splited[i];
            final String[] parameters = line.split("\\|");
            final int dangerLvl = Integer.parseInt(parameters[0]);
            final int treassureness = Integer.parseInt(parameters[1]);
            final String name = parameters[2];
            final String description = parameters[3];
            final Dislocation.DislocationType disType = new Dislocation.DislocationType(name, description, dangerLvl, treassureness);
            listOfLocations.add(disType);
        }

        return listOfLocations;

    }

}
