package net.dunice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCoffeeMachine {
    static int amount;
    static Scanner scanner = new Scanner(System.in);
    static Drinks cappuccino = Drinks.CAPPUCCINO;
    static Drinks espresso = Drinks.ESPRESSO;

    public static void main() {
        while (true) {
            amount = 1;
            System.out.println("Введите свой выбор:");
            System.out.println("1 - Капучино, 2 - Эспрессо, 3 - Очистка кофемашины, 4 - Загрузка компонентов,");
            System.out.println("5 - Показать уровень компонентов, 6 - Показать логи, 7 - посмотреть рецепт напитка.");
            System.out.println("8 - Выбрать профиль, 9 - Создать пользовательский профиль, 0 - Выключить кофемашину.");
            int userChoiceMain = menu();
            if (userChoiceMain == 0) {
                break;
            }
        }
    }

    public static int menu() {
        try {
            int userChoice = scanner.nextInt();
            Logs.logMessage("Ваш выбор " + userChoice);
            if (userChoice == 1 || userChoice == 2) {
                DrinksSubMenu.menu();
            } else if (userChoice == 0) {
                Resourses.setTurnOn("off");
                return 0;
            }

            switch (userChoice) {
                case 1:
                    if (amount > 0) {
                        for (int i = 1; i <= amount; i++) {
                            if (Check.checkAll()) {
                                Resourses.setNewLevel(cappuccino);
                                Logs.logMessage("Ваш капучино готов.");
                            } else {
                                Logs.logMessage("Порция капучино не была приготовлена");
                                break;
                            }
                        }
                    }
                    return 1;
                case 2:
                    if (amount > 0) {
                        for (int i = 1; i <= amount; i++) {
                            if (Check.checkAll()) {
                                Resourses.setNewLevel(espresso);
                                Logs.logMessage("Ваш эспрессо готов.");
                            } else {
                                Logs.logMessage("Порция эспрессо не была приготовлена");
                                break;
                            }
                        }
                    }
                    return userChoice;
                case 3:
                    Main.cleanTheCoffeeMachine();
                    return userChoice;
                case 4:
                    Main.setComponents();
                    return userChoice;
                case 5:
                    Resourses.showResoursesLevel();
                    return userChoice;
                case 6:
                    Logs.showLogsList();
                    return userChoice;
                case 7:
                    DrinksSubMenu.recipeDrink();
                    return userChoice;
                case 8:
                    Resourses.mapProfile();
                    return userChoice;
                case 9:
                    Profile.createProfile();
                    return userChoice;
                default:
                    Logs.logMessage("В меню нет данной опции.");
                    return userChoice;
            }
        } catch (InputMismatchException exMenu) {
            exMenu.getMessage();
            Logs.logMessage("Неправильный ввод данных");
            scanner.nextLine();
            return 10;
        }
    }
}