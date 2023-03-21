package net.dunice;

import java.util.ArrayList;
import java.util.List;

public class Logs {
    private static int countCapCappuccino = 0;
    private static int countCapEspresso = 0;
    static List<String> logsMessage = new ArrayList<>();
    public static void logMessage(String someMessage){
        logsMessage.add(someMessage);
        System.out.println(someMessage);
        if (someMessage.equals("Ваш капучино готов.")) {
            countCapCappuccino++;
        } else if (someMessage.equals("Ваш эспрессо готов.")) {
            countCapEspresso++;
        }
    }


    public static void showLogsList(){
        System.out.println("Логи:");
        for (String i : logsMessage){
            System.out.println(i);
        }
        System.out.println("Количество приготовленных капучино - " + countCapCappuccino + "\n"
                            + "Количество приготовленных эспрессо - " + countCapEspresso);
        System.out.println();
    }
}
