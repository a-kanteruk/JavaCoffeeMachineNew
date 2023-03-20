package net.dunice;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Resourses {
    static private boolean turnOn = false;
    static private int counter = 10;
    static private int milk;
    static private int coffee;
    static private int water;
    static private Map <Integer, Profile> profileMap = new HashMap<>();

    public static Map<Integer, Profile> getProfileMap() {
        return profileMap;
    }

    public static void setProfileMap(int id, Profile profile) {
        profileMap.put(id, profile);
    }

    public static void setWater(int setWater){
            water = setWater;
        }

    public static int getWater(){
        return water;
    }
    public static void setCoffee(int setCoffee){
            coffee = setCoffee;
    }
    public static int getCoffee(){
        return coffee;
    }
    public static void setMilk(int setMilk){
            milk = setMilk;
        }

    public static int getMilk(){
        return milk;
    }
    public static void setTurnOn(String setTurnOn){
        if (setTurnOn.equals("on")) {
            turnOn = true;
        }else{
            turnOn = false;
        }
    }
    public static boolean getTurnOn(){
        return turnOn;
    }
    public static void setCounter(int setCounter){
            counter = setCounter;
    }
    public static int getCounter(){
        return counter;
    }

    public static void setNewLevel(Drinks someDrink){
        setCoffee(getCoffee() - someDrink.coffee);
        setMilk(getMilk() - someDrink.milk);
        setWater(getWater() - someDrink.water);
        setCounter(getCounter() - 1);
    }

    public static void showResoursesLevel(){
        Logs.logMessage("Уровень кофе (г): " + getCoffee());
        Logs.logMessage("Уровень воды (мл): " + getWater());
        Logs.logMessage("Уровень молока (мл): " + getMilk());
        Logs.logMessage("Осталось порций до чистки кофемашины (шт): " + getCounter());
    }

    public static void mapProfile(){
        Scanner scanner = new Scanner(System.in);
        int userIdChoice;
        int amountCappuccino;
        int amountEspresso;

        try {
            while (true) {
                for (Map.Entry<Integer, Profile> item : profileMap.entrySet()) {
                    System.out.println("id " + item.getKey() + "\tИмя " + item.getValue().getName()
                            + "\tколичество капучино " + item.getValue().getCapCount() + "\tколичество эспрессо "
                            + item.getValue().getEspCount());
                }
                System.out.println("Выберите id нужного профиля.");
                userIdChoice = scanner.nextInt();
                if (profileMap.containsKey(userIdChoice)) {
                    Profile userProfile = profileMap.get(userIdChoice);
                    amountCappuccino = userProfile.getCapCount();
                    amountEspresso = userProfile.getEspCount();
                    break;
                }else{
                    Logs.logMessage("Данного id не существует.");
                }
            }
            for (int i = 1; i <= amountCappuccino; i++) {
                if (Check.checkAll()) {
                    Resourses.setNewLevel(MenuCoffeeMachine.cappuccino);
                    Logs.logMessage("Ваш капучино готов.");
                } else {
                    Logs.logMessage("Порция капучино не была приготовлена");
                    break;
                }
            }
            for (int i = 1; i <= amountEspresso; i++) {
                if (Check.checkAll()) {
                    Resourses.setNewLevel(MenuCoffeeMachine.espresso);
                    Logs.logMessage("Ваш эспрессо готов.");
                } else {
                    Logs.logMessage("Порция эспрессо не была приготовлена");
                    break;
                }
            }
        }catch(InputMismatchException exExpressProfile){
            exExpressProfile.getMessage();
            Logs.logMessage("Неправильный ввод данных");
            scanner.nextLine();
        }
    }
}


