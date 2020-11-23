package com.zyd;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Door {

    private int index;
    private boolean isAnswer;
    private boolean isOpened;
    private boolean isChoosed;

}
