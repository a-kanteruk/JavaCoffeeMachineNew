package net.dunice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите 'on' чтобы включить кофемашину.");
            Resourses.setTurnOn(scanner.nextLine());
            if (Resourses.getTurnOn()) {
                Logs.logMessage("Кофемашина включена.");
                setComponents();
                if (Check.checkAll()) {
                    MenuCoffeeMachine.main();
                }
            }
            Logs.logMessage("Кофемашина выключена.");
        }
    }
    public static void setComponents(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("Пожалуйста установите уровень воды. ");
                System.out.println("Допустимый уровень воды от 200 до 5000 (мл)");
                int userSetWater = scanner.nextInt();
                Resourses.setWater(userSetWater);
                if (userSetWater >= 200 && userSetWater <= 5000) {
                    Logs.logMessage("Уровень воды " + Resourses.getWater() + " (мл)");
                    break;
                }else{
                    Logs.logMessage("Вы ввели некорректный уровень воды.");
                }
            }catch(InputMismatchException exSetComponents){
                exSetComponents.getMessage();
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
                if (userSetCoffee >= 50 && userSetCoffee <= 1000) {
                    Logs.logMessage("Уровень кофе " + Resourses.getWater() + " (гр)");
                    break;
                }else{
                    Logs.logMessage("Вы ввели некорректный уровень кофе.");
                }
            }catch (InputMismatchException exSetComponents){
                exSetComponents.getMessage();
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
                if (userSetMilk >= 50 && userSetMilk <= 1000) {
                    Logs.logMessage("Уровень молока " + Resourses.getMilk() + " (мл)");
                    break;
                }else{
                    Logs.logMessage("Вы ввели некорректный уровень молока.");
                }
            }catch (InputMismatchException exSetComponents){
                exSetComponents.getMessage();
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
