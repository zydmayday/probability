package com.zyd.strategy;

import java.util.List;

public class NotChangeStrategy implements ChooseStrategy {
    @Override
    public boolean isChangeChoice() {
        return false;
    }
}
