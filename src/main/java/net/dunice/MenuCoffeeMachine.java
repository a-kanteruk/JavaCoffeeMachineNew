package net.dunice;

import java.util.InputMismatchException;
import static net.dunice.Main.scanner;

public class MenuCoffeeMachine {
    static int amount;

    public static void mainMenu() {
        while (true) {
            amount = 1;
            System.out.println("""
                    Введите свой выбор:
                    1 - Капучино, 2 - Эспрессо, 3 - Очистка кофемашины, 4 - Загрузка компонентов,
                    5 - Показать уровень компонентов, 6 - Показать логи, 7 - посмотреть рецепт напитка,
                    8 - Выбрать профиль, 9 - Создать пользовательский профиль, 0 - Выключить кофемашину.""");
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
                DrinksSubMenu.flag = true;
                DrinksSubMenu.menu();
            } else if (userChoice == 0) {
                Resourses.setTurnOn("off");
                return 0;
            }

            switch (userChoice) {
                case 1:
                    Drinks.createDrink(Drinks.CAPPUCCINO);
                    return 1;
                case 2:
                    Drinks.createDrink(Drinks.ESPRESSO);
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
            Logs.logMessage("Неправильный ввод данных");
            scanner.nextLine();
            return 10;
        }
    }
    public static int getAmount(){
        return amount;
    }

    public static void setAmount(int newAmount){
        MenuCoffeeMachine.amount = newAmount;
    }

}
