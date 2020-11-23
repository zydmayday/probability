package com.zyd;

import com.zyd.strategy.ChooseStrategy;

import java.util.List;

public class Player {

    ChooseStrategy strategy;

    public Player(ChooseStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 第一次选择方案
     * @param stage
     */
    public void chooseFrom(Stage stage) {
        List<Integer> doorsIndex = stage.getNotOpenedDoorsIndex();
        stage.chooseDoor(strategy.choose(doorsIndex));
    }

    public void chooseAgainFrom(Stage stage) {
        List<Integer> doorsIndex = stage.getNotOpenedDoorsIndex();
        if (strategy.isChangeChoice()) {
            stage.changeChoose(doorsIndex);
        }
    }
}
