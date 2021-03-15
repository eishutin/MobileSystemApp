package ua.kpi.comsys.IO8230;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Lab1_2Part1 {

    public static int randomValue(int maxValue) {
        Random random = new Random();
        switch (random.nextInt(6)) {
            case 1:
                return (int) (maxValue * 0.7);
            case 2:
                return (int) (maxValue * 0.9);
            case 3:
            case 4:
            case 5:
                return maxValue;
            default:
                return 0;
        }
    }

    public static void lab1_2Part1() {
        // Частина 1
        // Дано рядок у форматі "Student1 - Group1; Student2 - Group2; ..."
        String studentsStr = " Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82;" +
                " Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83;" +
                " Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія - ІВ-82; Головенець Руслан - ІВ-83;" +
                " Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81;" +
                " Снігурець Олег - ІВ-81; Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81;" +
                " Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Іванов Володимир - ІО-81; Востриков Нікіта - ІО-82;" +
                " Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81; Дровнін Павло - ІВ-83;" +
                " Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83;" +
                " Іванов Дмитро - ІВ-82";

        // Завдання 1
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – відсортований масив студентів, які відносяться до відповідної групи

        // Ваш код починається тут

        ArrayList<String> groupsLists = new ArrayList<>();
        ArrayList<String> IO81GroupList = new ArrayList<>();
        ArrayList<String> IO82GroupList = new ArrayList<>();
        ArrayList<String> IO83GroupList = new ArrayList<>();
        ArrayList<String> IV81GroupList = new ArrayList<>();
        ArrayList<String> IV82GroupList = new ArrayList<>();
        ArrayList<String> IV83GroupList = new ArrayList<>();
        ArrayList<String> IP81GroupList = new ArrayList<>();
        ArrayList<String> IP82GroupList = new ArrayList<>();

        HashMap<String, ArrayList<String>> studentsGroups = new HashMap<>();
        studentsGroups.put("ІО-81", IO81GroupList);
        studentsGroups.put("ІО-82", IO82GroupList);
        studentsGroups.put("ІО-83", IO83GroupList);
        studentsGroups.put("ІВ-81", IV81GroupList);
        studentsGroups.put("ІВ-82", IV82GroupList);
        studentsGroups.put("ІВ-83", IV83GroupList);
        studentsGroups.put("ІП-83", IP81GroupList);
        studentsGroups.put("ІП-84", IP82GroupList);

        Collections.addAll(groupsLists, studentsStr.split(";"));

        for (String groupsList : groupsLists) {
            String[] student = groupsList.split(" - ");
            studentsGroups.get(student[1]).add(student[0]);
        }

        for (String groupsList : studentsGroups.keySet()) {
            Collections.sort(studentsGroups.get(groupsList));
        }

        // Ваш код закінчується тут

        System.out.println("Завдання 1");
        for (Map.Entry<String, ArrayList<String>> entry : studentsGroups.entrySet())
            System.out.println(entry.getKey() + "  --->  " + entry.getValue());
        System.out.println();

        // Дано масив з максимально можливими оцінками

        int[] points = {12, 12, 12, 12, 12, 12, 12, 16};

        // Завдання 2
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – словник, де:
        // - ключ – студент, який відносяться до відповідної групи
        // - значення – масив з оцінками студента (заповніть масив випадковими значеннями,
        //      використовуючи функцію `randomValue(maxValue: Int) -> Int`)

        // Ваш код починається тут

        HashMap<String, HashMap<String, ArrayList<Integer>>> marksOfStudents = new HashMap<>();

        for (String group : studentsGroups.keySet()) {
            marksOfStudents.put(group, new HashMap<>());
            for (String student : studentsGroups.get(group)) {
                marksOfStudents.get(group).put(student, new ArrayList<>());
                for (int mark : points) {
                    marksOfStudents.get(group).get(student).add(randomValue(mark));
                }
            }
        }

        // Ваш код закінчується тут

        System.out.println("Завдання 2");
        for (String group : marksOfStudents.keySet()) {
            System.out.println(group);
            for (String student : marksOfStudents.get(group).keySet()) {
                System.out.print(student + "  --->  " + "[");
                for (Integer mark : marksOfStudents.get(group).get(student)) {
                    System.out.print(mark + " ");
                }
                System.out.print("]");
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();

        // Завдання 3
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – словник, де:
        //   - ключ – студент, який відносяться до відповідної групи
        //   - значення – сума оцінок студента

        // Ваш код починається тут

        HashMap<String, HashMap<String, Integer>> marksSum = new HashMap<>();

        for (String group : studentsGroups.keySet()) {
            marksSum.put(group, new HashMap<>());
            for (String student : studentsGroups.get(group)) {
                int sum = 0;
                for (int mark : marksOfStudents.get(group).get(student)) {
                    sum += mark;
                }
                marksSum.get(group).put(student, sum);
            }
        }

        // Ваш код закінчується тут

        System.out.println("Завдання 3");
        for (String group : marksSum.keySet()) {
            System.out.println(group);
            for (String students : marksSum.get(group).keySet()) {
                System.out.print(students + "  --->  " + marksSum.get(group).get(students) + "\n");
            }
            System.out.println();
        }

        // Завдання 4
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – середня оцінка всіх студентів групи

        // Ваш код починається тут

        HashMap<String, Float> averageMarkOfGroup = new HashMap<>();

        for (String group : marksSum.keySet()) {
            float countOfMarks = 0;
            int sum = 0;
            for (String student : marksSum.get(group).keySet()) {
                countOfMarks++;
                sum += marksSum.get(group).get(student);
            }
            averageMarkOfGroup.put(group, sum / countOfMarks);
        }

        // Ваш код закінчується тут
        System.out.println("Завдання 4");
        for (String group : averageMarkOfGroup.keySet()) {
            System.out.println(group + "  --->  " + averageMarkOfGroup.get(group));
        }

        System.out.println();

        // Завдання 5
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – масив студентів, які мають >= 60 балів

        // Ваш код починається тут

        HashMap<String, ArrayList<String>> examinedStudentsOfGroups = new HashMap<>();

        for (String group : studentsGroups.keySet()) {
            examinedStudentsOfGroups.put(group, new ArrayList<>());
            for (String student : studentsGroups.get(group)) {
                if (marksSum.get(group).get(student) >= 60) {
                    examinedStudentsOfGroups.get(group).add(student);
                }
            }
        }

        // Ваш код закінчується тут
        System.out.println("Завдання 5");
        for (Map.Entry<String, ArrayList<String>> entry : examinedStudentsOfGroups.entrySet()) {
            System.out.println(entry.getKey() + "  --->  " + entry.getValue());
        }

        System.out.println();
    }
}
