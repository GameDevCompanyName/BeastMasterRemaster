package com.gamedevcompanyname.beastmaster.game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class GameState {

    @Getter
    private final String story;

    @Getter
    private final String location;

    @Getter
    private final String help;
}
