package net.dunice;

import java.util.ArrayList;
import java.util.List;
public class Logs {
    static List logsMessage = new ArrayList<String>();
    public static void logMessage(String someMessage){
        logsMessage.add(someMessage);
        System.out.println(someMessage);
    }

    public static void showLogsList(){
        System.out.println("Логи:");
        for (Object i : logsMessage){
            System.out.println(i);
        }
        System.out.println();
    }
}
