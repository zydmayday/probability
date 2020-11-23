package com.zyd;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Host {
    public void openDoorFrom(Stage stage) {
        List<Door> doors = stage.getNotChoosedDoors();
        doors = doors.stream().filter(d -> !d.isAnswer()).collect(Collectors.toList());
        Collections.shuffle(doors);
        doors.get(0).setOpened(true);
    }
}
