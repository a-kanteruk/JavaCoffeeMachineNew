package net.dunice;

import java.util.InputMismatchException;
import java.util.Scanner;
public class DrinksSubMenu {
    private static int userSubMenuChoice = 10;
    private static int recipeUserChoice;
    static Scanner scanner = new Scanner(System.in);
    public static void menu() {

        while (userSubMenuChoice > 3) {
            try {
                System.out.println("Введите необходимую опцию: ");
                System.out.println("1 - Приготовить 1 порцию выбранного напитка,");
                System.out.println("2 - Приготовить 3 порции выбранного напитка,");
                System.out.println("3 - Указать нужное количество порций,");
                userSubMenuChoice = scanner.nextInt();
                Logs.logMessage("Ваш выбор - " + userSubMenuChoice);

                switch (userSubMenuChoice) {
                    case 1:
                        MenuCoffeeMachine.amount = 1;
                        break;
                    case 2:
                        MenuCoffeeMachine.amount = 3;
                        break;
                    case 3:
                        AmountCupOfCoffee.amountCups();
                        break;
                    default:
                        Logs.logMessage("Выбрана неверная опция.");
                }
            }catch (InputMismatchException exSubMenu){
                exSubMenu.getMessage();
                Logs.logMessage("Неправильный ввод данных");
                scanner.nextLine();
            }
        }
        userSubMenuChoice = 10;
    }
    public static void recipeDrink() {
        try {
            System.out.print("Выберете напиток: ");
            System.out.println("1 - Капучино, 2 - Эспрессо.");
            recipeUserChoice = scanner.nextInt();
            switch (recipeUserChoice) {
                case 1:
                    System.out.println(MenuCoffeeMachine.cappuccino.getRecipe());
                    break;
                case 2:
                    System.out.println(MenuCoffeeMachine.espresso.getRecipe());
                    break;
                default:
                    Logs.logMessage("Выбрана неверная опция.");
            }
        }catch(InputMismatchException exRecipe){
            exRecipe.getMessage();
            Logs.logMessage("Неправильный ввод данных");
            scanner.nextLine();
        }
    }

}
