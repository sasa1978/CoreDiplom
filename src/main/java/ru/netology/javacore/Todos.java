package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        while (tasks.remove(task)); // Если есть несколько повторяющихся задач
    }

    public String getAllTasks() {
        return tasks.stream().sorted().collect(Collectors.joining(" "));
    }

}
