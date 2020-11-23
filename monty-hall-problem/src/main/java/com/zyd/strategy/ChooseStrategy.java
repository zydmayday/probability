package com.zyd.strategy;

import java.util.List;
import java.util.Random;

public interface ChooseStrategy {

    Random random = new Random();

    default int choose(List<Integer> doorsIndex) {
        return random.nextInt(doorsIndex.size());
    }

    boolean isChangeChoice();
}
