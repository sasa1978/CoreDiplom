package ru.netology.javacore;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TodosTests {

    private Todos todos = new Todos();
    private static long suiteStartTime;

    @BeforeAll
    public static void initSuite() {
        System.out.println("TodosTests - старт");
        suiteStartTime = System.currentTimeMillis();
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("TodosTests - стоп: " + (System.currentTimeMillis() - suiteStartTime) + " мск.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Пробежка", "Акробатика", "Учёба"})
    public void testAddTaskEquals(String task) {
        todos.addTask(task);
        String expected = task;
        Assertions.assertEquals(expected, todos.getAllTasks());
    }

    @Test
    public void testRemoveTaskEquals() {
        String task1 = "Пробежка";
        String task2 = "Акробатика";
        String expected = task1; // Ожидаем что останется после удаления только task1

        todos.addTask(task1);
        todos.addTask(task2);
        todos.removeTask(task2);

        Assertions.assertEquals(expected, todos.getAllTasks());
    }

    @Test
    public void testAllTaskEquals() {
        String task1 = "Пробежка";
        String task2 = "Акробатика";
        String task3 = "Учеба";
        String separator = " ";
        String expected = task2 + separator + task1 + separator + task3; // Ожидаемый вывод после сортировки

        todos.addTask(task1);
        todos.addTask(task2);
        todos.addTask(task3);

        Assertions.assertEquals(expected, todos.getAllTasks());
    }
}