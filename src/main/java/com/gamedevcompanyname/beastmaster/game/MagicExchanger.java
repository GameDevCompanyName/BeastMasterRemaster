package com.gamedevcompanyname.beastmaster.game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MagicExchanger implements MagicExchangerInterface {

    final InteractiveConsole console;
    private StringBuilder lastOutput = new StringBuilder();
    private Thread talking;
    private Queue<String> inputs = new ArrayDeque<>();

    public MagicExchanger() {
        this.console = new InteractiveConsole(this);
        talking = new Thread(() -> {
            while (true){
                console.conversate();
            }
        });
        talking.start();
    }

    public synchronized void action(String action) {
        inputs.clear();
        for (String str : action.split("\\s")){
            inputs.offer(str);
        }
        notifyAll();
    }

    @Override
    public synchronized String next() {
        if (!inputs.isEmpty()){
            return inputs.poll();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return inputs.poll();
    }

    @Override
    public void say(String wordOfGod) {
        lastOutput.append(wordOfGod);
    }

    private void clear() {
        lastOutput = new StringBuilder();
    }

    public String getOutput() {
        String result = lastOutput.toString();
        clear();
        return result.trim();
    }
}
