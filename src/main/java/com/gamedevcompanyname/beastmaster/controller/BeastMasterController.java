package com.gamedevcompanyname.beastmaster.controller;

import com.gamedevcompanyname.beastmaster.game.GameState;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BeastMasterController {

    private final GameState state = new GameState("new story", "new loc", "help");

    @GetMapping("action")
    public GameState action() {
        return state;
    }
}
