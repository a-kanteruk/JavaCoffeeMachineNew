package net.dunice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите 'on' чтобы включить кофемашину.");
            Resourses.setTurnOn(scanner.nextLine());
            if (Resourses.getTurnOn()) {
                Logs.logMessage("Кофемашина включена.");
                setComponents();
                if (Check.checkAll()) {
                    MenuCoffeeMachine.mainMenu();
                }
            }
            Logs.logMessage("Кофемашина выключена.");
            scanner.nextLine();
        }
    }
    public static void setComponents(){
        while(true) {
            try {
                System.out.print("Пожалуйста установите уровень воды. ");
                System.out.println("Допустимый уровень воды от 200 до 5000 (мл)");
                int userSetWater = scanner.nextInt();
                Resourses.setWater(userSetWater);
                if (userSetWater >= Check.waterMin && userSetWater <= Check.waterMax) {
                    Logs.logMessage("Уровень воды " + Resourses.getWater() + " (мл)");
                    break;
                }else{
                    Logs.logMessage("Вы ввели некорректный уровень воды.");
                }
            }catch(InputMismatchException exSetComponents){
                Logs.logMessage("Неправильный ввод данных");
                scanner.nextLine();
            }
        }
        while(true) {
            try {
                System.out.print("Пожалуйста установите уровень кофе. ");
                System.out.println("Допустимый уровень кофе от 50 до 1000 (мл)");
                int userSetCoffee = scanner.nextInt();
                Resourses.setCoffee(userSetCoffee);
                if (userSetCoffee >= Check.coffeeMin && userSetCoffee <= Check.coffeeMax) {
                    Logs.logMessage("Уровень кофе " + Resourses.getWater() + " (гр)");
                    break;
                }else{
                    Logs.logMessage("Вы ввели некорректный уровень кофе.");
                }
            }catch (InputMismatchException exSetComponents){
                Logs.logMessage("Неправильный ввод данных");
                scanner.nextLine();
            }
        }
        while(true){
            try {
                System.out.print("Пожалуйста установите уровень молока. ");
                System.out.println("Допустимый уровень молока от 50 до 1000 (мл)");
                int userSetMilk = scanner.nextInt();
                Resourses.setMilk(userSetMilk);
                if (userSetMilk >= Check.milkMin && userSetMilk <= Check.milkMax) {
                    Logs.logMessage("Уровень молока " + Resourses.getMilk() + " (мл)");
                    break;
                }else{
                    Logs.logMessage("Вы ввели некорректный уровень молока.");
                }
            }catch (InputMismatchException exSetComponents){
                Logs.logMessage("Неправильный ввод данных");
                scanner.nextLine();
            }
        }
    }
    public static void cleanTheCoffeeMachine(){
        if (Resourses.getCounter() < 1){
            Logs.logMessage("Идёт чистка кофемашины");
            Resourses.setCounter(10);
            Logs.logMessage("Чистка кофемашины прошла успешно");
        }else{
            Logs.logMessage("Чистка кофемашины не требуется");
        }
    }
}
