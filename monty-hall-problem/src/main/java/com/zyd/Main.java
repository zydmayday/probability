package com.zyd;

import com.zyd.strategy.ChangeStrategy;
import com.zyd.strategy.ChooseStrategy;
import com.zyd.strategy.NotChangeStrategy;

/**
 * 蒙提霍尔问题
 */
public class Main {

    public static void main(String[] args) {
        int count = 3000;
        int correct = 0;
        for (int i = 0; i < count; i++) {
            if (play(new NotChangeStrategy())) {
                correct++;
            }
        }
        System.out.println(String.format("不改变选择，正确率: %d / %d = %.2f%%", correct, count, correct * 1.0 / count));

        correct = 0;
        for (int i = 0; i < count; i++) {
            if (play(new ChangeStrategy())) {
                correct++;
            }
        }
        System.out.println(String.format("改变选择，正确率: %d / %d = %.2f%%", correct, count, correct * 1.0 / count));
    }

    private static boolean play(ChooseStrategy strategy) {
        Player player = new Player(strategy);
        Host host = new Host();
        Stage stage = new Stage();

        // 玩家第一次选择
        player.chooseFrom(stage);
//        System.out.println(stage);

        // 主持人打开不中奖的一扇门
        host.openDoorFrom(stage);
//        System.out.println(stage);

        // 玩家再次选择
        player.chooseAgainFrom(stage);
//        System.out.println(stage);

        return stage.isCorrect();
    }
}
