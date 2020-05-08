package com.zju.nir.common.xenum;

import lombok.Getter;

import static com.zju.nir.common.constant.TaskIdConstant.*;


@Getter
public enum TaskTypeEnum {

    //Rey复杂图形记忆任务
    REY_COMPLEX_FIGURE_MEMORY_TASK("Rey复杂图形记忆任务", REY),

    //数字字母连线测验
    DIGIT_ALPHABET_LINKING_TASK("数字字母连线任务", LINKING),

    //Stroop色词命名任务
    STROOP_COLOR_WORDS_TASK("Stroop色词命名任务", STROOP),


    RESTING_STATE_TASK("静息态任务", REST),

    SNAP_TASK("斯诺佩评估量表", SNAP);



    /**
     * 任务的中文名称
     */
    private String taskChineseName;
    /**
     * 任务标识符
     */
    private Integer taskIdentifier;

    TaskTypeEnum(String taskChineseName,  int taskIdentifier) {
        this.taskChineseName = taskChineseName;
        this.taskIdentifier = taskIdentifier;
    }

    @Override
    public String toString() {
        return "任务" + taskIdentifier + ": " + taskChineseName;
    }
}