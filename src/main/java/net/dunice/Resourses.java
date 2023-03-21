package net.dunice;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import static net.dunice.Main.scanner;

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
        int userIdChoice;
        Profile userProfile;

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
                    userProfile = profileMap.get(userIdChoice);
                    break;
                }else{
                    Logs.logMessage("Данного id не существует.");
                }
            }
            MenuCoffeeMachine.setAmount(userProfile.getCapCount());
            Drinks.createDrink(Drinks.CAPPUCCINO);
            MenuCoffeeMachine.setAmount(userProfile.getEspCount());
            Drinks.createDrink(Drinks.ESPRESSO);

        }catch(InputMismatchException exExpressProfile){
            Logs.logMessage("Неправильный ввод данных");
            scanner.nextLine();
        }
    }
}
