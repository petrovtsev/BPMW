package com.bpmw.web.model.task;

import java.util.Comparator;

import com.bpmw.persistence.Task;
import org.primefaces.model.SortOrder;

public class LazySorter implements Comparator<Task> {

    private String sortField;

    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int compare(Task task1, Task task2) {
        try {
            Object value1 = Task.class.getField(this.sortField).get(task1);
            Object value2 = Task.class.getField(this.sortField).get(task2);

            int value = ((Comparable)value1).compareTo(value2);

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}