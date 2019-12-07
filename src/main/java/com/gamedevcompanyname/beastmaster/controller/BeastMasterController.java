package com.gamedevcompanyname.beastmaster.controller;

import com.gamedevcompanyname.beastmaster.game.GameState;
import com.gamedevcompanyname.beastmaster.game.InteractiveConsole;
import com.gamedevcompanyname.beastmaster.game.MagicExchanger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BeastMasterController {

    private MagicExchanger exchanger = new MagicExchanger();

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping(value = "/action")
    public @ResponseBody GameState action(@RequestParam String command) {
        exchanger.action(command);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new GameState(exchanger.getOutput());
    }

}
