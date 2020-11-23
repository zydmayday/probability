package com.zyd.strategy;

import java.util.List;

public class ChangeStrategy implements ChooseStrategy {

    private int choice;

    @Override
    public int choose(List<Integer> doorsIndex) {
        this.choice = ChooseStrategy.super.choose(doorsIndex);
        return choice;
    }

    @Override
    public boolean isChangeChoice() {
        return true;
    }
}
