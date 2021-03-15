package ua.kpi.comsys.IO8230;

import static ua.kpi.comsys.IO8230.Lab1_2Part1.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Частина 1\n");
        lab1_2Part1();

        System.out.println("\nЧастина 2\n");
        TimeYY testHour1 = new TimeYY();
        TimeYY testHour2 = new TimeYY(5, 5, 5);
        TimeYY testHour3 = new TimeYY(10, 10, 10);
        TimeYY testHour4 = new TimeYY(22, 55, 55);

        System.out.println("testHour1: " + testHour1.get());
        System.out.println("testHour2: " + testHour2.get());
        System.out.println("testHour3: " + testHour3.get());
        System.out.println("testHour4: " + testHour4.get());

        System.out.println("\nSum testHour1 and testHour2:\n" + testHour1.add(testHour2).get());
        System.out.println("\nSum testHour2 and testHour3:\n" + testHour2.add(testHour3).get());
        System.out.println("\nSum testHour3 and testHour4:\n" + testHour3.add(testHour4).get());

        System.out.println("\nSubstract testHour1 and testHour2:\n" + testHour1.substract(testHour2).get());
        System.out.println("\nSubstract testHour2 and testHour3:\n" + testHour2.substract(testHour3).get());
        System.out.println("\nSubstract testHour3 and testHour4:\n" + testHour3.substract(testHour4).get());

    }
}
