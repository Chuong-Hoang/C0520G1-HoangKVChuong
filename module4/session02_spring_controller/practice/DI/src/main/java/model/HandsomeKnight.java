package model;

import repository.Knight;
import service.Task;

public class HandsomeKnight implements Knight {
    // attribute
    private Task task;

    // constructor without parameter
    public HandsomeKnight() {
    }

    // constructor with parameter (Task task)
    public HandsomeKnight(Task task) {
        this.task = task;
    }

    // setter
    public void setTask(Task task) {
        this.task = task;
    }

    // override (abstract) method of the interface Knight
    @Override
    public String operate() {
        return task.doTask();
    }
}
