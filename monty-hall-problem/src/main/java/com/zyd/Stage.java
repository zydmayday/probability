package com.zyd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Stage {

    private List<Door> doors;
    private final Random random = new Random();

    public Stage() {
        this.doors = randomInitDoors();
    }

    private List<Door> randomInitDoors() {
        int trueIndex = random.nextInt(3);
        doors = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            doors.add(new Door(i, i == trueIndex, false, false));
        }
        return doors;
    }

    public List<Integer> getNotOpenedDoorsIndex() {
        return doors.stream().filter(d -> !d.isOpened()).map(Door::getIndex)
                    .collect(Collectors.toList());
    }

    public List<Door> getNotChoosedDoors() {
        return doors.stream().filter(d -> !d.isChoosed()).collect(Collectors.toList());
    }

    public void chooseDoor(int index) {
        Door door = doors.get(index);
        door.setChoosed(true);
    }

    public void changeChoose(List<Integer> doorsIndex) {
        for (int i : doorsIndex) {
            Door door = doors.get(i);
            door.setChoosed(!door.isChoosed());
        }
    }

    public boolean isCorrect() {
        return this.doors.stream().filter(Door::isAnswer).anyMatch(Door::isChoosed);
    }

    @Override
    public String toString() {
        return "Stage{" +
                "doors=" + doors +
                '}';
    }
}
